package com.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动文件
 * 
 * @author lenovo
 *
 */
@SpringBootApplication
@MapperScan(basePackages = "com.monitor.mapper")
public class InterfaceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InterfaceApplication.class, args);
	}

}
