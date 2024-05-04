package dev.ansh.EcomProdService.Service;

import dev.ansh.EcomProdService.Entity.Category;
import dev.ansh.EcomProdService.Entity.Product;
import dev.ansh.EcomProdService.dto.CategoryResponseDTO;
import dev.ansh.EcomProdService.dto.CreateCategoryRequestDTO;
import dev.ansh.EcomProdService.exception.CategoryNotFoundException;
import dev.ansh.EcomProdService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public CategoryResponseDTO getCategory(UUID categoryId) {
        return null;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
        return null;
    }

    @Override
    public CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID categoryId) {
        return null;
    }

    @Override
    public boolean deleteCategory(UUID categoryId) {
        return false;
    }

    @Override
    public double getTotalPriceForCategory(UUID categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category not found")
        );
        if(category.getProducts().isEmpty()) {
            return 0;
        }
        else
        {
            double sum=0;
            for(Product product : category.getProducts()) {
                sum=sum+product.getPrice();
            }
            return sum;
        }

    }
}
