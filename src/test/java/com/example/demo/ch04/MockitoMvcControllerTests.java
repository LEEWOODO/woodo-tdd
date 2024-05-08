package com.example.demo.ch04;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.ch04.controller.TicketController;
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
@WebMvcTest(TicketController.class)
public class MockitoMvcControllerTests {

	@Autowired
	MockMvc mockMvc;

	/*
	 * 질문 : 왜 @Mock 이 아닌 @MockBean 을 사용하는가?
	 * @Mock 은 MockitoExtension 을 사용할 때 사용하는 어노테이션이다.
	 * @MockBean 은 SpringBootTest 를 사용할 때 사용하는 어노테이션이다.
	 * SpringBootTest 를 사용하지 않고 WebMvcTest 를 사용하면 MockBean 을 사용해야 한다.
	 * @MockBean 은 스프링컨텍스트 내에 Mock 빈으로 등록되어 사용된다.
	 * */
	@MockBean
	TicketingService ticketingService;

	@Test
	void test() throws Exception {
		// given
		String contents = "Test";

		mockMvc.perform(get("/ticket"))
			.andExpect(status().isOk())
			.andExpect(content().string(contents));

	}

}
