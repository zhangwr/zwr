package com.monitor.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取应用上下文
 * 
 * @author lenovo
 *
 */
@Component
public class SpringUtil implements ApplicationContextAware {
	private Logger LOG = LoggerFactory.getLogger(getClass());
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		if (SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext = context;
			LOG.info("Spring ApplicationContext 设置成功");
		}
	}

	// 获取applicationContext
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	// 通过name获取 Bean
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);

	}

	// 通过class获取Bean
	public static <T> T getBean(Class<T> clazz) {

		return getApplicationContext().getBean(clazz);

	}

	// 通过name,以及Clazz返回指定的Bean
	public static <T> T getBean(String name, Class<T> clazz) {

		return getApplicationContext().getBean(name, clazz);

	}

}
