package com.monitor.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.entity.BaseEntity;
import com.monitor.service.IBaseService;
import com.monitor.utils.MyMapper;
import com.monitor.utils.OperationResult;

@Service
@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity> implements IBaseService<T> {

	public abstract MyMapper<T> getMapper();

	@Override
	public OperationResult update(T obj) {
		getMapper().updateByPrimaryKey(obj);
		return OperationResult.SUCCEED;
	}

	@Override
	public OperationResult save(T obj) {
		getMapper().insert(obj);
		return OperationResult.SUCCEED;
	}

	@Override
	public OperationResult saveOrUpdate(T obj) {
		if (obj.getId() != null) {
			getMapper().updateByPrimaryKey(obj);
		} else {
			getMapper().insert(obj);
		}
		return OperationResult.SUCCEED;
	}

	@Override
	public OperationResult deleteByPkId(Serializable id) {
		getMapper().deleteByPrimaryKey(id);
		return OperationResult.SUCCEED;
	}

	@Override
	public OperationResult delteByObj(T t) {
		getMapper().delete(t);
		return OperationResult.SUCCEED;
	}

	@Override
	public T selectByPkId(Serializable id) {
		T t = getMapper().selectByPrimaryKey(id);
		return t;
	}

	@Override
	public List<T> selectAll() {
		return getMapper().selectAll();
	}

	@Override
	public PageInfo<T> getPageByObj(T info) {
		if (info.getCurrentPage() != null && info.getPageSize() != null) {
			PageHelper.startPage(info.getCurrentPage(), info.getPageSize());
		}
		List<T> list = getMapper().getPage(info);
		return new PageInfo<T>(list);
	}

}
