package com.example.demo.repository;

import com.example.demo.entity.Boss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BossRepository extends JpaRepository<Boss, Long> {
}
