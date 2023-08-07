package kz.bitlab.finalProject.service;

import kz.bitlab.finalProject.dto.CategoryDTO;
import kz.bitlab.finalProject.mapper.CategoryMapper;
import kz.bitlab.finalProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> getCategories(){
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    public CategoryDTO getCategory(Long id){
        return categoryMapper.toDto(categoryRepository.findById(id).orElse(null));
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO){
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toModel(categoryDTO)));
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO){
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toModel(categoryDTO)));
    }

}
