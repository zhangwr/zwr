
package com.monitor.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monitor.utils.JsonResult;
import com.monitor.utils.MyRuntimeException;

@ControllerAdvice
public class BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	@ExceptionHandler
	@ResponseBody
	public JsonResult exceptionHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
		JsonResult errorResult = null;
		if (e instanceof MyRuntimeException || e.getCause() instanceof MyRuntimeException) {
			LOGGER.info("自定义异常:" + e.getMessage());
			errorResult = JsonResult.failed(e.getMessage());
		} else if (e instanceof IOException || e.getCause() instanceof IOException) {
			LOGGER.error("IO异常:" + e.getMessage(), e);
			errorResult = JsonResult.failed("IO异常");
		} else if (e instanceof HttpRequestMethodNotSupportedException
				|| e.getCause() instanceof HttpRequestMethodNotSupportedException) {
			LOGGER.error("不支持GET请求" + e.getMessage(), e);
			errorResult = JsonResult.failed("不支持GET请求");
		} else {
			LOGGER.error("未捕获的异常:" + e.getMessage(), e);
			errorResult = JsonResult.failed("系统错误，原因：" + e.getMessage());
		}
		return errorResult;
	}
}
