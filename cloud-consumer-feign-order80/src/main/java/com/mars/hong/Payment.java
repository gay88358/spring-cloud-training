package com.mars.hong;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Payment {
    private Long id;

    private String serial;

    public Payment(String serial) {
        this.serial = serial;
    }
}
