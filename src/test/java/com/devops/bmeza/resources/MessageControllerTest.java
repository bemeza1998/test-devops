package com.devops.bmeza.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MimeTypeUtils;

import com.devops.bmeza.model.Message;

@WebMvcTest(MessageController.class)

public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private MessageController messageController;

    @InjectMocks
    private UserController userController;

    @Value("${app.api.key.value}")
    private String VALID_API_KEY;

    @Test
    public void sendMessage_Success() throws Exception {

        String TestJwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcyNzY3Nzc5OSwiZXhwIjoxNzI4NTQxNzk5fQ.hsycdCD8y-B7YlDr_dqZLX-VVgc_nkJfuaQx-v93kR4";

        final ResultActions resultMessage = mockMvc.perform(
                MockMvcRequestBuilders.post("/DevOps")
                    .accept(MimeTypeUtils.APPLICATION_JSON_VALUE)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"message\":\"This is a test\",\"to\":\"Juan Perez\",\"from\":\"Rita Asturia\",\"timeToLifeSec\":45}")
                    .header("X-JWT-KWY", TestJwt)
                    .header("X-Parse-REST-API-Key", VALID_API_KEY)
                );
                
        resultMessage.andExpect(MockMvcResultMatchers.status().isOk());
        resultMessage.andExpect(result -> assertEquals("Hello bmeza your message will be send", result.getResponse()));

        
    }

    @Test
    public void sendMessage_InvalidMessage() throws Exception {

        Message invalidMessage = new Message(null, null, null, -1);

        mockMvc.perform(MockMvcRequestBuilders.post("/DevOps")
                .contentType(MediaType.APPLICATION_JSON)
                .content((invalidMessage).toString()))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
