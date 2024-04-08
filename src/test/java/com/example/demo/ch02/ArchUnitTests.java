package com.example.demo.ch02;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.Architectures.*;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

/**
 * Project        : demo
 * DATE           : 2024/04/05
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/05      dnejdzlr2          최초 생성
 */
@AnalyzeClasses(packages = "com.example.demo.ch02")
public class ArchUnitTests {
	@ArchTest
	public static final ArchRule 컨트롤러는_서비스패키지만_접근가능하다 = classes().that().resideInAnyPackage("..controller..")
		.should().accessClassesThat().resideInAnyPackage("..service..")
		.orShould().accessClassesThat().resideInAnyPackage("..http..");

	@ArchTest
	public static final ArchRule 컨트롤러는_레포지토리패키지에_접근불가하다 = noClasses().that().resideInAPackage("..controller..")
		.should().accessClassesThat().resideInAnyPackage("..repository..");

	@ArchTest
	public static final ArchRule Controller_붙은_클래스는_controller_패키지에_있어야한다 = classes().that().haveSimpleNameEndingWith("Controller")
		.should().resideInAPackage("com.example.demo.ch02.controller");

	// 레이어드 아키텍쳐 적용 테스트. 컨트롤러 -> 서비스, 서비스 -> 레포지토리 접근 가능 반대의 경우에는 불가능하다
	@ArchTest
	public static final ArchRule 레이어드_아키텍쳐_적용_테스트 = layeredArchitecture()
		.consideringAllDependencies()
		.layer("Controller").definedBy("..controller..")
		.layer("Service").definedBy("..service..")
		.layer("Repository").definedBy("..repository..")
		.whereLayer("Controller").mayNotBeAccessedByAnyLayer()
		.whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
		.whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

	// todo archunit 다양한 테스트 케이스 자료조사 후 적용해보기
}
