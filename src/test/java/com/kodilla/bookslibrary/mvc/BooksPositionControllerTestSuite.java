package com.kodilla.bookslibrary.mvc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("h2database")
public class BooksPositionControllerTestSuite {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testMockMVC() {
        Assertions.assertNotNull(mockMvc);
    }

    @Test
    void testGetBookPosition() throws Exception {
        this.mockMvc.perform(get("/bookposition/{id}", 5))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Book position with given id does not exist. Check your id."));
    }

    @Test
    void testGetAllBookPositions() throws Exception {
        this.mockMvc.perform(get("/bookposition"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testCreateNewBookPosition() throws Exception {
        this.mockMvc.perform(post("/bookposition")
                .contentType("application/json")
                .content("{ \"status\": \"RENTED\" }"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateBookPosition() throws Exception {
        this.mockMvc.perform(post("/bookposition")
                        .contentType("application/json")
                        .content("{ \"status\": \"RENTED\" }"))
                .andExpect(status().isOk());

        this.mockMvc.perform(put("/bookposition/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"status\": \"FREE\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteBookPosition() throws Exception {
        this.mockMvc.perform(delete("/bookposition/{id}", 100))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Post two BookPositions and Get one")
    void testPostAndGet() throws Exception {
        this.mockMvc.perform(post("/bookposition")
                        .contentType("application/json")
                        .content("{ \"status\": \"RENTED\" }"))
                .andExpect(status().isOk());

        this.mockMvc.perform(post("/bookposition")
                        .contentType("application/json")
                        .content("{ \"status\": \"FREE\" }"))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/bookposition/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
