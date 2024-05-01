package dev.ansh.EcomProdService.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter

public class CreateProductRequestDTO {
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private UUID categoryId;

}
