
package com.monitor.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * JSON结果类型
 * 
 * @author lenovo
 *
 */
@JsonFormat(shape = Shape.NUMBER)
public enum JsonResultType {
	NORMAL, FAILED, NOLOGIN, NOAUTHOR;
}