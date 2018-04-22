package com.example.project.hello;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class WelcomeControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(new WelcomeController(new WelcomeService())).build();

    }

    private String connect() throws IOException {
        // ★ルートとなる設定ファイルを読み込む
        try (InputStream in = Resources.getResourceAsStream("mybatis-config.xml")) {
            // ★設定ファイルを元に、 SqlSessionFactory を作成する
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            // ★SqlSessionFactory から SqlSession を生成する
            try (SqlSession session = factory.openSession()) {
                // ★SqlSession を使って SQL を実行する
                List<Map<String, Object>> result = session.selectList("sample.mybatis.selectTest");

                result.forEach(row -> {
                    System.out.println("---------------");
                    row.forEach((columnName, value) -> {
                        System.out.printf("columnName=%s, value=%s%n", columnName, value);
                    });
                });
            }
        }
        return null;
    }

    @Test
    public void testGet__Ok() throws Exception {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa 111");
        connect();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa 222");
        MvcResult result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals("Hello!!", content);
    }
}
