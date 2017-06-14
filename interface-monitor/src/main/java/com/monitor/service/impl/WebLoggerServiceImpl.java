package com.monitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monitor.entity.WebLoggerInfo;
import com.monitor.mapper.WebLoggerInfoMapper;
import com.monitor.service.IWebLoggerService;
import com.monitor.utils.MyMapper;

@Service
@Transactional
public class WebLoggerServiceImpl extends BaseServiceImpl<WebLoggerInfo> implements IWebLoggerService {

	@Autowired
	private WebLoggerInfoMapper webLoggerInfo;

	@Override
	public MyMapper<WebLoggerInfo> getMapper() {
		return webLoggerInfo;
	}

}
