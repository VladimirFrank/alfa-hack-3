package com.frankov.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<QueueLog, Integer> {
}
