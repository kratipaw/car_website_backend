package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

	@Autowired
	PriceRepository priceRepository;

	@Autowired
	MockMvc mvc;

	@Test
	public void contextLoads() {

	}

	@Test
	public void findPrice() throws Exception {
		mvc.perform(
				get("/prices/1")
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}

	@Test
	public void findAll(){
		List<Price> prices = (List<Price>) priceRepository.findAll();
		assertEquals(4, prices.size());
		assertEquals(1, prices.get(0).getVehicleId().intValue());
		assertEquals(2, prices.get(1).getVehicleId().intValue());
	}

	@Test
	public void findByVehicleId(){

		Optional<Price> optionalPrice = priceRepository.findById(1L);
		assertTrue(optionalPrice.isPresent());
	}


}
