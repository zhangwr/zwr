//package com.monitor.test.https;
//
//import java.util.HashMap;
//import java.util.Map;
//
////对接口进行测试
//public class TestMain {
//	private String url = "https://192.168.1.101/";
//	private String charset = "utf-8";
//	private HttpClientUtil httpClientUtil = null;
//
//	public TestMain() {
//		httpClientUtil = new HttpClientUtil();
//	}
//
//	public void test() {
//		String httpOrgCreateTest = url + "httpOrg/create";
//		Map<String, Object> createMap = new HashMap<String, Object>();
//		createMap.put("authuser", "*****");
//		createMap.put("authpass", "*****");
//		createMap.put("orgkey", "****");
//		createMap.put("orgname", "****");
//		String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest, null, createMap,"https");
//		System.out.println("result:" + httpOrgCreateTestRtn);
//	}
//
//	public static void main(String[] args) {
//		HttpClientUtil httpClientUtil = new HttpClientUtil();
//		Map<String, Object> createMap = new HashMap<String, Object>();
//		createMap.put("authuser", "*****");
//		createMap.put("authpass", "*****");
//		createMap.put("orgkey", "****");
//		createMap.put("orgname", "****");
//		String httpOrgCreateTestRtn = httpClientUtil.doPost("https://fapiao.chinaums.com/fapiao-api-test/", null,
//				createMap,"https");
//		System.out.println("结果:" + httpOrgCreateTestRtn);
//	}
//}