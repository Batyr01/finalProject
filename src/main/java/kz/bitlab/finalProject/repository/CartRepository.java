package kz.bitlab.finalProject.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.finalProject.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> getCartsByUserId(Long userId);
    Cart findByProductIdAndUserId(Long productId, Long userId);
    List<Cart> findAllByUserIdAndStatusEquals(Long userId, int status);
    List<Cart> findAllByStatus(int status);

}
