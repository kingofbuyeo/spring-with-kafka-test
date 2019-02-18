package com.ogqcorp.ogqplatform.producer;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by kimyc on 18/02/2019.
 */
@Service
public class Sender {
    private static Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.foo}")
    private String topic;

    public void send(String message){
        System.out.println("SENDING MESSAGE = " + message + ", TOPIC = " + topic);
        kafkaTemplate.send(topic, message);
    }
}
