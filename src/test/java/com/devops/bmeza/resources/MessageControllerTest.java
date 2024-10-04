package com.devops.bmeza.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;

import com.devops.bmeza.model.Message;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    private static final String MESSAGE = "Hola";
    private static final String TO = "pablo";
    private static final String FROM = "bryan";
    private static final int TIME_TO_LIFE_SEC = 10;

    @InjectMocks
    private MessageController messageController;

    @Value("${app.api.key.value}")
    private String VALID_API_KEY;


    @Test
    public void sendMessage_Success() throws Exception {

        Message message = new Message(MESSAGE, TO, FROM, TIME_TO_LIFE_SEC);
        ResponseEntity<String> response = messageController.sendMessage(message);
        
        assertNotNull(response);
        assertEquals(response.getBody(), "Hello pablo your message will be send");
        assertEquals(true, response.getStatusCode().is2xxSuccessful());

    }

    @Test
    public void methodsNotPermitted_Success() throws Exception {

        ResponseEntity<String> response = messageController.methodsNotPermitted();
        
        assertNotNull(response);
        assertEquals(response.getBody(), "ERROR");
        assertEquals("405 METHOD_NOT_ALLOWED", response.getStatusCode().toString());
    }

}
