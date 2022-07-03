package com.br.rank.list.infra.kafka.producers;

import com.br.rank.list.app.messages.ISendSearchInformationMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendSearchInformationProducer implements ISendSearchInformationMessage {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final static String SEND_TOPIC_KAFKA = "send.search.information";

    public SendSearchInformationProducer(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void execute(final String message) {
        kafkaTemplate.send(SEND_TOPIC_KAFKA, message);
    }
}
