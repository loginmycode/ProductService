package product.service;

import java.util.List;

import product.model.Product;

public interface ProductService {

	
	public Product addProduct(Product product);
	public Product deleteById(int id);
	public Product findById(int id);
	public List<Product>getAll();
	public Product updateProduct(Product product);
	
}
