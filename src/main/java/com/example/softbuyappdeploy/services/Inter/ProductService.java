package com.example.softbuyappdeploy.services.Inter;



import com.example.softbuyappdeploy.models.dtos.ProductViewDTO;

import java.util.List;

public interface ProductService {
    List<ProductViewDTO> getProductsGames();
    List<ProductViewDTO> getProductsSoftware();
    List<ProductViewDTO> getProductsSubscriptions();
    List<ProductViewDTO> getProductsCourse();
    ProductViewDTO getById(String id);
    String uploadProduct(ProductViewDTO productViewDTO);
    void deleteProduct(String id);


}
