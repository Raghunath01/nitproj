package com.tekleads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	
	public static void main(String[] args) {
		ConfigurableApplicationContext appCtxt = SpringApplication.run(Application.class, args);
		logger.info("hello12334");
		logger.info("ApplicationContextContainer {}. ",appCtxt);
	}

}
