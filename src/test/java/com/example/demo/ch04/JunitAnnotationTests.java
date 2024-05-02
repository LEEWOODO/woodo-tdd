package com.example.demo.ch04;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.demo.ch04.domain.dto.User;

/**
 * Project        : demo
 * DATE           : 2024/05/02
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/05/02      dnejdzlr2          최초 생성
 */
class JunitAnnotationTests {

	/*
	 * @TestFactory 는 테스트 팩토리 메소드를 정의할 때 사용하는 애노테이션입니다.
	 * 예를들어, 1. 배달목록 조회 2. 배달 주문 3. 배달 취소 등의 테스트를 한번에 실행하고 싶을 때 사용할 수 있습니다.
	 *
	 * 해당 애노테이션을 사용하면, 테스트 팩토리 메소드가 반환하는 DynamicNode 객체를 테스트 엔진이 실행합니다.
	 * DynamicNode 객체는 테스트를 나타내는 노드를 나타내며, 테스트 노드는 다음과 같은 종류가 있습니다.
	 * - DynamicContainer: 테스트 컨테이너를 나타내는 노드
	 * - DynamicTest: 테스트를 나타내는 노드
	 * - DynamicContainer와 DynamicTest는 DynamicNode 인터페이스를 구현하고 있습니다.
	 *
	 * 장점으로는 테스트 코드를 동적으로 생성할 수 있어서, 반복적인 테스트 코드를 줄일 수 있습니다.
	 * 또한, 가독성이 높아지고, 테스트 코드를 유연하게 작성할 수 있습니다.
	 * */
	@TestFactory
	@DisplayName("테스트 팩토리 테스트")
	List<DynamicNode> testFactory() {
		return List.of(
			dynamicTest("1번 테스트", () -> assertTrue(true)),
			dynamicTest("2번 테스트", () -> assertTrue(true))
		);
	}

	@RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
	@DisplayName("10번 반복 테스트")
	void repeatedTest(RepetitionInfo info) {
		System.out.println("info = " + info.getCurrentRepetition() + "/" + info.getTotalRepetitions());
	}

	/*
	 * 구구단 테스트 코드
	 * */
	@ParameterizedTest
	@CsvSource(value = {"1||2", "2||4", "3||6"}, delimiterString = "||")
	void csvSourceMultipleTest(int input, int expected) {
		assertEquals(input * 2, expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {" ", ""})
	@NullAndEmptySource
	void userNameParameterizedExceptionTest(String userName) {
		System.out.println("userName = " + userName);
		assertThatThrownBy(() -> new User(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 공백일 수 없습니다.");
	}

	// @Test
	// @DisplayName("User의 이름이 Null이면 예외가 발생한다.")
	// void user_name_null_exception() {
	// 	assertThatThrownBy(() -> new User(null))
	// 		.isInstanceOf(IllegalArgumentException.class)
	// 		.hasMessage("이름은 공백일 수 없습니다.");
	// }
	//
	// @Test
	// @DisplayName("User의 이름은 공백이면 예외처리가 되어야한다.")
	// void user_name_blank_exception() {
	// 	assertThatThrownBy(() -> new User(" "))
	// 		.isInstanceOf(IllegalArgumentException.class)
	// 		.hasMessage("이름은 공백일 수 없습니다.");
	// }
}
