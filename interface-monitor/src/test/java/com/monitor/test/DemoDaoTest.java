
package com.monitor.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.monitor.InterfaceApplication;
import com.monitor.entity.Demo;
import com.monitor.mapper.DemoMapper;

/**
 * 
 * Title:Dao层测试
 * 
 * @author zhangwr
 * @date 2017年4月10日下午3:08:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = InterfaceApplication.class)
public class DemoDaoTest {

	@Autowired
	private DemoMapper demoMapper;

	/**
	 * 
	 * Description：添加接口测试
	 * 
	 * @author zhangwr
	 * @date 2017年4月10日下午3:16:32
	 */
	@Test
	public void testSave() {
		Demo demo = new Demo();
		demo.setName("123adf");
		demo.setState("34dfgs");
		int insert = demoMapper.insert(demo);
		System.out.println(insert);
		Assert.assertNotNull(demo.getId());
	}

	/**
	 * 
	 * Description:查看接口测试
	 * 
	 * @author zhangwr
	 * @date 2017年4月10日下午3:29:21
	 */
	@Test
	public void testView() {
		Demo demo = demoMapper.selectByPrimaryKey(1L);
		Assert.assertNotNull(demo);
	}

	/**
	 * 
	 * Description:测试删除接口
	 * 
	 * @author zhangwr
	 * @date 2017年4月10日下午3:29:36
	 */
	@Test
	public void testDelete() {
		int result = demoMapper.deleteByPrimaryKey(51L);
		Assert.assertEquals(1, result);
	}

}
