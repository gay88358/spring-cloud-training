package com.mars.hong;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProviderController {
    @Resource
    private final MessageProvider messageProvider;

    public ProviderController(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @PostMapping("/sendMessage")
    public String send() {
        return this.messageProvider.send();
    }
}
