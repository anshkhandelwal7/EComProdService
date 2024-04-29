package dev.ansh.EcomProdService.repository;

import dev.ansh.EcomProdService.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByTitle(String Title);
    Product findFirstProductByTitle(String Title);
    List<Product>findByPriceBetween(Double minPrice, Double maxPrice);
}
