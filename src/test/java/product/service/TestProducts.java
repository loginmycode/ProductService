package product.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import product.model.Product;
import product.productRepo.ProductRepo;

class TestProducts {

	@Autowired 
	ProductRepo productRepo;
	
	@Autowired
	Product product;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddProduct() {
		//fail("Not yet implemented");
		when(productRepo.createProduct(product)).thenReturn(product);
	}

	@Test
	void testUpdateProduct() {
		when(productRepo.updateProduct(product)).thenReturn(product);
	}
		
}


