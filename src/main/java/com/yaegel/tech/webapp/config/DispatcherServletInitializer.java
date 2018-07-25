package com.yaegel.tech.webapp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {RootApplicationContextConfig.class, ProdDataSource.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {WebApplicationContextConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] { "/" };
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		
		servletContext.setInitParameter("spring.profiles.active", System.getenv("PC_ENV"));
	}
}
