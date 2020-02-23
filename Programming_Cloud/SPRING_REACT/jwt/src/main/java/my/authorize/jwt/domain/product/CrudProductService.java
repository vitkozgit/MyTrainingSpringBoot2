package my.authorize.jwt.domain.product;

import java.util.List;
import java.util.Optional;

public interface CrudProductService{

	List<Product> retrieveProducts();
	Optional<Product> retrieveProductById(Long id);
	Product createProduct(Product product);
	void deleteProduct(Product product);
}
