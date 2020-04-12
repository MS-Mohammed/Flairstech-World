package com.flair.world;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flair.world.controller.CountryController;

@SpringBootTest
public class FlairstechApplicationSmokeTest {

	@Autowired
	private CountryController _CountryController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(_CountryController).isNotNull();
	}

}
