package product.productRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import product.model.Product;

@Repository
public class ProductRepoImp implements ProductRepo{

	

	HashMap<Integer, Product> list= new HashMap<Integer, Product>();
	
	@Override
	public Product createProduct(Product product) {
		
		list.put(product.getId(), product);
		return product;
		
	}

	@Override
	public Product findById(int id) {
		
		return list.get(id);
	}

	@Override
	public List<Product> getAll() {
		
		Collection<Product> values = list.values();
		ArrayList<Product> list1=new ArrayList<Product>(values);
		return list1;
	}

	@Override
	public Product removeById(int id) {
	
		return  list.remove(id);
		
	}

	@Override
	public Product updateProduct(Product product) {
		 list.put(product.getId(), product);
		return list.get(product.getId());
	}

}
