package spring.part_2.service;

import spring.part_2.unit.Product;
import spring.part_2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void save(Product product){
        productRepository.save(product);
    }

    @Transactional
    public Optional<Product> findById (Long id){
        return productRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
