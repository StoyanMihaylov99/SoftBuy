package com.example.softbuyappdeploy.services.Inter;



import com.example.softbuyappdeploy.models.dtos.ProductViewDTO;
import com.example.softbuyappdeploy.models.dtos.UserEntityDTO;
import com.example.softbuyappdeploy.utils.Role;

import java.util.Set;

public interface UserService {

    UserEntityDTO registerUser(String username, String firstName, String lastName, String email, String password, Role role);

    void logout();

    void addProduct(ProductViewDTO productViewDTO);
    void removeProduct(String id);

    UserEntityDTO authenticate(String userName, String password);

    Set<ProductViewDTO> getProductsInCart();

}

