package com.example.demo.ch02;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project        : demo
 * DATE           : 2024/04/01
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/01      dnejdzlr2          최초 생성
 */
@RestController
@RequestMapping("/test")
public class TestController {
	@GetMapping
	public ResponseEntity<String> test() {
		System.out.println(">> Requested");
		return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
	}
}
