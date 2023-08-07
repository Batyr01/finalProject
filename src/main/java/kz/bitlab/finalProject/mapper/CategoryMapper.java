package kz.bitlab.finalProject.mapper;

import kz.bitlab.finalProject.dto.CategoryDTO;
import kz.bitlab.finalProject.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDto(Category category);

    Category toModel(CategoryDTO categoryDTO);

    List<CategoryDTO> toDtoList(List<Category> categoryList);

    List<Category> toModelList(List<CategoryDTO> categoryDTOList);

}
