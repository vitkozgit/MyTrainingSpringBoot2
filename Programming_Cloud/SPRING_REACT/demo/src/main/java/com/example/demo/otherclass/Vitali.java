package com.example.demo.otherclass;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Vitali {


	private String myProperty;

	public Vitali() {

	}

	@PostConstruct
	private void fun() {
		System.out.println();
	}
}
