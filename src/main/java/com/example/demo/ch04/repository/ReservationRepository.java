package com.example.demo.ch04.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ch04.domain.entity.ticketing.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findReservationByNameAndPhoneNumber(String name, String phoneNumber);
    Reservation findReservationByPerformanceIdAndRoundAndGateAndLineAndSeatAndNameAndPhoneNumber(UUID performanceId, int round, int gate, char line, int seat, String userName, String phoneNumber);
}
