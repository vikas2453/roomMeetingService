package com.hcl.hackathon.fullstack.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
		
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource createDataSource() {
		DataSource ds= DataSourceBuilder.create().build();
		return ds;
	}

}
