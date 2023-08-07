package kz.bitlab.finalProject;

import kz.bitlab.finalProject.dto.ProductDTO;
import kz.bitlab.finalProject.model.Category;
import kz.bitlab.finalProject.repository.CategoryRepository;
import kz.bitlab.finalProject.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class FinalProjectApplicationTests {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void testGetProduct() {
		Category category = categoryRepository.findById(1L).orElse(null);

		Long productId = 2L;
		ProductDTO expectedDto = new ProductDTO();
		expectedDto.setId(2L);
		expectedDto.setName("Тестовый продукт");
		expectedDto.setDescription("Описание тестового продукта");
		expectedDto.setPrice(100);
		expectedDto.setCategory(category);
		ProductDTO actualDto = productService.getProduct(productId);
		Assertions.assertEquals(expectedDto.getName(), actualDto.getName());
		Assertions.assertEquals(expectedDto.getDescription(), actualDto.getDescription());
		Assertions.assertEquals(expectedDto.getPrice(), actualDto.getPrice());
		Assertions.assertEquals(expectedDto.getCategory().getId(), actualDto.getCategory().getId());
		Assertions.assertEquals(expectedDto.getCategory().getName(), actualDto.getCategory().getName());
	}

	@Test
	public void testAddProduct() {
		Category category = new Category();
		category.setId(1L);
		category.setName("Телефон");

		ProductDTO expectedDto = new ProductDTO();
		expectedDto.setId(3L);
		expectedDto.setName("Тестовый продукт");
		expectedDto.setDescription("Описание тестового продукта");
		expectedDto.setPrice(100);
		expectedDto.setCategory(category);
		ProductDTO actualDto = productService.addProduct(expectedDto);
		Assertions.assertEquals(expectedDto.getName(), actualDto.getName());
		Assertions.assertEquals(expectedDto.getDescription(), actualDto.getDescription());
		Assertions.assertEquals(expectedDto.getPrice(), actualDto.getPrice());
	}

}
