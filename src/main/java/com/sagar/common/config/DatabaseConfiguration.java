package com.sagar.common.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;

@Configuration
@ConfigurationProperties("spring.datasource")
@Data
public class DatabaseConfiguration {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Bean
	@Profile("dev")
	public DataSource getDataSourceForDevelopment() {
		
		return DataSourceGenerator().build();
	}

	@Bean
	@Profile("prod")
	public DataSource getDataSourceForProduction() {
		 
		return DataSourceGenerator().build();
	}
	

	@SuppressWarnings("rawtypes")
	private DataSourceBuilder DataSourceGenerator() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driverClassName);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		return dataSourceBuilder;
	}
}
