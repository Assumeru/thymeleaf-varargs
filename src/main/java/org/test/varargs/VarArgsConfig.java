package org.test.varargs;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@ComponentScan
@EnableWebMvc
@Configuration
public class VarArgsConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private ServletContext context;

	@Bean(name = "templateResolver")
	public ServletContextTemplateResolver getTemplateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(context);
		templateResolver.setPrefix("/WEB-INF/");
		templateResolver.setSuffix(".html");
		return templateResolver;
	}

	@Bean(name = "templateEngine")
	public SpringTemplateEngine getTemplateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(getTemplateResolver());
		//Enable if you want an ArrayIndexOutOfBoundsException
		//templateEngine.setDialect(new StandardDialect());
		return templateEngine;
	}

	@Bean(name = "viewResolver")
	public ThymeleafViewResolver getViewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(getTemplateEngine());
		return viewResolver;
	}
}
