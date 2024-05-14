package com.example.softbuyappdeploy.services.Inter;



import com.example.softbuyappdeploy.models.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductsGames();
    List<ProductDTO> getProductsSoftware();
    List<ProductDTO> getProductsSubscriptions();
    List<ProductDTO> getProductsCourse();
    ProductDTO getById(String id);
    String uploadProduct(ProductDTO productDTO);
    void deleteProduct(String id);


}
