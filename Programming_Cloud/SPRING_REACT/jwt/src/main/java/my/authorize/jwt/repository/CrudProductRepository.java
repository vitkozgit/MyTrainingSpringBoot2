package my.authorize.jwt.repository;

import my.authorize.jwt.domain.product.Product;
import org.springframework.data.repository.CrudRepository;


public interface CrudProductRepository extends CrudRepository<Product, Long> {
}
