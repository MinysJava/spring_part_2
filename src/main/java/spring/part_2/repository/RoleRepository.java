package spring.part_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.part_2.unit.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
