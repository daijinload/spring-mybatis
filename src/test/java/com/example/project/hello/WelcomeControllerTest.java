package com.example.project.hello;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class WelcomeControllerTest {

    private MockMvc mockMvc;
    
    @BeforeEach
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(new WelcomeController(new HelloWorldService())).build();
 
    }
    
    @Test
    public void testGet__Ok() throws Exception {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        MvcResult result = mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals("Hello!!", content);
        
//            .andExpect(Json);
//            .andExpect(content().string("hello!!"));
//            .andExpect(status().is4xxClientError());
    }
    
    
}
