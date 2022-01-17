package com.infy.utility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextFactory {
	
	private static final ApplicationContext CONTEXT = new AnnotationConfigApplicationContext(com.infy.configuration.SpringConfig.class);
	public static ApplicationContext getContext() {
		return CONTEXT ;
	}
}
