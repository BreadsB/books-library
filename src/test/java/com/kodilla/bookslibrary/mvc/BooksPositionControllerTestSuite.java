package com.kodilla.bookslibrary.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("h2database")
@AutoConfigureMockMvc
public class BooksPositionControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetBookPosition() {}

    @Test
    void testGetAllBookPositions() throws Exception {
        this.mockMvc.perform(get("/bookposition"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testCreateNewBookPosition() {}

    @Test
    void testUpdateBookPosition() throws Exception {
        this.mockMvc.perform(put("/bookposition/{id}", 5)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"status\": \"FREE\" }")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    void testDeleteBookPosition() {}
}
