package com.devops.bmeza.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private String message;
    private String to;
    private String from;
    private int timeToLifeSec;
    
}
