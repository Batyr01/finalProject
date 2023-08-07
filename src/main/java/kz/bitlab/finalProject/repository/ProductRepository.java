package kz.bitlab.finalProject.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.finalProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
}
