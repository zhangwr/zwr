package com.mq.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * 
 * json工具类
 * 
 * 
 */
public class JSONUtil {
	private final static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 创建一个新的实例 JSONUtil.
	 *
	 */
	public JSONUtil() {
	}

	public static ObjectMapper getInstance() {
		return objectMapper;
	}

	/**
	 * 实体转json
	 * 
	 * @param obj
	 *            转换的实体
	 */
	public static String beanToJson(Object obj) throws Exception {
		return objectMapper.writeValueAsString(obj);
	}

	/**
	 * 实体转byte数组
	 * 
	 * @param obj
	 *            转换的实体
	 */
	public static byte[] beanTobytes(Object obj) {
		String json = null;
		try {
			json = objectMapper.writeValueAsString(obj);
			return json.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * json转实体
	 * 
	 * @param jsonStr
	 *            要转换的json数据
	 * @param clazz
	 *            实体类
	 */
	public static <T> T jsonToBean(String jsonStr, Class<T> clazz) throws Exception {
		return objectMapper.readValue(jsonStr, clazz);
	}

	/**
	 * 移除不需要的字段属性
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T jsonToBeanNotContainUnknown(String jsonStr, Class<T> clazz) throws Exception {
		objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper.readValue(jsonStr, clazz);
	}

	/**
	 * 对象转换成字节数组
	 * <p>
	 * 针对比较大的数据做压缩
	 * </P>
	 * 
	 */
	public static byte[] object2Bytes(Object message) throws IOException {
		if (message instanceof byte[]) {
			return (byte[]) message;
		}

		byte[] result = JSONUtil.beanTobytes(message);

		// gzip 压缩
		result = StringUtil.gzip(result);

		return result;
	}

	/**
	 * 字节数组转对象
	 * 
	 * @param message
	 * @return
	 */
	public static Object bytes2Object(byte[] message, String msgType) throws ClassNotFoundException, IOException {

		// 类型为空直接返回
		if (msgType == null) {
			return message;
		}

		Class<?> messageObjClass = Class.forName(msgType);

		// gzip 解压
		message = StringUtil.unZip2(message);

		return JSONUtil.bytesToBean(message, messageObjClass);

	}

	/**
	 * json转map
	 * 
	 * @param jsonStr
	 *            要转换的json数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Map<String, Object> jsonToMap(String jsonStr) throws Exception {
		return objectMapper.readValue(jsonStr, Map.class);
	}

	/**
	 * json转map
	 * 
	 * @param jsonStr
	 *            要转换的json数据
	 * @param clazz
	 *            实体类
	 * @return
	 * @throws Exception
	 */
	public static <T> Map<String, T> jsonToMap(String jsonStr, Class<T> clazz) throws Exception {
		Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr, new TypeReference<Map<String, T>>() {
		});
		Map<String, T> result = new HashMap<String, T>();
		for (Entry<String, Map<String, Object>> entry : map.entrySet()) {
			result.put(entry.getKey(), mapToBean(entry.getValue(), clazz));
		}
		return result;
	}

	/**
	 * bytes 数据转换为对象
	 * 
	 * @param bytes
	 *            字节数据
	 * @param className
	 *            对象类名
	 * @return 当 className为list时返回 list<LinkedHashMap>
	 * @throws Exception
	 */
	public static <T> Object bytesToBean(byte[] bytes, String className) throws Exception {
		Class<?> clazz = Class.forName(className);
		String json = new String(bytes);
		if (List.class.isAssignableFrom(clazz)) {
			return jsonToList(json);
		} else if (Map.class.isAssignableFrom(clazz)) {
			return jsonToMap(json);
		} else {
			try {
				return JSONUtil.jsonToBean(json, clazz);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * byte数组转实体
	 * 
	 * @param bytes
	 *            要转换的json数据
	 * @param clazz
	 *            实体类
	 * @return
	 */
	public static <T> T bytesToBean(byte[] bytes, Class<T> clazz) {
		String json = new String(bytes);
		try {
			return JSONUtil.jsonToBean(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T bytesToBeanNotContainUnknown(byte[] bytes, Class<T> clazz) {
		objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String json = new String(bytes);
		try {
			return JSONUtil.jsonToBean(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * byte数组转map
	 * 
	 * @param bytes
	 *            byte数组
	 * @param clazz
	 *            实体类
	 * @return
	 */
	public static <T> Map<String, T> bytesToMap(byte[] bytes, Class<T> clazz) {
		String json = new String(bytes);
		try {
			return JSONUtil.jsonToMap(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 实体转map
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map beanToMap(Object obj) throws Exception {
		return JSONUtil.jsonToBean(JSONUtil.beanToJson(obj), Map.class);
	}

	/**
	 * 实体转map Map<String, Object>
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> beanToMapObject(Object obj) throws Exception {
		return JSONUtil.jsonToMap(JSONUtil.beanToJson(obj));
	}

	/**
	 * map转实体
	 * 
	 * @param map
	 *            map对象
	 * @param clazz
	 *            实体类
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T mapToBean(Map map, Class<T> clazz) {
		return objectMapper.convertValue(map, clazz);
	}

	/**
	 * json转list
	 * 
	 * @param jsonArrayStr
	 *            json数据
	 * @return 返回结果为 list<linkedHashMap>
	 */
	public static List<Object> jsonToList(String jsonArrayStr) throws Exception {
		List<Object> list = objectMapper.readValue(jsonArrayStr, new TypeReference<List<Object>>() {
		});
		return list;
	}

}
