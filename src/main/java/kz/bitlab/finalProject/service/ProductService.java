package kz.bitlab.finalProject.service;

import kz.bitlab.finalProject.dto.ProductDTO;
import kz.bitlab.finalProject.mapper.ProductMapper;

import kz.bitlab.finalProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> getProducts(){
        return productMapper.toDtoList(productRepository.findAll());
    }

    public ProductDTO addProduct(ProductDTO productDTO){
        return productMapper.toDto(productRepository.save(productMapper.toModel(productDTO)));
    }

    public ProductDTO getProduct(Long id){
        return productMapper.toDto(productRepository.findById(id).orElse(null));
    }

    public ProductDTO updateProduct(ProductDTO productDTO){
        return productMapper.toDto(productRepository.save(productMapper.toModel(productDTO)));
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
