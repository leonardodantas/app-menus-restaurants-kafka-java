package com.br.rank.list.infra.kafka.producers;

import com.br.rank.list.app.messages.IRemoveSearchInformationMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RemoveSearchInformationProducer implements IRemoveSearchInformationMessage {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final static String REMOVE_TOPIC_KAFKA = "remove.search.information";
    private final ObjectMapper objectMapper;

    public RemoveSearchInformationProducer(final KafkaTemplate<String, String> kafkaTemplate, final ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void execute(final String productId) {
        kafkaTemplate.send(REMOVE_TOPIC_KAFKA, productId);
    }
}
