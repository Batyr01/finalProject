package kz.bitlab.finalProject.api;

import kz.bitlab.finalProject.dto.ProductDTO;
import kz.bitlab.finalProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @GetMapping(value = "/products")
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = "/products/{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") Long id){
        return productService.getProduct(id);
    }

    @PostMapping(value = "/products")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PutMapping(value = "/products/update")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping(value = "/products/delete/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteProduct(id);
    }


}
