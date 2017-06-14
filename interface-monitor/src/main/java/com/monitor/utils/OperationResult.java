
package com.monitor.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 操作结果类
 */
public class OperationResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean _success;
	private List<String> _errs;

	public static final OperationResult SUCCEED = new OperationResult();

	private OperationResult() {
		_success = true;
	}

	/**
	 * 根据指定的错误消息初始化 {@linkplain OperationResult} 类的新实例。
	 * 
	 * @param errors
	 *            错误信息数组。
	 */
	public OperationResult(String... errors) {
		this(Arrays.asList(errors));
	}

	/**
	 * 根据指定的错误消息集合初始化 {@linkplain OperationResult} 类的新实例。
	 * 
	 * @param errors
	 *            错误信息集合。
	 */
	public OperationResult(Collection<String> errors) {
		if (null == errors)
			errors = Arrays.asList("发生未知错误。");

		_success = false;
		_errs = new ArrayList<String>(errors);
	}

	/**
	 * 确认操作是否成功。
	 */
	public boolean isSuccess() {
		return _success;
	}

	/**
	 * 获取产生操作失败的所有错误信息集合。
	 * 
	 * @return 返回导致操作失败的所有错误信息的集合。
	 */
	public List<String> getErrors() {
		return _errs;
	}

	/**
	 * 根据指定的错误信息创建失败的操作结果。
	 * 
	 * @param error
	 *            错误信息。
	 */
	public static final OperationResult failed(String error) {
		return new OperationResult(error);
	}

	/**
	 * 根据指定的错误信息数组创建失败的操作结果。
	 * 
	 * @param errors
	 *            错误信息数组。
	 */
	public static final OperationResult failed(String... errors) {
		return failed(Arrays.asList(errors));
	}

	/**
	 * 根据指定的错误信息集合创建失败的操作结果。
	 * 
	 * @param errors
	 *            错误信息集合。
	 */
	public static final OperationResult failed(Collection<String> errors) {
		return new OperationResult(errors);
	}

	public void addErrors(String... errors) {
		_errs.addAll(Arrays.asList(errors));
	}
}