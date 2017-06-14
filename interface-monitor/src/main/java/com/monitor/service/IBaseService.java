package com.monitor.service;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.monitor.utils.OperationResult;

public interface IBaseService<T> {
	
	/**
	 * 保存
	 * 
	 * @param obj
	 * @return
	 */
	OperationResult save(T obj);
	
	/**
	 * 编辑
	 * 
	 * @param obj
	 * @return
	 */
	OperationResult update(T obj);

	/**
	 * 保存/编辑
	 * 
	 * @param obj
	 * @return
	 */
	OperationResult saveOrUpdate(T obj);

	/**
	 * 根据主键删除Obj
	 * 
	 * @param id
	 */
	OperationResult deleteByPkId(Serializable id);

	/**
	 * 删除Obj
	 * 
	 * @param t
	 */
	OperationResult delteByObj(T t);

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	T selectByPkId(Serializable id);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> selectAll();

	/**
	 * 根据条件分页查询
	 * 
	 * @param info
	 * @return
	 */
	PageInfo<T> getPageByObj(T info);
}
