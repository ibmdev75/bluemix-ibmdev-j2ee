package com.ibm.beans;

import java.util.Enumeration;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;

public abstract  class SpringUtils {
	
	@SuppressWarnings("unchecked")
	public static ApplicationContext getApplicationContext(ServletContext sc) {
		
		ApplicationContext applicationContext = null;
		Enumeration<String> servletContextAttributeNames = sc.getAttributeNames();
        while (servletContextAttributeNames.hasMoreElements()) {
            String servletContextAttributeName = servletContextAttributeNames.nextElement();
            Object servletContextAttribute = sc.getAttribute(servletContextAttributeName);
            if (servletContextAttribute instanceof ApplicationContext) {
                applicationContext = (ApplicationContext)servletContextAttribute;
            }
        }
        return applicationContext;
	}

}
