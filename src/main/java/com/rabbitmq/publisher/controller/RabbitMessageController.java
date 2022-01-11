package com.rabbitmq.publisher.controller;

import com.rabbitmq.publisher.dto.MessageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rabbitmq")
public class RabbitMessageController {

    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/publish/ack-test")
    void ackTestPublishMessage() {
        log.info("====================> Ack Test Publish Message");
        rabbitTemplate.convertAndSend("ack.test.exchange", "ack.routing.key", "Ack Test Message Publish");
    }

    @GetMapping("/publish/message-info-test")
    void messageInfoTestPublishMessage() {
        log.info("====================> MessageInfo Test Publish Message");

        MessageInfo messageInfo = new MessageInfo();

        messageInfo.setPublisher("Sender");
        messageInfo.setMessage("MessageInfo Test Message Publish");

        rabbitTemplate.convertAndSend("messageInfo.test.exchange", "messageInfo.routing.key", messageInfo);
    }

    @GetMapping("/publish/ack-receiver-test")
    void ackTestPublishMessage2() {
        log.info("====================> Ack Receiver Test Publish Message");
        rabbitTemplate.convertAndSend("ack.receiver.exchange", "ack.receiver.routing.key", "Ack Receiver Test Message Publish");
    }

    @GetMapping("/publish/nack-test")
    void nackTestPublishMessage() {
        log.info("====================> Nack Test Publish Message");
        rabbitTemplate.convertAndSend("nack.test.exchange", "nack.routing.key", "Nack Test Message Publish");
    }

    @GetMapping("/publish/reject-test")
    void rejectTestPublishMessage() {
        log.info("====================> Reject Test Publish Message");
        rabbitTemplate.convertAndSend("reject.test.exchange", "reject.routing.key", "Reject Test Message Publish");
    }

    @GetMapping("/publish/ttl-test")
    void ttlTestPublishMessage() {
        log.info("====================> TTL Test Publish Message");
        rabbitTemplate.convertAndSend("ttl.test.exchange", "ttl.routing.key", "TTL Test Message Publish");
    }

}
