package product.productRepo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import product.model.Product;

class ProductRepoMan {

	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProductRepo repository;
	
	@Test
	public void testSaveNewProduct() {
		entityManager.persist(new Product(1,"Laptop", 500000));
				
		Product product = repository.findById(1);
		
		assertThat(product.getName()).isEqualTo("Laptop");
	}

}
