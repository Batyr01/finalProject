package kz.bitlab.finalProject.mapper;


import kz.bitlab.finalProject.dto.CartDTO;
import kz.bitlab.finalProject.model.Cart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartDTO toDto(Cart cart);

    Cart toModel(CartDTO cartDTO);

    List<CartDTO> toDtoList(List<Cart> cartList);

    List<Cart> toModelList(List<CartDTO> cartDTOList);

}
