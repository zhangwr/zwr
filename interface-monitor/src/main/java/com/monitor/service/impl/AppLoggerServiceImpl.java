package com.monitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitor.entity.AppLoggerInfo;
import com.monitor.mapper.AppLoggerInfoMapper;
import com.monitor.service.IAppLoggerService;
import com.monitor.utils.MyMapper;

@Service
@Transactional
public class AppLoggerServiceImpl extends BaseServiceImpl<AppLoggerInfo> implements IAppLoggerService {

	@Autowired
	private AppLoggerInfoMapper appLoggerInfo;

	@Override
	public MyMapper<AppLoggerInfo> getMapper() {
		return appLoggerInfo;
	}

}
