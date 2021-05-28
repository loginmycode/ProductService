package product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.model.Product;
import product.productRepo.ProductRepo;

@Service
public class ProductServiceImp implements ProductService
{
	@Autowired
	ProductRepo productrepo;
	@Override
	public Product addProduct(Product product) {
		
		return productrepo.createProduct(product);
	}

	@Override
	public Product deleteById(int id) {
		
		return productrepo.removeById(id);
	}

	@Override
	public Product findById(int id) {
	

		return productrepo.findById(id);
	}

	@Override
	public List<Product> getAll() {
		
		return productrepo.getAll();
	}

	@Override
	public Product updateProduct(Product product) {
		
		return productrepo.updateProduct(product);
	}

	

	
}
