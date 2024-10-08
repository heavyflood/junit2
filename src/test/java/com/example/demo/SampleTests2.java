package com.example.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class SampleTests2 {
	
    @InjectMocks
    SampleController sampleController;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;
    @BeforeEach
    public void init(WebApplicationContext webApplicationContext) { // mockMvc 초기화, 각메서드가 실행되기전에 초기화 되게 함
        // mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
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
    @DisplayName("단위테스트#3")
    void sampleTest() throws Exception{

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/sample/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));

    }

    @Test
    @DisplayName("단위테스트#4")
    void sampleTest2() throws Exception{

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/sample/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));

    }

}
