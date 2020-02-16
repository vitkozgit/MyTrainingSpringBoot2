package com.example.demo.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class ConfigDb {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder =
				new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2);
		embeddedDatabaseBuilder.setName("mydb");
		embeddedDatabaseBuilder.addScript("schema.sql");
		return embeddedDatabaseBuilder.build();
	}
}
