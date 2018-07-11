package com.my;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {

		logger.trace("this is trace info");
		logger.debug("this is  debug info");
		logger.info("this is info info");
		logger.warn("this is warn info");
		logger.error("this is error info");

	}

}
