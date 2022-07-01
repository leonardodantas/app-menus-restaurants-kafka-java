package com.br.rank.list.infra.kafka.consumers;

import com.br.rank.list.app.usecases.IUpdateSearchInformation;
import com.br.rank.list.infra.provider.ISendProductProvider;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AddProductConsumer {

    private final static String SEND_TOPIC_KAFKA = "send.product.meiliSearch";

    private final ISendProductProvider sendProductProvider;
    private final IUpdateSearchInformation updateSearchInformation;

    public AddProductConsumer(final ISendProductProvider sendProductProvider, final IUpdateSearchInformation updateSearchInformation) {
        this.sendProductProvider = sendProductProvider;
        this.updateSearchInformation = updateSearchInformation;
    }

    @KafkaListener(topics = SEND_TOPIC_KAFKA, groupId = "group.meili.search")
    public void listener(final String message) {
        try {
            sendProductProvider.execute(message);
            updateSearchInformation.execute(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
