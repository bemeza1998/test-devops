// package com.devops.bmeza.resources;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.json.JacksonTester;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.mock.web.MockHttpServletResponse;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.ResultActions;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.util.MimeTypeUtils;

// import com.devops.bmeza.model.Message;
// import com.fasterxml.jackson.databind.ObjectMapper;

// @WebMvcTest(MessageController.class)

// public class MessageControllerTest {

//     @Autowired
//     private MockMvc mockMvc;


//     // @InjectMocks
//     // private MessageController messageController;

//     // @Autowired
//     // private JacksonTester<Message> jacksonTester;

//     @Autowired
//     private TestRestTemplate restTemplate;

//     @MockBean
//     @Autowired
//     private MessageController messageController;

//     // @BeforeEach
//     // public void setup() {
//     //     // We would need this line if we would not use the MockitoExtension
//     //     // MockitoAnnotations.initMocks(this);
//     //     // Here we can't use @AutoConfigureJsonTesters because there isn't a Spring context
//     //     JacksonTester.initFields(this, new ObjectMapper());
//     //     // MockMvc standalone approach
//     // }

//     @Test
//     public void sendMessage_Success() throws Exception {

//         Message message = new Message("Hi friend", "bmeza", "client@example.com", 20);

//         ResponseEntity<Message> superHeroResponse = restTemplate
//                 .getForEntity("/DevOps", Message.class);



//         // final ResultActions resultMessage = mockMvc.perform(
//         //         MockMvcRequestBuilders.post("/DevOps")
//         //             //.accept(MimeTypeUtils.APPLICATION_JSON_VALUE)
//         //             .contentType(MediaType.APPLICATION_JSON)
//         //             .content("{\"message\":\"This is a test\",\"to\":\"Juan Perez\",\"from\":\"Rita Asturia\",\"timeToLifeSec\":45}")
//         //             .header("X-JWT-KWY", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcyNzY3Nzc5OSwiZXhwIjoxNzI4NTQxNzk5fQ.hsycdCD8y-B7YlDr_dqZLX-VVgc_nkJfuaQx-v93kR4")
//         //             .header("X-Parse-REST-API-Key", "2f5ae96c-b558-4c7b-a590-a501ae1c3f6c")
//         //         );

//         // MockHttpServletResponse response = mockMvc.perform(
//         //     MockMvcRequestBuilders.post("/DevOps").contentType(MediaType.APPLICATION_JSON).content(
//         //             jacksonTester.write(new Message("Hi friend", "bmeza", "client@example.com", 20)).getJson()
//         //         )).andReturn().getResponse();
                
//         // resultMessage.andExpect(MockMvcResultMatchers.status().isOk());
//         // resultMessage.andExpect(result -> assertEquals("Hello bmeza your message will be send", result.getResponse()));

        
//     }

//     @Test
//     public void sendMessage_InvalidMessage() throws Exception {

//         Message invalidMessage = new Message(null, null, null, -1);

//         mockMvc.perform(MockMvcRequestBuilders.post("/DevOps")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content((invalidMessage).toString()))
//                 .andExpect(MockMvcResultMatchers.status().isBadRequest());
//     }

//     @Test
//     public void handleUnsupportedMethods_GET() throws Exception {

//         final ResultActions resultMessage = mockMvc.perform(
//                 MockMvcRequestBuilders.get("/DevOps")
//                     .accept(MimeTypeUtils.APPLICATION_JSON_VALUE)
//                     .contentType(MediaType.APPLICATION_JSON)
//                     .content("{\"message\":\"This is a test\",\"to\":\"Juan Perez\",\"from\":\"Rita Asturia\",\"timeToLifeSec\":45}")
//                     .header("X-JWT-KWY", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcyNzY3Nzc5OSwiZXhwIjoxNzI4NTQxNzk5fQ.hsycdCD8y-B7YlDr_dqZLX-VVgc_nkJfuaQx-v93kR4")
//                     .header("X-Parse-REST-API-Key", "2f5ae96c-b558-4c7b-a590-a501ae1c3f6c")
//                 ).andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());

//         // mockMvc.perform(MockMvcRequestBuilders.get("/DevOps"))
//         //         .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
//                 //.andExpect(content().string("ERROR"));
//     }

// }
