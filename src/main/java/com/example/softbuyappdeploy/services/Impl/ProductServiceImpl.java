package com.example.softbuyappdeploy.services.Impl;


import com.example.softbuyappdeploy.models.dtos.ProductViewDTO;
import com.example.softbuyappdeploy.models.entities.Product;
import com.example.softbuyappdeploy.repositories.ProductRepository;
import com.example.softbuyappdeploy.services.Inter.ProductService;
import com.example.softbuyappdeploy.utils.SoftWareType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductViewDTO> getProductsGames() {
        return Arrays.asList(modelMapper.map(productRepository.findProductBySoftType(SoftWareType.GAME), ProductViewDTO[].class));

    }

    public List<ProductViewDTO> getProductsSoftware() {
        return Arrays.asList(modelMapper.map(productRepository.findProductBySoftType(SoftWareType.SOFTWARE), ProductViewDTO[].class));

    }

    public List<ProductViewDTO> getProductsSubscriptions() {
        return Arrays.asList(modelMapper.map(productRepository.findProductBySoftType(SoftWareType.SUBSCRIPTION), ProductViewDTO[].class));

    }

    public List<ProductViewDTO> getProductsCourse() {
        return Arrays.asList(modelMapper.map(productRepository.findProductBySoftType(SoftWareType.COURSE), ProductViewDTO[].class));

    }

    public ProductViewDTO getById(String id){
        return modelMapper.map(productRepository.findById(id), ProductViewDTO.class);
    }

    public List<ProductViewDTO> search(String keyword){
        return modelMapper.map(this.productRepository.search(keyword), List.class);
    }

    public String uploadProduct(ProductViewDTO productViewDTO){
        if(!this.productRepository.findProductByName(productViewDTO.getName()).isEmpty()){
            return null;
        }
        productViewDTO.setId(UUID.randomUUID().toString());
        this.productRepository.save(modelMapper.map(productViewDTO, Product.class));
        return productViewDTO.getId();

    }

    @Override
    public void deleteProduct(String id) {
        this.productRepository.deleteById(id);
    }
}
