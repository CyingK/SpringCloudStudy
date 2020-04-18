package com.cying.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThreadBack {
    private String port;
    private String threadName;
    private String message;
}