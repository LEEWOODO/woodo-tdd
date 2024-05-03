package com.example.demo.ch04;

import static org.mockito.ArgumentMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.ch04.domain.dto.Ticket;
import com.example.demo.ch04.repository.ReservationRepository;
import com.example.demo.ch04.service.PerformanceService;
import com.example.demo.ch04.service.TicketingService;

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
@ExtendWith(MockitoExtension.class)
public class MockitoExampleTests {

	private TicketingService ticketingService;

	@Test
	void MockitoMockInstanceTest(){
		PerformanceService performanceService = Mockito.mock(PerformanceService.class);
		ReservationRepository reservationRepository = Mockito.mock(ReservationRepository.class);

		// Mock 객체를 이용한 의존성 문제 해결
		ticketingService = new TicketingService(performanceService, reservationRepository);
		Ticket t = Ticket.builder()
			.performanceId(UUID.fromString("adc45fd5-dab9-11ee-9743-0242ac130002"))
			.performanceName("공연이름")
			.reservationName("사용자")
			.reservationPhoneNumber("010-1234-1234")
			.reservationStatus("reserve")
			.round(1)
			.line('A')
			.seat(1)
			.appliedPolicies(List.of("telecome"))
			.build();


		// When : 호출이 되는 것을 기대하는 메서드에 대한 기대 행위를 명시
		Mockito.when(performanceService.isEnableReserve(any())).then(invocationOnMock -> {
			System.out.println("Execute Stub logic");
			return "enable";
		});
		ticketingService.ticketing(t);

		// Then : 행동 검증
		Mockito.verify(performanceService, Mockito.times(1)).isEnableReserve(any());
		Mockito.verify(reservationRepository, Mockito.times(1)).save(any());

	}


}
