package com.example.softbuyappdeploy.models.dtos;


import com.example.softbuyappdeploy.models.entities.Product;
import com.example.softbuyappdeploy.utils.Role;
import com.example.softbuyappdeploy.validations.matchingPasswords.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Set;
@PasswordMatch(password = "password", confirmPassword = "confirmPassword")
public class UserEntityDTO {
    private String id;
    @Size(min = 3, max = 12, message = "Invalid name")
    private String userName;
    @Size(min = 3,  message = "Invalid password")
    private String password;
    @Size(min = 3,  message = "Invalid password")
    private String confirmPassword;
    @Size(min = 3,  message = "Invalid first Name")
    private String firstName;
    @Size(min = 3, message = "Invalid last Name")
    private String lastName;
    @Email
    private String email;
    private String created;
    private Set<Product> products;
    private Role role;


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

    public String getFirstName() {
        return firstName;
    }

    public UserEntityDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntityDTO setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserEntityDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntityDTO user = (UserEntityDTO) o;
        return Objects.equals(this.getId(), user.getId()) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
                ", firstName='" + firstName +'\'' +
                ", lastName='" + lastName +'\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
