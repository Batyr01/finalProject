package kz.bitlab.finalProject.dto;

import kz.bitlab.finalProject.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {

    private Long id;
    private UserDTO user;
    private Product product;
    private int quantity;
    private int status;

}
