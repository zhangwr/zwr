
package com.monitor.test;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.monitor.InterfaceApplication;
import com.mq.commons.Constant;
import com.mq.handler.MessageHandler;
import com.mq.model.Message;
import com.mq.service.IMessageService;
/**
 * 
 * Title:消息通信接口测试用例
 * @author zhangwr
 * @date 2017年4月10日下午3:47:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = InterfaceApplication.class)
public class SpringMqTest {
	
	@Autowired
	private IMessageService mqService;

	@Test
	public void sendMsg() {
		Message message = new Message();
		message.setMsgtype(1);
		message.setMsgsource(4);
		message.setIp("192.168.2.92");
		message.setInterfacename("登录接口");
		message.setRequesttype(1);
		message.setExecutetime(new BigDecimal(2));
		message.setCode(200);
		message.setAppversion("1.0526");
		message.setCpuinfo("cpu6.3");
		try {
			mqService.sendMessage(Constant.Queues.MSG_SEND_QUEUE,message);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Test
	public void receiveMsg() {
		try {
			Object receiveMessage = mqService.receiveMessage(Constant.Queues.MSG_SEND_QUEUE);
			System.out.println("接收消息:" + receiveMessage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Test
	public void subscribeMsg() {
		try {
			mqService.subscribeQueue(Constant.Queues.MSG_SEND_QUEUE, new MessageHandler() {
				@Override
				public boolean handle(Object message) throws Exception {
					System.out.println("订阅队列消息：" + message);
					return true;
				}
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

 
}
