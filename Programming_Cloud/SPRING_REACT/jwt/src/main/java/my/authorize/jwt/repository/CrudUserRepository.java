package my.authorize.jwt.repository;

import my.authorize.jwt.domain.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudUserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
