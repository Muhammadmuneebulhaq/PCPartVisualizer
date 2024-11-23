package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate activeFrom;

    private LocalDate activeTo;

    @ManyToMany(mappedBy = "promotions")
    private List<Part> parts;

    // Constructors
    public Promotion() {
    }

    public Promotion(String name, LocalDate activeFrom, LocalDate activeTo) {
        this.name = name;
        this.activeFrom = activeFrom;
        this.activeTo = activeTo;
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

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(LocalDate activeFrom) {
        this.activeFrom = activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(LocalDate activeTo) {
        this.activeTo = activeTo;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    // Methods for Promotion Management
    /**
     * Shows the details of the promotion.
     */
    public void showPromotionDetails() {
        System.out.println("Promotion Name: " + name);
        System.out.println("Active From: " + activeFrom);
        System.out.println("Active To: " + activeTo);
        if (parts != null && !parts.isEmpty()) {
            System.out.println("Affected Parts:");
            parts.forEach(part -> System.out.println(" - " + part.getName()));
        } else {
            System.out.println("No parts linked to this promotion.");
        }
    }

    /**
     * Checks if the promotion is currently active.
     *
     * @return true if active, false otherwise.
     */
    public boolean isActive() {
        LocalDate today = LocalDate.now();
        return (today.isEqual(activeFrom) || today.isAfter(activeFrom)) && (today.isEqual(activeTo) || today.isBefore(activeTo));
    }

    /**
     * Links a part to this promotion.
     *
     * @param part The part to be linked.
     */
    public void linkPart(Part part) {
        if (!parts.contains(part)) {
            parts.add(part);
            System.out.println("Part " + part.getName() + " linked to promotion " + name);
        } else {
            System.out.println("Part " + part.getName() + " is already linked to this promotion.");
        }
    }

    /**
     * Unlinks a part from this promotion.
     *
     * @param part The part to be unlinked.
     */
    public void unlinkPart(Part part) {
        if (parts.contains(part)) {
            parts.remove(part);
            System.out.println("Part " + part.getName() + " unlinked from promotion " + name);
        } else {
            System.out.println("Part " + part.getName() + " is not linked to this promotion.");
        }
    }

    /**
     * Checks if a specific part is part of this promotion.
     *
     * @param part The part to check.
     * @return true if the part is included, false otherwise.
     */
    public boolean isPartOfPromotion(Part part) {
        return parts != null && parts.contains(part);
    }
}
