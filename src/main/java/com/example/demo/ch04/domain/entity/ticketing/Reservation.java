package com.example.demo.ch04.domain.entity.ticketing;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.SQLRestriction;

import com.example.demo.ch04.domain.dto.Ticket;
import com.example.demo.ch04.domain.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("deleted_at IS NULL")
public class Reservation extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "BINARY(16)", nullable = false, name = "performance_id")
	private UUID performanceId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, name = "phone_number")
	private String phoneNumber;
	@Column(nullable = false)
	private int round;
	private int gate;
	private char line;
	private int seat;

	public static Reservation of(Ticket info) {
		return Reservation.builder()
			.performanceId(info.getPerformanceId())
			.name(info.getReservationName())
			.phoneNumber(info.getReservationPhoneNumber())
			.round(info.getRound())
			.gate(1)
			.line(info.getLine())
			.seat(info.getSeat())
			.build();
	}

	public void softDelete() {
		super.setDeletedAt(LocalDateTime.now());
	}

}
