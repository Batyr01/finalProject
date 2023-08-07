package kz.bitlab.finalProject.api;

import kz.bitlab.finalProject.dto.CartDTO;
import kz.bitlab.finalProject.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartRestController {

    private final CartService cartService;

    @PostMapping(value = "/cart")
    public CartDTO addProduct(@RequestBody CartDTO cartDTO) {
        return cartService.addProduct(cartDTO);
    }

    @GetMapping(value = "/cart/{id}")
    public CartDTO getProduct(@PathVariable(name = "id") Long id) {
        return cartService.getProduct(id);
    }

    @GetMapping(value = "/cart/user/products/{id}")
    public List<CartDTO> getUserCartProducts(@PathVariable(name = "id") Long id){
        return cartService.getUserCartProducts(id);
    }

    @GetMapping(value = "/cart/products/approve/{id}")
    public void approveProduct(@PathVariable(name = "id") Long id){
        cartService.approveProduct(id);
    }

    @GetMapping(value = "/cart/products/reject/{id}")
    public void rejectProduct(@PathVariable(name = "id") Long id){
        cartService.rejectProduct(id);
    }

    @GetMapping(value = "/cart/user/buy/products/{id}")
    public void buyProductsFromCart(@PathVariable(name = "id") Long id){
        cartService.buyProductsFromCart(id);
    }

    @GetMapping(value = "/cart/user/products/status/{status}")
    public List<CartDTO> getUserCartProductsByStatus(@PathVariable(name = "status") int status){
        return cartService.getUserCartProductsByStatus(status);
    }

    @GetMapping(value = "/cart/products/status/{status}")
    public List<CartDTO> getCartProductsByStatus(@PathVariable(name = "status") int status){
        return cartService.getCartProductsByStatus(status);
    }

    @DeleteMapping(value = "/cart/delete/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id){
        cartService.deleteProduct(id);
    }

}
