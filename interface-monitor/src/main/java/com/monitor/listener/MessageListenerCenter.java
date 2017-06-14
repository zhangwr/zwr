package com.monitor.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.monitor.service.IAppLoggerService;
import com.monitor.service.IWebLoggerService;
import com.mq.commons.Constant;
import com.mq.handler.MessageHandler;
import com.mq.service.IMessageService;

/**
 * 消息监听器
 */
@Component
public class MessageListenerCenter implements CommandLineRunner {

	private Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private IMessageService messageService;

	@Autowired
	private IAppLoggerService appLoggerService;

	@Autowired
	private IWebLoggerService webLoggerService;

	@Override
	public void run(String... args) {
		listenQueue();
		listenTopicQueue();
	}

	public void listenQueue() {
		LOG.info("*****队列监听开始*****");
		try {
			messageService.subscribeQueue(Constant.Queues.MSG_SEND_QUEUE, new MessageHandler() {
				@Override
				public boolean handle(Object tempMessage) {
					LOG.info("收到队列消息:" + tempMessage);
					return true;
					// if (tempMessage instanceof Message) {
					// Message message = (Message) tempMessage;
					// try {
					// if (message.getMsgsource() == MsgSource.IOS.getValue()
					// || message.getMsgsource() ==
					// MsgSource.ANDROID.getValue()) {
					// // 手机请求接口
					// AppLoggerInfo appLoggerInfo = new AppLoggerInfo();
					// BeanUtils.copyProperties(appLoggerInfo, message);
					// appLoggerInfo.setCreatedate(new Date());
					// appLoggerService.saveOrUpdate(appLoggerInfo);
					// LOG.info("手机端Message被消费了");
					// } else if (message.getMsgsource() ==
					// MsgSource.WEB.getValue()
					// || message.getMsgsource() == MsgSource.H5.getValue()) {
					// // 网页端请求接口
					// WebLoggerInfo webLoggerInfo = new WebLoggerInfo();
					// BeanUtils.copyProperties(webLoggerInfo, message);
					// webLoggerInfo.setCreatedate(new Date());
					// webLoggerService.saveOrUpdate(webLoggerInfo);
					// LOG.info("网页端Message被消费了");
					// }
					// } catch (Exception e) {
					// // 消息处理失败，在队列中去除
					// LOG.error("消息处理失败，原因是：" + e.getMessage());
					// e.printStackTrace();
					// }
					// return true;
					// } else {
					// return true;
					// }
				}
			});
		} catch (Throwable e) {
			LOG.error("通信队列监听失败", e);
		}
	}

	public void listenTopicQueue() {
		LOG.info("*****主题监听开始*****");
		try {
			messageService.subscribeTopic(Constant.Topics.TESTTOPIC, new MessageHandler() {
				@Override
				public boolean handle(Object tempMessage) {
					LOG.info("收到主题消息:" + tempMessage);
					return true;
				}
			});
		} catch (Throwable e) {
			LOG.error("主题监听失败", e);
		}
	}

}
