package com.mars.hong.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envelope<T> {
    private Integer code;
    private String errorMessage;
    private T resource;

    public Envelope(Integer code, String errorMessage) {
        this(code, errorMessage, null);
    }
}
