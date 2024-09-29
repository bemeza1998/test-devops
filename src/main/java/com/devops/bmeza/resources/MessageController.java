package com.devops.bmeza.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devops.bmeza.model.Message;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/DevOps")
public class MessageController {

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody @Validated Message message) {
        String responseMessage = "Hello " + message.getTo() + " your message will be send";
        return ResponseEntity.ok().body(responseMessage);
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
    public ResponseEntity<String> manejarMetodosNoPermitidos() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                             .body("ERROR");
    }
    
}
