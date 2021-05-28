package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import product.model.Product;
import product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productservice;
	
	@GetMapping(value="/test")
	public String test()
	{
		return "ITs UP";
		
	}
	@PostMapping(value="/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		return new ResponseEntity<Product>(productservice.addProduct(product), HttpStatus.CREATED);
	}
	/*
	 * @GetMapping(value="/product/{id}") public ResponseEntity<Product>
	 * findById(@PathVariable ("id") int id) { return new
	 * ResponseEntity<Product>(productservice.findById(id), HttpStatus.FOUND); }
	 */
	
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Product> searchForProduct(@PathVariable("id") int id){
		return new ResponseEntity<Product>(productservice.findById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProduct()
	{
		return new ResponseEntity<List<Product>>(productservice.getAll(),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeProduct(@PathVariable ("id") int id)
	{
		productservice.deleteById(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct( @RequestBody Product product)
	{
		return new ResponseEntity<Product>(productservice.updateProduct(product),HttpStatus.CREATED);
	}
	
	
}
