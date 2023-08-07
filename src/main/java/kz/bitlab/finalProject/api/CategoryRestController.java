package kz.bitlab.finalProject.api;

import kz.bitlab.finalProject.dto.CategoryDTO;
import kz.bitlab.finalProject.dto.ProductDTO;
import kz.bitlab.finalProject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryService categoryService;

    @GetMapping(value = "/categories")
    public List<CategoryDTO> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping(value = "/categories")
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }

    @GetMapping(value = "/categories/{id}")
    public CategoryDTO getCategory(@PathVariable(name = "id") Long id){
        return categoryService.getCategory(id);
    }

    @PutMapping(value = "/categories/update")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping(value = "/categories/delete/{id}")
    public void deleteCategory(@PathVariable(name = "id") Long id){
        categoryService.deleteCategory(id);
    }

}
