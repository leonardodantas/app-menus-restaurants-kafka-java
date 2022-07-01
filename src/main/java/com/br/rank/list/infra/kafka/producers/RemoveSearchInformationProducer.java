package com.br.rank.list.infra.kafka.producers;

import com.br.rank.list.app.messages.IRemoveSearchInformationMessage;
import com.br.rank.list.domains.SearchInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public void execute(SearchInformation searchInformation) {
        try {
            final var message = objectMapper.writeValueAsString(searchInformation);
            kafkaTemplate.send(REMOVE_TOPIC_KAFKA, message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
