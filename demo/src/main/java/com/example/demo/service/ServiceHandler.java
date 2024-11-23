package com.example.demo.service;

import com.example.demo.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceHandler {

    private final List<User> users = new ArrayList<>();
    private final List<Build> builds = new ArrayList<>();
    private final List<Part> parts = new ArrayList<>();
    private final List<Review> reviews = new ArrayList<>();
    private final List<Promotion> promotions = new ArrayList<>();

    // Functions for User
    public User searchUser(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public User updateUser(User user) {
        User existingUser = searchUser(user.getId());
        if (existingUser != null) {
            users.remove(existingUser);
            users.add(user);
            return user;
        }
        return null;
    }

    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    // Functions for Review
    public Review searchReview(Long id) {
        return reviews.stream().filter(review -> review.getId().equals(id)).findFirst().orElse(null);
    }

    public Review createReview(Review review) {
        review.setId((long) (reviews.size() + 1)); // Simulating ID generation
        reviews.add(review);
        return review;
    }

    public Review updateReview(Review review) {
        Review existingReview = searchReview(review.getId());
        if (existingReview != null) {
            reviews.remove(existingReview);
            reviews.add(review);
            return review;
        }
        return null;
    }

    public void deleteReview(Long id) {
        reviews.removeIf(review -> review.getId().equals(id));
    }

    // Functions for Build
    public Build searchBuild(Long id) {
        return builds.stream().filter(build -> build.getId().equals(id)).findFirst().orElse(null);
    }

    public Build createBuild(Build build) {
        build.setId((long) (builds.size() + 1)); // Simulating ID generation
        builds.add(build);
        return build;
    }

    public Build updateBuild(Build build) {
        Build existingBuild = searchBuild(build.getId());
        if (existingBuild != null) {
            builds.remove(existingBuild);
            builds.add(build);
            return build;
        }
        return null;
    }

    public void deleteBuild(Long id) {
        builds.removeIf(build -> build.getId().equals(id));
    }

    // Functions for Part
    public Part searchPart(Long id) {
        return parts.stream().filter(part -> part.getId().equals(id)).findFirst().orElse(null);
    }

    public Part createPart(Part part) {
        part.setId((long) (parts.size() + 1)); // Simulating ID generation
        parts.add(part);
        return part;
    }

    public Part updatePart(Part part) {
        Part existingPart = searchPart(part.getId());
        if (existingPart != null) {
            parts.remove(existingPart);
            parts.add(part);
            return part;
        }
        return null;
    }

    public void deletePart(Long id) {
        parts.removeIf(part -> part.getId().equals(id));
    }

    // Functions for Promotion
    public Promotion searchPromotion(Long id) {
        return promotions.stream().filter(promotion -> promotion.getId().equals(id)).findFirst().orElse(null);
    }

    public Promotion createPromotion(Promotion promotion) {
        promotion.setId((long) (promotions.size() + 1)); // Simulating ID generation
        promotions.add(promotion);
        return promotion;
    }

    public Promotion updatePromotion(Promotion promotion) {
        Promotion existingPromotion = searchPromotion(promotion.getId());
        if (existingPromotion != null) {
            promotions.remove(existingPromotion);
            promotions.add(promotion);
            return promotion;
        }
        return null;
    }

    public void deletePromotion(Long id) {
        promotions.removeIf(promotion -> promotion.getId().equals(id));
    }

    // Additional Methods for Registration and Login
    public User registerUser(String username, String email, String password) {
        User existingUser = users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);

        if (existingUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setPassword(password);
            users.add(newUser);
            return newUser;
        }
        return null;
    }

    public User loginUser(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}

// // Functions for Review
// public Review searchReview(Long id) {
//     return null;
// }
// public Review createReview(Review review) {
//     return null;
// }
// public Review updateReview(Review review) {
//     return null;
// }
// public void deleteReview(Long id) {
//     /* Implementation */ }
// // Functions for Build
// public Build searchBuild(Long id) {
//     return null;
// }
// public Build createBuild(Build build) {
//     return null;
// }
// public Build updateBuild(Build build) {
//     return null;
// }
// public void deleteBuild(Long id) {
//     /* Implementation */ }
// // Functions for Part
// public Part searchPart(Long id) {
//     return null;
// }
// public Part createPart(Part part) {
//     return null;
// }
// public Part updatePart(Part part) {
//     return null;
// }
// public void deletePart(Long id) {
//     /* Implementation */ }
// // Functions for Promotion
// public Promotion searchPromotion(Long id) {
//     return null;
// }
// public Promotion createPromotion(Promotion promotion) {
//     return null;
// }
// public Promotion updatePromotion(Promotion promotion) {
//     return null;
// }
// public void deletePromotion(Long id) {
        //     /* Implementation */ }
