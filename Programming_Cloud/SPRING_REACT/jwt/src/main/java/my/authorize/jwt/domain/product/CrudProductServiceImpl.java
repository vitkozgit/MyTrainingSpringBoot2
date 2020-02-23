package my.authorize.jwt.domain.product;

import my.authorize.jwt.repository.CrudProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudProductServiceImpl implements CrudProductService {

	private CrudProductRepository productRepository;

	@Autowired
	public CrudProductServiceImpl(CrudProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> retrieveProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Optional<Product> retrieveProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
}
