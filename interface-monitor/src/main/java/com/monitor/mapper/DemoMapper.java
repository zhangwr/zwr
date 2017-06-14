package com.monitor.mapper;

import java.util.List;

import com.monitor.entity.Demo;
import com.monitor.utils.MyMapper;

public interface DemoMapper extends MyMapper<Demo> {

	List<Demo> getByName(String name);

	//void saveGuanxi(AppLoggerInfo appLoggerInfo);
}