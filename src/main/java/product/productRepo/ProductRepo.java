package product.productRepo;

import java.util.List;
import java.util.Map;
import product.model.Product;

public interface ProductRepo {

	public Product createProduct(Product product);
	public Product findById(int id);
	public List<Product> getAll();
	public Product removeById(int id);
	public Product updateProduct(Product product);	
}
