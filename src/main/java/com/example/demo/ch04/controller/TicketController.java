package com.example.demo.ch04.controller;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ch04.domain.dto.Ticket;
import com.example.demo.ch04.service.TicketingService;

import lombok.RequiredArgsConstructor;

/**
 * Project        : demo
 * DATE           : 2024/05/03
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/05/03      dnejdzlr2          최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
	private final TicketingService ticketingService;

	@GetMapping
	public ResponseEntity<String> test() {
		return ResponseEntity.ok().body("Test");
	}

	@PostMapping("/reserve")
	public ResponseEntity<Ticket> reservation() throws Exception {
		Ticket ticket = Ticket.builder()
			.performanceId(UUID.fromString("55a30393-e45d-11ee-9655-0242ac140002"))
			.performanceName("레베카")
			.reservationName("유진호")
			.reservationPhoneNumber("010-1234-1234")
			.reservationStatus("reserve")
			.round(1)
			.line('A')
			.seat(1)
			.appliedPolicies(Arrays.asList(new String[]{"telecome"}))
			.build();

		System.out.println(">>> reservation");
		return ResponseEntity.ok().body(ticketingService.ticketing(ticket));
	}
}
