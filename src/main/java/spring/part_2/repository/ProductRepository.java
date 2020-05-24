package spring.part_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.part_2.unit.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
