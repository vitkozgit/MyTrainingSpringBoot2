package com.example.demo.autoconf;

import com.example.demo.otherclass.Alona;
import com.example.demo.otherclass.Vitali;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(value = {Vitali.class, Alona.class})
public class MainAutoConf {

	public MainAutoConf() {
		System.out.println("HELLO!!!");
	}
}
