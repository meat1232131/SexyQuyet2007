package com.example.demo.DeKtra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CustomErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
