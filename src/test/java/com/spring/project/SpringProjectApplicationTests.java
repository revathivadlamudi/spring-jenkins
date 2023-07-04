package com.spring.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringProjectApplicationTests {
	public static Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);

	@Test
	void contextLoads() {
		logger.info("Test case executing..");
		assertEquals(true, true);
	}

}
