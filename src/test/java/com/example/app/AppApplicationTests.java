package com.example.app;

import com.example.app.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testServicePUT() {
		ProductService productService = new ProductService();
		new String("DrecksSpringBoot").
				equals(productService.getProductById("1").getName());
	}

}
