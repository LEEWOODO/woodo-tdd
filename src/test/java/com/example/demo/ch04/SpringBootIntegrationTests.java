package com.example.demo.ch04;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.ch04.domain.dto.Ticket;
import com.example.demo.ch04.domain.entity.ticketing.Performance;
import com.example.demo.ch04.repository.PerformanceRepository;
import com.example.demo.ch04.service.TicketingService;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY, connection = EmbeddedDatabaseConnection.H2)
public class SpringBootIntegrationTests {

	@Autowired
	private TicketingService ticketingService;

	@Autowired
	private PerformanceRepository performanceRepository;

	@TestFactory
	Collection<DynamicTest> dynamicTests() {
	    return Stream.of(
	        dynamicTest("Test Performance Save and Retrieve", this::testPerformanceSaveAndRetrieve),
	        dynamicTest("Test Ticket Reservation", this::testTicketReservation)
	    ).toList();
	}


	private void testPerformanceSaveAndRetrieve() {
	    // given
	    Performance performance = Performance.builder()
	        .name("WOODO 개발방법론 배우기")
	        .type(0)
	        .isReserve("enable")
	        .round(1)
	        .start_date(Date.valueOf(LocalDate.now()))
	        .price(100000000)
	        .policies(new ArrayList<>())
	        .build();

	    // when
	    performanceRepository.save(performance);

	    // then
	    Performance insertedTestPerformance = performanceRepository.findByName("WOODO 개발방법론 배우기");
	    assertNotNull(insertedTestPerformance);
	    assertEquals(performance.getName(), insertedTestPerformance.getName());
	    assertEquals(performance.getStart_date(), insertedTestPerformance.getStart_date());
	}

	private void testTicketReservation() {
	    // given
	    Performance insertedTestPerformance = performanceRepository.findByName("WOODO 개발방법론 배우기");

	    Ticket ticket = Ticket.builder()
	        .performanceId(insertedTestPerformance.getId())
	        .performanceName(insertedTestPerformance.getName())
	        .reservationName("이우도")
	        .reservationPhoneNumber("010-2000-3000")
	        .reservationStatus("reserve")
	        .round(1)
	        .line('A')
	        .seat(1)
	        .appliedPolicies(new ArrayList<>())
	        .build();

	    // when
	    Ticket reservedTicket = ticketingService.ticketing(ticket);

	    // then
	    assertEquals(ticket, reservedTicket);
	}

}

