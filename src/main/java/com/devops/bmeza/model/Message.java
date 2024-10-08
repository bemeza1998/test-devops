package com.devops.bmeza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Message {

    private String message;
    private String to;
    private String from;
    private int timeToLifeSec;
    
}
