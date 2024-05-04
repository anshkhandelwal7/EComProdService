package dev.ansh.EcomProdService.Service;

import dev.ansh.EcomProdService.Entity.Category;
import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.exception.CategoryNotFoundException;
import dev.ansh.EcomProdService.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }
    @Test
    public void testGetTotalPriceForMultipleProducts()
    {
        //arrange
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(getCategoryMockData());
        double expectedTotalCost = 400.00;

        //act
        double actualTotalCost = categoryService.getTotalPriceForCategory(categoryId);

        //assert
        Assertions.assertEquals(expectedTotalCost, actualTotalCost);
    }
    @Test
    public void testGetTotalPriceForZeroProducts()
    {
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(getCateoryWithZeroProductsMockData());
        double actualTotalCost = categoryService.getTotalPriceForCategory(categoryId);
        double expectedTotalCost = 0.00;
        Assertions.assertEquals(expectedTotalCost, actualTotalCost);
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    @Test
    public void testCategoryNotFoundException() {
        //arrange
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        //act and arrange
        Assertions.assertThrows(CategoryNotFoundException.class, () -> categoryService.getTotalPriceForCategory(categoryId));

    }
    private Optional<Category> getCateoryWithZeroProductsMockData()
    {
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("Category Name");
        List<Product> products = new ArrayList<Product>();
        category.setProducts(products);
        return Optional.of(category);
    }

    private Optional<Category> getCategoryMockData()
    {
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("Category Name");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product1");
        product1.setDescription("Product1");
        product1.setCategory(category);
        product1.setPrice(100.00);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product2");
        product2.setDescription("Product2");
        product2.setCategory(category);
        product2.setPrice(200.00);

        List<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        category.setProducts(products);
        return Optional.of(category);

    }
}
