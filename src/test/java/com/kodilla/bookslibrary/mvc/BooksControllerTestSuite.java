package com.kodilla.bookslibrary.mvc;

import com.kodilla.bookslibrary.book.BooksController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("h2database")
public class BooksControllerTestSuite {

//    Testing BooksController with MockMVC

    @Autowired
    private MockMvc mockMvc;
    @Test
    void testGetAllBooks() throws Exception {
        this.mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetOneBookFromRepository() throws Exception {
        this.mockMvc.perform(get("/books/15"))
                .andDo(print())
                .andExpect(content().string(containsString("Book with given id does not exist")));
    }

    @Test
    void testDeleteBook() throws Exception {
        this.mockMvc.perform(delete("/books/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testCreateBook() throws Exception {
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"title\": \"JUNIT\", \"author\": \"JUNIT\", \"releaseDate\": \"2015-05-10\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}