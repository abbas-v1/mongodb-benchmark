package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Balance REST controller
 *
 * @author abbas
 */
@RestController
@RequestMapping("/reserve")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping
    public void createReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @GetMapping
    public Reservation getReservationByUserIdAndOrderId(@RequestParam Long userId, @RequestParam Long orderId) {
        return reservationRepository.findByUserIdAndOrderId(userId, orderId);
    }

    @GetMapping("/all")
    public List<Reservation> allReservations() {
        return reservationRepository.findAll();
    }

}
