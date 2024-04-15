package dev.ansh.EcomProdService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDTO {
    private int id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
    private FakeStoreProductRatingDTO rating;

}
