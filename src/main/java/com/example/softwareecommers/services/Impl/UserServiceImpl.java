package com.example.softwareecommers.services.Impl;

import com.example.softwareecommers.models.dtos.ProductViewDTO;
import com.example.softwareecommers.models.dtos.UserEntityDTO;
import com.example.softwareecommers.models.entities.Product;
import com.example.softwareecommers.models.entities.UserEntity;
import com.example.softwareecommers.repositories.ProductRepository;
import com.example.softwareecommers.repositories.UserRepository;
import com.example.softwareecommers.services.Inter.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         UserEntity user = userRepository.findFirstByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User with name " + username + "not found!"));
        return mapToUserDetails(user);
    }

    private static UserDetails mapToUserDetails(UserEntity user){
        //TODO
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

        return new User(user.getUserName(),user.getPassword(),authorities);
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