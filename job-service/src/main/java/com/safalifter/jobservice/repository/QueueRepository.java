package com.safalifter.jobservice.repository;

import com.safalifter.jobservice.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue,Long> {
    Queue findByShopId(String shopId);  // Get the queue for a specific shop

}
