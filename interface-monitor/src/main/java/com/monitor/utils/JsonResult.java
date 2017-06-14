
package com.monitor.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * JSON响应对象
 * 
 * @author lenovo
 *
 */
public class JsonResult {
	private Object data;
	private String message;
	private boolean success;
	//private JsonResultType type;
	
	private Integer code;

	public static final JsonResult FAILED = new JsonResult(false, null, null);
	public static final JsonResult SUCCEED = new JsonResult(true, null, null);

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccess() {
		return success;
	}

//	public JsonResultType getType() {
//		return type;
//	}
	
	public Integer getCode() {
		return code;
	}

	public JsonResult(boolean success, Object data, String message) {
		this.data = data;
		this.success = success;
		//this.type = success ? JsonResultType.NORMAL : JsonResultType.FAILED;
		this.code = success ? JsonResultCode.SUCCESS.getValue() : JsonResultCode.ERROR.getValue();
		this.message = null != message ? message : (success ? "操作成功" : "操作失败");
	}

	

	public JsonResult(boolean success, Object data, String message, Integer code) {
		this.data = data;
		this.success = success;
		//this.type = type;
		this.code=code;
		this.message = null != message ? message : (success ? "操作成功" : "操作失败");
	}

	public static JsonResult from(OperationResult operationResult) {
		if (operationResult.isSuccess()) {
			return JsonResult.SUCCEED;
		}
		List<String> errs = operationResult.getErrors();
		return new JsonResult(false, errs, null);
	}

	public static JsonResult success(String message) {
		return new JsonResult(true, null, message);
	}

	public static JsonResult success(Object data) {
		return new JsonResult(true, data, null);
	}

	public static JsonResult success(Object data, String message) {
		return new JsonResult(true, data, message);
	}

	public static JsonResult failed(String message) {
		return new JsonResult(false, null, message);
	}

	public static JsonResult failed(Object data) {
		return new JsonResult(false, data, null);
	}

	public static JsonResult failed(Object data, String message) {
		return new JsonResult(false, data, message);
	}

	public static JsonResult from(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			Map<String, String> errMap = new HashMap<String, String>(errors.size());
			for (FieldError error : errors) {
				errMap.put(error.getField(), error.getDefaultMessage());
			}
			return new JsonResult(false, errMap, null,JsonResultCode.MODELERROR.getValue());
		}
		return SUCCEED;
	}
}