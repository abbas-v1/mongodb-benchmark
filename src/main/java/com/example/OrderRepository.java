package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<ExchangeOrder, Long> {

    ExchangeOrder findByOrderId(Long orderId);

}
