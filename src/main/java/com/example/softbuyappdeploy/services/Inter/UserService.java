package com.example.softbuyappdeploy.services.Inter;



import com.example.softbuyappdeploy.models.dtos.ProductDTO;
import com.example.softbuyappdeploy.models.dtos.UserEntityDTO;
import com.example.softbuyappdeploy.utils.Role;

import java.util.Set;

public interface UserService {

    UserEntityDTO registerUser(UserEntityDTO userEntityDTO);

    void logout();

    void addProduct(ProductDTO productDTO);
    void removeProduct(String id);

    UserEntityDTO authenticate(UserEntityDTO userEntityDTO);

    Set<ProductDTO> getProductsInCart();

}

