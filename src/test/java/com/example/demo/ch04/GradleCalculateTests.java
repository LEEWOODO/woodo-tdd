package com.example.demo.ch04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.example.demo.ch04.domain.dto.test_doubles.Student;
import com.example.demo.ch04.repository.StubGradeRepository;

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
public class GradleCalculateTests {
	private StubGradeRepository stubGradeRepository;

	public GradleCalculateTests() {
		stubGradeRepository = new StubGradeRepository();
	}

	private Map<String, Integer> grades(Student s) {
		return stubGradeRepository.findByName(s.getName());
	}

	@Test
	void averageGradeTest() {
		Student s = new Student("Lee", 0, new HashMap<>(), 'M', "010-1234-5678");
		Map<String, Integer> result = grades(s);
		int gradeTotal = 0;
		int expectedAverage = 8;

		for (String grade : result.keySet()) {
			gradeTotal += result.get(grade);
		}

		assertEquals(expectedAverage, gradeTotal / result.size());
	}

}
