package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Build> builds;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    // Functions
    public void show_builds() {
        /* Implementation */ }

    public Boolean create_build() {
        return null;
    }

    public Boolean edit_build(Build build) {
        return null;
    }

    public Boolean delete_build(Build build) {
        return null;
    }

    public void show_reviews() {
        /* Implementation */ }

    public Boolean create_review() {
        return null;
    }

    public Boolean edit_review(Review review) {
        return null;
    }

    public Boolean delete_review(Review review) {
        return null;
    }

    public void show_reviews_of_user(String sortBy, String filterBy) {
        /* Implementation */ }

    public String share_build(Build build) {
        return null;
    }
}
