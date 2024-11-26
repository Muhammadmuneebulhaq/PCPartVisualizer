package com.example.demo.entity;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private String manufacturer;
    private String type;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    @ManyToMany(mappedBy = "parts")
    private List<Build> builds;

    @ManyToMany
    @JoinTable(
            name = "promotion_part",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "promotion_id")
    )
    private List<Promotion> promotions;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    // Functions
    public void show_price_history() {
        // Placeholder implementation for price history
        System.out.println("Displaying price history for part: " + name);
        // Real implementation would fetch historical price changes from the database.
    }

    public void edit_options() {
        System.out.println("Editing options for part: " + name);
        // Actual logic for editing options, e.g., updating specifications or configurations.
    }

    public void show_3d_model() {
        System.out.println("Displaying 3D model for part: " + name);
        // Placeholder for rendering a 3D model; would integrate with a graphics library or service.
    }

    public Boolean check_compatibility(Part part) {
        System.out.println("Checking compatibility between parts: " + name + " and " + part.getName());
        // Placeholder logic: check based on type or other criteria.
        if (this.type.equals(part.getType())) {
            System.out.println("Parts are compatible.");
            return true;
        } else {
            System.out.println("Parts are not compatible.");
            return false;
        }
    }

    public void show_reviews_of_part(String sortBy, String filterBy) {
        System.out.println("Displaying reviews for part: " + name);
        if (reviews == null || reviews.isEmpty()) {
            System.out.println("No reviews available for this part.");
            return;
        }

        // Filter reviews based on description
        List<Review> filteredReviews = reviews;
        if (filterBy != null && !filterBy.isEmpty()) {
            filteredReviews = reviews.stream()
                    .filter(review -> review.getDescription() != null && review.getDescription().contains(filterBy))
                    .collect(Collectors.toList());
        }

        // Display reviews
        filteredReviews.forEach(review -> {
            System.out.println("Review by: " + review.getBuild().getUser().getUsername()); // Assuming getBuild() returns a Build, which has a User
            System.out.println("Rating: " + review.getStars());
            System.out.println("Description: " + review.getDescription());
            System.out.println("---");
        });
    }
}
