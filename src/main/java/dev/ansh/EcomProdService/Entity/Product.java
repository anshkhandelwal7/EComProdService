package dev.ansh.EcomProdService.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String imageURL;
    private double rating;

}
