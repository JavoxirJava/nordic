package unv.nordic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unv.nordic.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
