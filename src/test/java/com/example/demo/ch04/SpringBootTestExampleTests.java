package com.example.demo.ch04;

import com.example.demo.ch04.domain.dto.Ticket;
import com.example.demo.ch04.domain.entity.ticketing.Performance;
import com.example.demo.ch04.repository.PerformanceRepository;
import com.example.demo.ch04.service.TicketingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.couchbase.AutoConfigureDataCouchbase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY, connection = EmbeddedDatabaseConnection.H2)
public class SpringBootTestExampleTests {

    @Autowired
    private TicketingService ticketingService;

    @Autowired
    private PerformanceRepository performanceRepository;

    @Test
    void ticketingReserveIntegrationTest(){
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


        // given
        Ticket ticket = Ticket.builder().performanceId(insertedTestPerformance.getId())
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
