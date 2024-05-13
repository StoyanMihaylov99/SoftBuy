package com.example.softbuyappdeploy.repositories;


import com.example.softbuyappdeploy.models.entities.Product;
import com.example.softbuyappdeploy.utils.SoftWareType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findProductBySoftType(SoftWareType type);

    Optional<Product> findById(String id);

    @Query(value = "SELECT * FROM products WHERE MATCH(name, owner, description) AGAINST (?1)", nativeQuery = true)
    List<Product> search(String keyword);

    Optional<Product> findProductByName(String name);

    void deleteById(String id);

}
