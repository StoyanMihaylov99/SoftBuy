package com.example.softbuyappdeploy.services.Impl;


import com.example.softbuyappdeploy.models.dtos.ProductDTO;
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

    public List<ProductDTO> getProductsGames() {
        return Arrays.asList(modelMapper.map(productRepository.findProductBySoftType(SoftWareType.GAME), ProductDTO[].class));

    }

    public List<ProductDTO> getProductsSoftware() {
        return Arrays.asList(modelMapper.map(productRepository.findProductBySoftType(SoftWareType.SOFTWARE), ProductDTO[].class));

    }

    public List<ProductDTO> getProductsSubscriptions() {
        return Arrays.asList(modelMapper.map(productRepository.findProductBySoftType(SoftWareType.SUBSCRIPTION), ProductDTO[].class));

    }

    public List<ProductDTO> getProductsCourse() {
        return Arrays.asList(modelMapper.map(productRepository.findProductBySoftType(SoftWareType.COURSE), ProductDTO[].class));

    }

    public ProductDTO getById(String id){
        return modelMapper.map(productRepository.findById(id), ProductDTO.class);
    }

    public List<ProductDTO> search(String keyword){
        return modelMapper.map(this.productRepository.search(keyword), List.class);
    }

    public String uploadProduct(ProductDTO productDTO){
        if(!this.productRepository.findProductByName(productDTO.getName()).isEmpty()){
            return null;
        }
        productDTO.setId(UUID.randomUUID().toString());
        this.productRepository.save(modelMapper.map(productDTO, Product.class));
        return productDTO.getId();

    }

    @Override
    public void deleteProduct(String id) {
        this.productRepository.deleteById(id);
    }
}
