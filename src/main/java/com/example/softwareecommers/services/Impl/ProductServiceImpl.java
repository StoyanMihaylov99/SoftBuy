package com.example.softwareecommers.services.Impl;

import com.example.softwareecommers.models.dtos.ProductViewDTO;
import com.example.softwareecommers.repositories.ProductRepository;
import com.example.softwareecommers.services.Inter.ProductService;
import com.example.softwareecommers.utils.SoftWareType;
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
}
