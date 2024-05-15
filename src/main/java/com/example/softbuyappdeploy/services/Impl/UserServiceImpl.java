package com.example.softbuyappdeploy.services.Impl;


import com.example.softbuyappdeploy.beans.LoggedUser;
import com.example.softbuyappdeploy.models.dtos.ProductDTO;
import com.example.softbuyappdeploy.models.dtos.UserEntityDTO;
import com.example.softbuyappdeploy.models.entities.Product;
import com.example.softbuyappdeploy.models.entities.UserEntity;
import com.example.softbuyappdeploy.repositories.ProductRepository;
import com.example.softbuyappdeploy.repositories.UserRepository;
import com.example.softbuyappdeploy.services.Inter.UserService;
import com.example.softbuyappdeploy.utils.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }


    public UserEntityDTO registerUser(UserEntityDTO userEntityDTO) {
        if (userRepository.findByEmail(userEntityDTO.getEmail()).isPresent()) {
            return null;
        }
        userEntityDTO.setCreated(LocalDateTime.now().toString()).setRole(Role.USER);
        userRepository.saveAndFlush(modelMapper.map(userEntityDTO, UserEntity.class));
        return userEntityDTO;
    }

    public UserEntityDTO authenticate(UserEntityDTO userEntityDTO) {
        UserEntity authenticatedUser = userRepository.findByUserNameAndPassword(userEntityDTO.getUserName(), userEntityDTO.getPassword()).orElse(null);
        if (authenticatedUser != null) {
            this.loggedUser.setId(authenticatedUser.getId()).setUsername(authenticatedUser.getUserName()).setEmail(authenticatedUser.getEmail());
            return modelMapper.map(authenticatedUser, UserEntityDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public void addProduct(ProductDTO productDTO) {

        UserEntityDTO user = modelMapper.map(this.userRepository.findFirstByUserName(loggedUser.getUsername()), UserEntityDTO.class);
        user.getProducts().add(modelMapper.map(productDTO, Product.class));
        userRepository.saveAndFlush(modelMapper.map(user, UserEntity.class));
    }

    public void removeProduct(String id) {
        UserEntityDTO user = modelMapper.map(this.userRepository.findFirstByUserName(loggedUser.getUsername()), UserEntityDTO.class);
        Product productToRemove = modelMapper.map(this.productRepository.findById(id), Product.class);
        user.getProducts().remove(productToRemove);
        userRepository.save(modelMapper.map(user, UserEntity.class));
    }


    public Set<ProductDTO> getProductsInCart() {
        if (loggedUser.getUsername() == null) {
            return null;
        }
        UserEntityDTO currentUser = modelMapper.map(userRepository.findFirstByUserName(loggedUser.getUsername()), UserEntityDTO.class);
        Set<Product> products = currentUser.getProducts();
        Set<ProductDTO> productsToShow = new LinkedHashSet<>();

        for (Product p : products) {
            productsToShow.add(this.modelMapper.map(p, ProductDTO.class));
        }
        return productsToShow;
    }


    @Override
    public void logout() {
        this.loggedUser.clear();
    }
}