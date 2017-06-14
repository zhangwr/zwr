
package com.monitor.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.monitor.InterfaceApplication;
import com.monitor.entity.Demo;
import com.monitor.model.DemoModel;
import com.mq.utils.JSONUtil;

/**
 * 
 * Title:Controller层测试用例
 * 
 * @author zhangwr
 * @date 2017年4月10日下午2:26:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = InterfaceApplication.class)
@Transactional
public class DemoControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	/**
	 * 
	 * Description:测试添加接口
	 * 
	 * @throws Exception
	 *             void
	 * @author zhangwr
	 * @date 2017年4月10日下午2:28:50
	 */
	@Test
	@Rollback
	public void testSave() throws Exception {
		// 构造添加的用户信息
		DemoModel demoModel = new DemoModel();
		demoModel.setqNme("zzbbcc");
		Demo demo = new Demo();
		demo.setName("zzbbcc");
		demo.setState("345676");
		demoModel.setDemo(demo);
		String json = JSONUtil.beanToJson(demoModel);
		// 调用接口，传入添加的用户参数
		mockMvc.perform(post("/demo/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(json))
				// 判断返回值，是否达到预期
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				// 使用jsonPath解析返回值，判断具体的内容
				.andExpect(jsonPath("$.success", is(true))).andExpect(jsonPath("$.code", is(200)))
				.andExpect(jsonPath("$.message", is("操作成功")));
	}

	/**
	 * 
	 * Description: 测试删除接口
	 * 
	 * @author zhangwr
	 * @throws Exception
	 * @date 2017年4月10日下午2:28:28
	 */
	@Test
	public void teseDelete() throws Exception {
		mockMvc.perform(get("/demo/delete/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				// 使用jsonPath解析返回值，判断具体的内容
				.andExpect(jsonPath("$.success", is(true))).andExpect(jsonPath("$.code", is(200)))
				.andExpect(jsonPath("$.message", is("操作成功")));
	}

	/**
	 * 
	 * Description:测试查看接口
	 * 
	 * @throws Exception
	 *             void
	 * @author zhangwr
	 * @date 2017年4月10日下午2:35:41
	 */
	@Test
	public void testView() throws Exception {
		mockMvc.perform(get("/demo/view").param("id", "1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				// 使用jsonPath解析返回值，判断具体的内容
				.andExpect(jsonPath("$.success", is(true))).andExpect(jsonPath("$.code", is(200)))
				.andExpect(jsonPath("$.data", notNullValue())).andExpect(jsonPath("$.message", is("操作成功")));
	}

}
