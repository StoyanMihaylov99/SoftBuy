package com.example.softwareecommers.services.Impl;

import com.example.softwareecommers.beans.LoggedUser;
import com.example.softwareecommers.models.dtos.OrderDTO;
import com.example.softwareecommers.models.dtos.ProductViewDTO;
import com.example.softwareecommers.models.dtos.UserEntityDTO;
import com.example.softwareecommers.models.entities.Order;
import com.example.softwareecommers.models.entities.UserEntity;
import com.example.softwareecommers.repositories.OrderRepository;
import com.example.softwareecommers.repositories.UserRepository;
import com.example.softwareecommers.services.Inter.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserServiceImpl userServiceImpl;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, UserServiceImpl userServiceImpl, LoggedUser loggedUser, UserRepository userRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userServiceImpl = userServiceImpl;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void save() {
        Set<ProductViewDTO> productsForOrder = userServiceImpl.getProductsInCart();
        OrderDTO currentOrder = new OrderDTO();
        OrderDTO orderDTO = currentOrder.setPurchasedProducts(productsForOrder).
                setOrderDateTime(LocalDateTime.now()).setCustomerId(loggedUser.getId());
        orderRepository.save(modelMapper.map(orderDTO, Order.class));

        UserEntityDTO user = modelMapper.map(this.userRepository.findFirstByUserName(loggedUser.getUsername()), UserEntityDTO.class);
        user.getProducts().clear();
        userRepository.save(modelMapper.map(user, UserEntity.class));
    }
}
