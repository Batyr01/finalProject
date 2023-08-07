package kz.bitlab.finalProject.mapper;

import kz.bitlab.finalProject.dto.ProductDTO;
import kz.bitlab.finalProject.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    Product toModel(ProductDTO productDTO);

    List<ProductDTO> toDtoList(List<Product> productList);

    List<Product> toModelList(List<ProductDTO> productDTOList);

}
