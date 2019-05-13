package com.example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

/**
 * Balance REST controller
 *
 * @author abbas
 */
@RestController
@RequestMapping("/db")
public class DbController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/create")
    public void reserveBalance() {
        Random rand = new Random();

        List<Reservation> list = new ArrayList<>();

        for (long i = 0; i < 25_00; i++) {
            Reservation reservation = new Reservation();
            reservation.setUserId(Long.valueOf(rand.nextInt(1_000_000)));
            reservation.setOrderId(i);
            reservation.setCurrency("AED");
            reservation.setAmount(0.1f + rand.nextFloat() * (40000.0f - 0.1f));
            reservation.setStatus("Initiated");
            reservation.setDateTime(new Timestamp(new Date().getTime()));

            list.add(reservation);
        }

        long start = System.nanoTime();

        list.stream().forEach(reservation -> reservationRepository.save(reservation));

        long end = System.nanoTime() - start;
        System.out.println("Insert Time : " + (end / 1_000_000));
    }

    @GetMapping("/all")
    public List<Reservation> balanceByUserId() {
        return reservationRepository.findAll();
    }

    /**
     * @RequestParam Long userId, @RequestParam Long orderId
     */
    @GetMapping("/one")
    public void balanceByUserIdAndOrderId() {

        long start = System.nanoTime();

        List<Reservation> reservations = reservationRepository.findAll();

        long end = System.nanoTime() - start;
        System.out.println("Select all time : " + (end / 1_000_000));

        start = System.nanoTime();

        reservations.stream().forEach(res -> reservationRepository.findByUserIdAndOrderId(res.getUserId(), res.getOrderId()));

        end = System.nanoTime() - start;
        System.out.println("Select one by one : " + (end / 1_000_000));
    }

}
