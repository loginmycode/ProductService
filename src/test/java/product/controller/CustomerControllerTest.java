package product.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import product.model.Product;
import product.service.ProductService;



class CustomerControllerTest {

	@Autowired
	MockMvc mockmvc;
	
	@Autowired
	ProductService productService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testTest() {
		fail("Not yet implemented");
	}

	@Test
	void testAddProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchForProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllProduct() throws Exception {
		
		List<Product> list=new ArrayList<Product>();
		Product product1=new Product(1,"Pen",100);
		Product product2=new Product(2,"Laptop",200);
		Product product3=new Product(3,"Mobile",100);
	
		
		
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		Mockito.when(productService.getAll()).thenReturn(list);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAll").accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		String expected = "[{\"id\":1,\"name\":\"Pen\",\"price\":\"100},{\"id\":2,\"name\":\"Laptop\",\"price\":\"200}]";
		assertEquals(expected, result.getResponse().getContentAsString().toString());
	    
		ObjectMapper mapper=new ObjectMapper();
		List<Product> actual = mapper.readValue(result.getResponse().getContentAsByteArray(), new TypeReference<List<Product>>(){});
		assertEquals("Pen", actual.get(1).getName());
		assertEquals("Laptop", actual.get(2).getName());
	}

	@Test
	void testRemoveProduct() throws Exception {
		Product product=new Product(1,"Pen",100);
	when(productService.deleteById(1)).thenReturn(product);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/customers/1").accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		String expected="{\"id\":1,\"name\":\"Pen\",\"price\":\"100}}";
		assertEquals(expected, result.getResponse().getContentAsString());
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

	@Test
	void testUpdateProduct() {
		fail("Not yet implemented");
	}

}
