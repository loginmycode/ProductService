package product.service;


import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import product.model.Product;
import product.productRepo.ProductRepo;

class ProductServiceImpTest {

	@InjectMocks
	ProductServiceImp productserviceImp;
	@Mock
	ProductRepo productrepo;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
		//fail("Not yet implemented");
		Product product = new Product(1,"pen",100);
		
		when(productrepo.findById(product.getId())).thenReturn(product);
	}
	
	@Test
	void testgetAll()
	{
		//fail("Not yet implemented");
				Product product = new Product(1,"pen",100);
				
				when(productrepo.findById(product.getId())).thenReturn(product);
	}

}
