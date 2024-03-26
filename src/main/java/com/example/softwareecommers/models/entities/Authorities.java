package com.example.softwareecommers.models.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    private String username;

    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserEntity user;


    public String getUsername() {
        return username;
    }

    public Authorities setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAuthority() {
        return authority;
    }

    public Authorities setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public Authorities setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}


