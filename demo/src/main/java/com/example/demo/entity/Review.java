package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer stars;
    private String description;

    @ManyToOne
    @JoinColumn(name = "build_id")
    private Build build;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    // Functions
    /**
     * Edits the review. This function allows modifying the review's stars and
     * description. You can also add validation to ensure only authorized users
     * can edit reviews.
     */
    public void edit_review(Integer newStars, String newDescription) {
        if (newStars != null && newStars >= 1 && newStars <= 5) {
            this.stars = newStars;
        } else {
            System.out.println("Invalid star rating. Must be between 1 and 5.");
        }

        if (newDescription != null && !newDescription.trim().isEmpty()) {
            this.description = newDescription;
        } else {
            System.out.println("Description cannot be empty.");
        }

        // Optionally, you can add more validation or logic here.
        System.out.println("Review updated successfully.");
    }
}
