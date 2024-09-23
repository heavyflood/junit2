package com.example.demo;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.beans.factory.annotation.Autowired;

public class SampleTests {
	
	private static UserDto userDto;
	
    @BeforeAll
    static void setup() {
    	
    	userDto = UserDto.builder()
    			.userId("heavyflood")
    			.password("1234")
    			.userName("홍길동")
    			.age("50")
    			.build();
    	
        System.out.println("@BeforeAll - " + userDto.toString());
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll - executed after all test methods.");
    }

    @Test
    @DisplayName("첫번째 테스트")
    void successTest1() {
        System.out.println("executes successTest1");
        assumeTrue(userDto.getUserId().toString().equals("heavyflood"));
    }

    @Test
    @DisplayName("두번째 테스트")
    void successTest2() {
        System.out.println("executes successTest2");
        assumeTrue(userDto.getUserId().toString().equals("heavyflood1"));
    }

}
