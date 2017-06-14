package com.monitor.test.https;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

/**
 * 
 * Title:利用HttpClient进行post请求的工具类
 * 
 * @author zhangwr
 * @date 2017年5月5日下午3:58:12
 */
public class HttpClientUtil {
	/**
	 * 
	 * Description:HTTPS执行POST请求
	 * 
	 * @param url：请求的URL
	 * @param jsonParam：json串体提交数据
	 * @param formParam：form表单提交数据
	 * @param httpType：http请求类型：HTTP，HTTPS
	 * @return String:响应内容
	 * @author zhangwr
	 * @date 2017年5月5日下午4:35:27
	 */
	public static String doPost(String url, String jsonParam, Map<String, Object> formParam, String httpType) {
		CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpPost = new HttpPost(url);
			if (StringUtils.isBlank(jsonParam)) {
				// 表单方式设置参数
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				@SuppressWarnings("rawtypes")
				Iterator iterator = formParam.entrySet().iterator();
				while (iterator.hasNext()) {
					@SuppressWarnings("unchecked")
					Entry<String, Object> elem = (Entry<String, Object>) iterator.next();
					list.add(new BasicNameValuePair(elem.getKey(), elem.getValue().toString()));
				}
				if (list.size() > 0) {
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
					httpPost.setEntity(entity);
				}
			} else {
				// json方式设置参数
				StringEntity entity = new StringEntity(jsonParam, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				httpPost.setEntity(entity);
			}
			httpClient = createHttpClientDefault(httpType);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				if (response != null) {
					int statusCode = response.getStatusLine().getStatusCode();
					if (statusCode == HttpStatus.SC_OK) {
						HttpEntity resEntity = response.getEntity();
						if (resEntity != null) {
							result = EntityUtils.toString(resEntity, "UTF-8");
							EntityUtils.consume(resEntity);
						}
					} else {
						throw new Exception("调用结果状态不为200，状态为：" + statusCode);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (response != null) {
					response.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 *
	 * Description:创建HttpClient
	 * 
	 * @param httpType
	 * @return CloseableHttpClient
	 * @author zhangwr
	 * @date 2017年5月5日下午5:37:01
	 */
	public static CloseableHttpClient createHttpClientDefault(String httpType) {
		try {
			// Https请求
			if (httpType.equals("https")) {
				SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
					// 信任所有,忽略证书
					public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
						return true;
					}
				}).build();
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
				return HttpClients.custom().setSSLSocketFactory(sslsf).build();
			} else if (httpType.equals("http")) {
				return HttpClients.createDefault();
			}
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return null;
	}
}