package com.monitor.conf;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 数据库连接池DataSource的一些配置
 * 
 * @author lenovo
 *
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = "druid", name = "url")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration {

	@Autowired
	private DruidProperties properties;

	/**
	 * 初始化datasource
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(properties.getUrl());
		dataSource.setUsername(properties.getUsername());
		dataSource.setPassword(properties.getPassword());
		if (properties.getInitialSize() > 0) {
			dataSource.setInitialSize(properties.getInitialSize());
		}
		if (properties.getMinIdle() > 0) {
			dataSource.setMinIdle(properties.getMinIdle());
		}
		if (properties.getMaxActive() > 0) {
			dataSource.setMaxActive(properties.getMaxActive());
		}

		dataSource.setMaxWait(properties.getMaxWait());

		dataSource.setTestOnBorrow(properties.isTestOnBorrow());

		dataSource.setValidationQuery(properties.getValidationQuery());

		dataSource.setTestOnReturn(properties.isTestOnReturn());

		dataSource.setTestWhileIdle(properties.isTestWhileIdle());

		dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());

		dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());

		dataSource.setRemoveAbandoned(properties.isRemoveAbandoned());

		dataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());

		dataSource.setLogAbandoned(properties.isLogAbandoned());

		dataSource.setConnectionProperties(properties.getConnectProperties());

		try {
			dataSource.setFilters(properties.getFilters());
			dataSource.init();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return dataSource;
	}

	/**
	 * 
	 * 注册StatViewServlet
	 * 
	 * @return
	 * 
	 */
	@Bean
	public ServletRegistrationBean DruidStatViewServle2() {

		// org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.

		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				"/druid/*");

		// 添加初始化参数：initParams

		// 白名单：

		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");

		// IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not
		// permitted to view this page.

		servletRegistrationBean.addInitParameter("deny", "192.168.1.73");

		// 登录查看信息的账号密码.

		servletRegistrationBean.addInitParameter("loginUsername", "admin");

		servletRegistrationBean.addInitParameter("loginPassword", "123456");

		// 是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable", "false");

		return servletRegistrationBean;

	}

	/**
	 * 
	 * 注册 filter
	 * 
	 * @return
	 * 
	 */
	@Bean
	public FilterRegistrationBean druidStatFilter2() {

		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

		// 添加过滤规则.
		filterRegistrationBean.addUrlPatterns("/*");

		// 添加不需要忽略的格式信息.

		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

		return filterRegistrationBean;
	}

}
