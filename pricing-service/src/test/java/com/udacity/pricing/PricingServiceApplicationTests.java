package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PricingServiceApplicationTests {

	@Autowired
	PriceRepository priceRepository;

	@Test
	public void contextLoads() {

	}

	@Test
	public void findAll(){
		List<Price> prices = (List<Price>) priceRepository.findAll();
		assertEquals(2, prices.size());
		assertEquals(1, prices.get(0).getVehicleId().intValue());
		assertEquals(2, prices.get(1).getVehicleId().intValue());
	}

	@Test
	public void findByVehicleId(){

		Optional<Price> optionalPrice = priceRepository.findById(1L);
		assertTrue(optionalPrice.isPresent());
	}


}
