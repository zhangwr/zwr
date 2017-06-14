package com.monitor.conf;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.mq.quene.MessageServiceFactory;

/**
 * 加载外部bean
 * 
 */
@Configuration
// @ImportResource(locations = { "classpath:applicationContext_quene.xml" })
@Import(Registrar.class)
public class ConfigClass {

}

class Registrar implements ImportBeanDefinitionRegistrar {
	
	private static final String BEAN_NAME = "messageService";

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		if (!registry.containsBeanDefinition(BEAN_NAME)) {
			GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
			beanDefinition.setBeanClass(MessageServiceFactory.class);
			beanDefinition.setFactoryMethodName("getService");
			registry.registerBeanDefinition(BEAN_NAME, beanDefinition);
		}
	}
}
