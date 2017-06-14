
package com.monitor.utils;

public class MyRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MyRuntimeException() {
		super("应用发生未知错误。");
	}

	public MyRuntimeException(String message) {
		super(message);
	}

	public MyRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyRuntimeException(Throwable cause) {
		super(cause);
	}
}