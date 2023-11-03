package com.example.softwareecommers.services.Inter;

import com.example.softwareecommers.models.dtos.ProductViewDTO;

import java.util.List;

public interface ProductService {
    List<ProductViewDTO> getProductsGames();
    List<ProductViewDTO> getProductsSoftware();
    List<ProductViewDTO> getProductsSubscriptions();
    List<ProductViewDTO> getProductsCourse();
    ProductViewDTO getById(String id);


}
