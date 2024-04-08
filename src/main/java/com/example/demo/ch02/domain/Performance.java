package com.example.demo.ch02.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Project        : demo
 * DATE           : 2024/04/08
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/08      dnejdzlr2          최초 생성
 */
@Entity
@Getter
@Table(name = "performance")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Performance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "performance_id", nullable = false)
	private Long id;

	@Column(name = "performance_name", nullable = false)
	private String name;

	@Column(name = "performance_type", nullable = false)
	private String type;

}
