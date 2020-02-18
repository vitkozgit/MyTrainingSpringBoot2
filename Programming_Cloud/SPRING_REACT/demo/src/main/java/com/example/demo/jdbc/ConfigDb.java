package com.example.demo.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class ConfigDb {

	@Bean
	@Profile("dev")
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder =
				new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2);
		embeddedDatabaseBuilder.setName("mydb");
		embeddedDatabaseBuilder.addScript("schema.sq");
		return embeddedDatabaseBuilder.build();
	}


}
