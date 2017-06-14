package com.monitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitor.entity.Demo;
import com.monitor.mapper.DemoMapper;
import com.monitor.model.DemoModel;
import com.monitor.service.IDemoService;
import com.monitor.utils.MyMapper;
import com.monitor.utils.OperationResult;
import com.monitor.validator.DemoValidator;

@Service
@Transactional
public class DemoServiceImpl extends BaseServiceImpl<Demo> implements IDemoService {

	@Autowired
	private DemoMapper demoMapper;

	@Autowired
	private DemoValidator demoValidator;

	@Override
	public List<Demo> getByName(String name) {
		return demoMapper.getByName(name);
	}

	@Override
	public OperationResult saveTest(DemoModel obj) {
		OperationResult validate = demoValidator.validateObj(obj);
		if (validate.isSuccess()) {
			super.save(obj.getDemo());
		}
		return validate;
	}

	@Override
	public MyMapper<Demo> getMapper() {
		return demoMapper;
	}

}
