package com.example.softwareecommers.models.dtos;
import com.example.softwareecommers.models.entities.Product;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
public class UserEntityDTO {
    private String id;
    @Size(min = 3, max = 12, message = "Invalid name")
    private String userName;
    @Size(min = 3,  message = "Invalid password")
    private String password;
    @Email
    private String email;
    private String created;
    private Set<Product> products;
    private String roles;


    public UserEntityDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public UserEntityDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntityDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRoles() {
        return roles;
    }

    public UserEntityDTO setRole() {
        this.roles = "USER";
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntityDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public UserEntityDTO setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }


    public String getCreated() {
        return created;
    }

    public UserEntityDTO setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getId() {
        return id;
    }

    public UserEntityDTO setId(String id) {
        this.id = id;
        return this;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntityDTO user = (UserEntityDTO) o;
        return Objects.equals(this.getId(), user.getId()) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), userName, password, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + getId() +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
