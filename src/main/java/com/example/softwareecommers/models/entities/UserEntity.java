package com.example.softwareecommers.models.entities;

import com.example.softwareecommers.utils.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity{

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "user_name",nullable = false)
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "created",nullable = false)
    private String created;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Product> products;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "enabled",nullable = false)
    private boolean enabled;

    public UserEntity() {

    }

    public Role getRole() {
        return role;
    }

    public UserEntity setRole(Role role) {
        this.role = role;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserEntity setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public UserEntity setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }


    public String getCreated() {
        return created;
    }

    public UserEntity setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getId() {
        return id;
    }

    public UserEntity setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", created='" + created + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(created, that.created) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, email, created, products);
    }
}
