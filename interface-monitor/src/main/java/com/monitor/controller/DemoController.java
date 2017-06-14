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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.monitor.entity.Demo;
import com.monitor.model.DemoModel;
import com.monitor.model.TestModel;
import com.monitor.service.IDemoService;
import com.monitor.utils.JsonResult;
import com.monitor.utils.OperationResult;

@RestController
@RequestMapping("/demo")
public class DemoController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IDemoService demoService;

	// @Autowired
	// private IMqService mqService;

	@RequestMapping("/testerror")
	public JsonResult testError() {
		Map<String, Object> map = new HashMap<>();
		System.out.println(1 / 0);
		map.put("state", false);
		return JsonResult.FAILED;
	}

	@RequestMapping("/testDemo")
	public JsonResult testDemo(@RequestBody TestModel testModel) {
		Map<String, Object> map = new HashMap<>();
		map.put("state", true);
		map.put("msg", "成功");
		return JsonResult.success(map);
	}

	@RequestMapping("/testwelcome")
	public ModelAndView testwelcome() {
		ModelAndView result = new ModelAndView("indddddex");
		// result.addObject("testStr", "hello");
		return result;
	}

	@RequestMapping("/testStr")
	public String testStr(HttpServletRequest request) {
		// result.addObject("testStr", "hello");
		return request.getSession().getId();
	}

	@RequestMapping("/all")
	public JsonResult getAll() {
		List<Demo> countryList = demoService.selectAll();
		// Object bean = SpringUtil.getBean("appLoggerServiceImpl");
		// System.out.println("service:" + bean);
		return JsonResult.success(countryList);
	}

	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView result = new ModelAndView("index");
		result.addObject("testStr", "hello word");
		List<Demo> countryList = demoService.selectAll();
		result.addObject("listInfo", countryList);
		return result;
	}

	@RequestMapping("/getByName")
	public List<Demo> getByName(String name) {
		List<Demo> countryList = demoService.getByName(name);
		return countryList;
	}

	// @RequestMapping("/sendMsg")
	// public Map<String, Object> sendMsg() {
	// Map<String, Object> map = new HashMap<>();
	// try {
	// Message message = new Message();
	// message.setMsgtype(1);
	// message.setMsgsource(1);
	// message.setIp("192.168.1.4");
	// message.setInterfacename("bbb");
	// message.setRequesttype(1);
	// message.setExecutetime(1);
	// message.setCode(200);
	// message.setAppversion("11");
	// message.setCpuinfo("cpu");
	// //mqService.sendMessage(message);
	// map.put("code", "success");
	// map.put("msg", "发送成功");
	// } catch (Throwable e) {
	// map.put("code", "error");
	// map.put("msg", "发送失败");
	// e.printStackTrace();
	// }
	// return map;
	// }

	@RequestMapping("/page")
	public PageInfo<Demo> page(Demo info) {
		return demoService.getPageByObj(info);
	}

	@RequestMapping(value = "/view", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public JsonResult view(@RequestParam Long id) {
		Demo city = demoService.selectByPkId(id);
		if (city != null) {
			return JsonResult.success(city);
		} else {
			return JsonResult.failed("数据不存在");
		}
	}

	@RequestMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public JsonResult delete(@PathVariable Long id) {
		ModelMap result = new ModelMap();
		OperationResult delete = demoService.deleteByPkId(id);
		result.put("msg", "删除成功!");
		logger.info("删除成功!");
		return JsonResult.from(delete);
	}

	// @RequestMapping(value = "/save", method = RequestMethod.POST)
	@RequestMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public JsonResult save(@RequestBody DemoModel demo) {
		OperationResult result = demoService.saveTest(demo);
		return JsonResult.from(result);
	}

}
