package kz.bitlab.finalProject.dto;

import kz.bitlab.finalProject.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private int price;
    private Category category;

}
