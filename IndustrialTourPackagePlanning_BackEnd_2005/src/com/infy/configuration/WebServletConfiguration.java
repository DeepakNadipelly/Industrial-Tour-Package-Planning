package com.infy.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer{

	public AnnotationConfigWebApplicationContext webContext = null;
	
	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		
		webContext = new AnnotationConfigWebApplicationContext();            
		webContext.register(DispatcherConfig.class);        
		webContext.setServletContext(ctx);

		ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcherServlet", new DispatcherServlet(webContext));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
