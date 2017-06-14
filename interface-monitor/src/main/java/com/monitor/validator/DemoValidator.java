package com.monitor.validator;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monitor.entity.Demo;
import com.monitor.model.DemoModel;
import com.monitor.service.IDemoService;
import com.monitor.utils.OperationResult;
import com.monitor.utils.ValidatorUtil;

/**
 * 实体参数验证器和业务逻辑验证器
 * 
 * @author lenovo
 *
 */
@Component
public class DemoValidator {

	@Autowired
	private IDemoService demoService;

	public OperationResult validateObj(DemoModel item) {
		Map<String, String> validate = ValidatorUtil.validate(item);
		if (validate == null) {
			// 数据库验证
			List<Demo> lists = demoService.getByName(item.getDemo().getName());
			if (lists != null && lists.size() > 0) {
				return OperationResult.failed("名称必须唯一");
			} else {
				return OperationResult.SUCCEED;
			}
		} else {
			// Validator注解验证
			return OperationResult.failed(validate.values());
		}
	}

}
