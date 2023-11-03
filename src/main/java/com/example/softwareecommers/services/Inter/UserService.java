package com.example.softwareecommers.services.Inter;

import com.example.softwareecommers.models.dtos.ProductViewDTO;
import com.example.softwareecommers.models.dtos.UserEntityDTO;
import com.example.softwareecommers.models.entities.Product;
import com.example.softwareecommers.models.entities.UserEntity;

import java.util.Set;

public interface UserService {

    UserEntityDTO registerUser(String username, String firstName, String lastName, String email, String password);

    void logout();

    void addProduct(ProductViewDTO productViewDTO);
    void removeProduct(String id);

    UserEntityDTO authenticate(String userName, String password);

    Set<ProductViewDTO> getProductsInCart();

}

