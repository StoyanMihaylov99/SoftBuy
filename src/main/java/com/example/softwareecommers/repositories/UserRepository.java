package com.example.softwareecommers.repositories;


import com.example.softwareecommers.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    Optional<UserEntity> findFirstByUserName(String username);
    Optional<UserEntity> findByUserNameAndPassword(String username, String password);

    Optional<UserEntity> findByEmail(String email);

}
