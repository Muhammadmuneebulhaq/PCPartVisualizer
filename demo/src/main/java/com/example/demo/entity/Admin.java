package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.PartRepository;
import com.example.demo.repository.PromotionRepository;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private PartRepository partRepository;

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

    // Functions for Promotion
    public void createPromotion(Promotion promotion) {
        try {
            promotionRepository.save(promotion);
            System.out.println("Promotion created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating promotion: " + e.getMessage());
        }
    }

    public void updatePromotion(Promotion promotion) {
        try {
            if (promotionRepository.existsById(promotion.getId())) {
                promotionRepository.save(promotion);
                System.out.println("Promotion updated successfully.");
            } else {
                System.err.println("Promotion not found.");
            }
        } catch (Exception e) {
            System.err.println("Error updating promotion: " + e.getMessage());
        }
    }

    public void deletePromotion(Long id) {
        try {
            if (promotionRepository.existsById(id)) {
                promotionRepository.deleteById(id);
                System.out.println("Promotion deleted successfully.");
            } else {
                System.err.println("Promotion not found.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting promotion: " + e.getMessage());
        }
    }

    // Functions for Part
    public void createPart(Part part) {
        try {
            partRepository.save(part);
            System.out.println("Part created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating part: " + e.getMessage());
        }
    }

    public void updatePart(Part part) {
        try {
            if (partRepository.existsById(part.getId())) {
                partRepository.save(part);
                System.out.println("Part updated successfully.");
            } else {
                System.err.println("Part not found.");
            }
        } catch (Exception e) {
            System.err.println("Error updating part: " + e.getMessage());
        }
    }

    public void deletePart(Long id) {
        try {
            if (partRepository.existsById(id)) {
                partRepository.deleteById(id);
                System.out.println("Part deleted successfully.");
            } else {
                System.err.println("Part not found.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting part: " + e.getMessage());
        }
    }
}
