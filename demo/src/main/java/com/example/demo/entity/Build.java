package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key to the User table
    private User user;

    @OneToMany(mappedBy = "build", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "build_parts",
            joinColumns = @JoinColumn(name = "build_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id")
    )
    private List<Part> parts = new ArrayList<>();

    // Constructors
    public Build() {
    }

    public Build(String name, Float totalPrice, User user) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    // Functions
    public void show_partsUsed() {
        if (parts.isEmpty()) {
            System.out.println("No parts used in this build.");
        } else {
            System.out.println("Parts used in the build:");
            for (Part part : parts) {
                System.out.println("- " + part.getName() + " (Price: " + part.getPrice() + ")");
            }
        }
    }

    public void add_part(Part part) {
        if (!parts.contains(part)) {
            parts.add(part);
            System.out.println("Part added: " + part.getName());
            recalculateTotalPrice();
        } else {
            System.out.println("Part already exists in the build.");
        }
    }

    public void edit_part(Part part) {
        for (int i = 0; i < parts.size(); i++) {
            if (parts.get(i).getId().equals(part.getId())) {
                parts.set(i, part);
                System.out.println("Part updated: " + part.getName());
                recalculateTotalPrice();
                return;
            }
        }
        System.out.println("Part not found in the build.");
    }

    public void remove_part(Part part) {
        if (parts.remove(part)) {
            System.out.println("Part removed: " + part.getName());
            recalculateTotalPrice();
        } else {
            System.out.println("Part not found in the build.");
        }
    }

    public void show_totalPrice() {
        System.out.println("Total price of the build: $" + totalPrice);
    }

    public void apply_discount(String code) {
        // Example logic for discount code validation
        float discount = 0.0f;
        if ("SAVE10".equals(code)) {
            discount = 0.10f; // 10% discount
        } else if ("SAVE20".equals(code)) {
            discount = 0.20f; // 20% discount
        } else {
            System.out.println("Invalid discount code.");
            return;
        }

        Float discountedPrice = totalPrice - (totalPrice * discount);
        setTotalPrice(discountedPrice);
        System.out.println("Discount applied. New total price: $" + discountedPrice);
    }

    private void recalculateTotalPrice() {
        totalPrice = parts.stream()
                .map(Part::getPrice)
                .reduce(0.0f, Float::sum);
        System.out.println("Recalculated total price: $" + totalPrice);
    }
}
