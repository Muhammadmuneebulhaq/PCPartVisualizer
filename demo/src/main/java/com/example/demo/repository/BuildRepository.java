package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Build;

public interface BuildRepository extends JpaRepository<Build, Long> {
}
