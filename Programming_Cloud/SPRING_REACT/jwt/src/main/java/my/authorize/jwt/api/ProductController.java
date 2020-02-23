package my.authorize.jwt.api;

import my.authorize.jwt.domain.product.CrudProductService;
import my.authorize.jwt.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

	private CrudProductService productService;

	@Autowired
	public ProductController(CrudProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> retrieveProducts() {
		List<Product> products = productService.retrieveProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> retrieveProduct(@PathVariable("id") Long id) {
		Optional<Product> product = productService.retrieveProductById(id);
		return ResponseEntity.ok(product.orElse(new Product()));
	}

	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product p = productService.createProduct(product);
		return ResponseEntity.ok(p);
	}

	@DeleteMapping("/product")
	public ResponseEntity<String> deleteProducts(@RequestBody Product product) {
		productService.deleteProduct(product);
		return ResponseEntity.ok("Good!!!");
	}
}
