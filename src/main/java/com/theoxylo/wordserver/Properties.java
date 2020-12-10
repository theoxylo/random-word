package com.theoxylo.wordserver;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="com.theoxylo.wordserver")
public class Properties {

	String greeting = "hello from properties class";

	void setGreeting(String s) {
		greeting = s;
	}
}
