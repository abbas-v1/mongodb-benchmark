package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author abbas
 */
public interface ReservationRepository extends MongoRepository<Reservation, Long> {
    
    Reservation findByUserIdAndOrderId(Long userId, Long orderId);
    
}
