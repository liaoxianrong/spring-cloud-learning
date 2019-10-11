package com.liaoxr.cloud.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class SendTest implements CommandLineRunner {
    @Autowired
    private Source source;
    @Override
    public void run(String... args) throws Exception {
        source.output().send(MessageBuilder.withPayload("lxr...").build());
    }
}
