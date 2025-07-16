package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertTrue(true, "Context should load successfully");
	}

	@Test
	void sampleTest() {
		int expected = 5;
		int actual = 2 + 3;
		Assertions.assertEquals(expected, actual, "2 + 3 should equal 5");
	}

}
