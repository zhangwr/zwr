/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.monitor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.monitor.entity.WebLoggerInfo;
import com.monitor.service.IWebLoggerService;

@RestController
@RequestMapping("/webLogger")
public class WebLoggerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IWebLoggerService webLoggerService;

	@RequestMapping("/all")
	public List<WebLoggerInfo> selectAll() {
		return webLoggerService.selectAll();
	}

	@RequestMapping("/page")
	public PageInfo<WebLoggerInfo> page(WebLoggerInfo info) {
		return webLoggerService.getPageByObj(info);
	}

	@RequestMapping(value = "/view/{id}")
	public WebLoggerInfo view(@PathVariable Long id) {
		return webLoggerService.selectByPkId(id);
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelMap delete(@PathVariable Long id) {
		ModelMap result = new ModelMap();
		webLoggerService.deleteByPkId(id);
		result.put("msg", "删除成功!");
		logger.info("删除成功!");
		return result;
	}

	@RequestMapping(value = "/saveOrUpdate")
	public ModelMap saveOrUpdate(WebLoggerInfo info) {
		ModelMap result = new ModelMap();
		String msg = info.getId() == null ? "新增成功!" : "更新成功!";
		webLoggerService.saveOrUpdate(info);
		result.put("city", info);
		result.put("msg", msg);
		return result;
	}

}
