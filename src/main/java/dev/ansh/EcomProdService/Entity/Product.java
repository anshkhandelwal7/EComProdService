package dev.ansh.EcomProdService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    @ManyToOne
    private Category category;
    private String imageURL;
    private double rating;

}
