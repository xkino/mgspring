package com.example.mqspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Message implements Serializable {
    private final String address;
    private final String subject;
    private final String text;
}
