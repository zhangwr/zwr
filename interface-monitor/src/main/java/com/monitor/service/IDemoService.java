package com.monitor.service;

import java.util.List;

import com.monitor.entity.Demo;
import com.monitor.model.DemoModel;
import com.monitor.utils.OperationResult;

/**
 * 
 * Title:
 * 
 * @author zhangwr
 * @date 2017年4月6日上午10:14:20
 */
public interface IDemoService extends IBaseService<Demo> {

	/**
	 * 
	 * <p>
	 * Title: getByName
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param name
	 * @return List<Demo>
	 * @author zhangwr
	 * @date 2017年4月6日上午10:07:39
	 */
	List<Demo> getByName(String name);

	/**
	 * 
	 * Description:
	 * 
	 * @param obj
	 *            实体
	 * @return OperationResult
	 * @author zhangwr
	 * @date 2017年4月6日上午10:10:56
	 */
	OperationResult saveTest(DemoModel obj);

}
