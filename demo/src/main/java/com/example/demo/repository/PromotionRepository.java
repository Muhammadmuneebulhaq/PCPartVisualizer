package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
