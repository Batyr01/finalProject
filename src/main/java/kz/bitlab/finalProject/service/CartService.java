package kz.bitlab.finalProject.service;

import kz.bitlab.finalProject.dto.CartDTO;
import kz.bitlab.finalProject.dto.UserDTO;
import kz.bitlab.finalProject.mapper.CartMapper;
import kz.bitlab.finalProject.model.Cart;
import kz.bitlab.finalProject.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final UserService userService;

    public CartDTO addProduct(CartDTO cartDTO) {
        Cart product = cartRepository.findByProductIdAndUserId(cartDTO.getProduct().getId(), cartDTO.getUser().getId());
        if (product != null && product.getStatus()==0) {
            product.setQuantity(product.getQuantity() + cartDTO.getQuantity());
            return cartMapper.toDto(cartRepository.save(product));
        }
        return cartMapper.toDto(cartRepository.save(cartMapper.toModel(cartDTO)));
    }

    public List<CartDTO> getUserCartProducts(Long id) {
        return cartMapper.toDtoList(cartRepository.getCartsByUserId(id));
    }

    public List<CartDTO> getUserCartProductsByStatus(int status) {
        UserDTO user = userService.getCurrentUser();
        return cartMapper.toDtoList(cartRepository.findAllByUserIdAndStatusEquals(user.getId(), status));
    }

    public List<CartDTO> getCartProductsByStatus(int status) {
        return cartMapper.toDtoList(cartRepository.findAllByStatus(status));
    }

    public void buyProductsFromCart(Long id){
        List<Cart> products = cartRepository.findAllByUserIdAndStatusEquals(id, 0);
        for (Cart product : products) {
            product.setStatus(1);
            cartRepository.save(product);
        }
    }

    public void approveProduct(Long id){
        Cart product = cartRepository.findById(id).orElse(null);
        if (product!=null){
            product.setStatus(2);
            cartRepository.save(product);
        }
    }

    public void rejectProduct(Long id){
        Cart product = cartRepository.findById(id).orElse(null);
        if (product!=null){
            product.setStatus(3);
            cartRepository.save(product);
        }
    }

    public CartDTO getProduct(Long id){
        return cartMapper.toDto(cartRepository.findById(id).orElse(null));
    }

    public void deleteProduct(Long id){
        Cart product = cartRepository.findById(id).orElse(null);
        UserDTO user = userService.getCurrentUser();
        if (product!=null){
            if (product.getUser().getId() == user.getId()){
                cartRepository.deleteById(id);
            }
        }
    }

}
