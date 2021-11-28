package com.mars.hong;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@EnableBinding(Source.class)
public class CloudStreamMessageProvider implements MessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        output
                .send(MessageBuilder.withPayload("123").build());
        System.out.println("*****: " + "123");
        return "123";
    }
}
