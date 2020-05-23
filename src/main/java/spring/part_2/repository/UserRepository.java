package spring.part_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.part_2.unit.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String userName);
}
