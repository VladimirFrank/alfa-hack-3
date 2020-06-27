package com.frankov.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Branch, Integer> {
}
