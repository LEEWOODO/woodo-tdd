package com.example.demo.ch04.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.ch04.domain.dto.Ticket;
import com.example.demo.ch04.domain.entity.ticketing.Reservation;
import com.example.demo.ch04.repository.ReservationRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketingService {

	private final PerformanceService performanceService;
	private final ReservationRepository reservationRepository;

	@Transactional
	public Ticket ticketing(Ticket t) {
		if ("enable".equals(performanceService.isEnableReserve(t.getPerformanceId()))) {
			reserve(t);
			return t;
		}
		throw new NoSuchElementException("예약 가능한 공연이 아닙니다.");
	}

	private void reserve(Ticket t) {
		reservationRepository.save(Reservation.of(t));
	}

	private Reservation getReservedInfo(Ticket t) {
		System.out.println("hotfix = " + t);
		System.out.println("now i am main = " + t);
		System.out.println("hello iam develop 5");
		System.out.println("hello iam develop 6");
		System.out.println("hello iam main 8");
		return reservationRepository.findReservationByPerformanceIdAndRoundAndGateAndLineAndSeatAndNameAndPhoneNumber(
			t.getPerformanceId(),
			t.getRound(),
			t.getGate(),
			t.getLine(),
			t.getSeat(),
			t.getReservationName(),
			t.getReservationPhoneNumber()
		);
	}

	// todo delete this method for test
	public void deleteAll() {
		reservationRepository.deleteAll();
	}

	@Transactional
	public void cancel(Ticket t) {
		Reservation r = getReservedInfo(t);
		reservationRepository.delete(r);
	}

	@Transactional
	public void cancel2(Ticket t) {
		Reservation r = getReservedInfo(t);
		reservationRepository.delete(r);
	}

	@Transactional
	public void cancel3(Ticket t) {
		Reservation r = getReservedInfo(t);
		reservationRepository.delete(r);
	}

	@Transactional
	public void cancel4(Ticket t) {
		Reservation r = getReservedInfo(t);
		reservationRepository.delete(r);
	}
}
