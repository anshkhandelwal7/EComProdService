package dev.ansh.EcomProdService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class FakeStoreCartResponseDTO {
    private int id;
    private String date;
    private int userId;
    private List<ProductQuantityDTO> products;
    private int __v;
}
