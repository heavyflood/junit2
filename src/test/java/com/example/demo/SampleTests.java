package com.example.demo;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class SampleTests {
	
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
    @DisplayName("로그인이력저장 단위테스트")
    void sampleTest() throws Exception{

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/sample/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }
    @Test
    @DisplayName("로그인이력조회 단위테스트")
    void sampleTest2() throws Exception{

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/sample/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }

}
