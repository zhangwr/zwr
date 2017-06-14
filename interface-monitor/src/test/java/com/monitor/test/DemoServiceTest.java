
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
import com.monitor.model.DemoModel;
import com.monitor.service.IDemoService;
import com.monitor.utils.OperationResult;

/**
 * 
 * Title:service层测试
 * 
 * @author zhangwr
 * @date 2017年4月10日下午3:08:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = InterfaceApplication.class)
public class DemoServiceTest {

	@Autowired
	private IDemoService demoService;

	/**
	 * 
	 * Description：添加接口测试
	 * 
	 * @author zhangwr
	 * @date 2017年4月10日下午3:16:32
	 */
	@Test
	public void testSave() {
		DemoModel demoModel = new DemoModel();
		demoModel.setqNme("dfasd");
		Demo demo = new Demo();
		demo.setName("gfgf");
		demo.setState("1235d");
		demoModel.setDemo(demo);
		demoService.saveTest(demoModel);
		Assert.assertNotNull(demoModel.getDemo().getId());
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
		Demo demo = demoService.selectByPkId(1L);
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
		OperationResult result = demoService.deleteByPkId(51L);
		Assert.assertEquals(true, result.isSuccess());
	}

}
