package com.example.softwareecommers.services.Impl;

import com.example.softwareecommers.models.dtos.ProductViewDTO;
import com.example.softwareecommers.models.dtos.UserEntityDTO;
import com.example.softwareecommers.models.entities.Product;
import com.example.softwareecommers.models.entities.UserEntity;
import com.example.softwareecommers.repositories.ProductRepository;
import com.example.softwareecommers.repositories.UserRepository;
import com.example.softwareecommers.services.Inter.UserService;
import com.example.softwareecommers.utils.Role;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.time.LocalDateTime;
import java.util.*;


@Service
public class UserServiceImpl{
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public UserEntityDTO registerUser(UserEntityDTO userToSign) {

            if (userRepository.findFirstByUserName(userToSign.getUserName()).isPresent() || userRepository.findByEmail(userToSign.getEmail()).isPresent()) {
                System.out.println("Duplicate login");
                return null;
            }
            UserEntityDTO user = new UserEntityDTO();
            user.setUserName(userToSign.getUserName());
            user.setPassword(passwordEncoder.encode(userToSign.getPassword()));
            user.setEmail(userToSign.getEmail());
            user.setCreated(LocalDateTime.now().toString());
            user.setRole();


            userRepository.saveAndFlush(modelMapper.map(user, UserEntity.class));
            return user;

    }

    /*

    @Override
    public void addProduct(ProductViewDTO productViewDTO) {

        UserEntityDTO user = modelMapper.map(this.userRepository.findFirstByUserName(loggedUser.getUsername()), UserEntityDTO.class);
        user.getProducts().add(modelMapper.map(productViewDTO, Product.class));
        userRepository.saveAndFlush(modelMapper.map(user, UserEntity.class));
    }

    public void removeProduct(String id){
        UserEntityDTO user = modelMapper.map(this.userRepository.findFirstByUserName(loggedUser.getUsername()), UserEntityDTO.class);
        Product productToRemove = modelMapper.map(this.productRepository.findById(id),Product.class);
        user.getProducts().remove(productToRemove);
        userRepository.save(modelMapper.map(user,UserEntity.class));
    }


    public Set<ProductViewDTO> getProductsInCart() {
        if(loggedUser.getUsername() == null){
            return null;
        }
        UserEntityDTO currentUser = modelMapper.map(userRepository.findFirstByUserName(loggedUser.getUsername()), UserEntityDTO.class);
        Set<Product> products = currentUser.getProducts();
        Set<ProductViewDTO> productsToShow = new LinkedHashSet<>();

        for (Product p : products) {
            productsToShow.add(this.modelMapper.map(p, ProductViewDTO.class));
        }


        return productsToShow;
    }
    */


}