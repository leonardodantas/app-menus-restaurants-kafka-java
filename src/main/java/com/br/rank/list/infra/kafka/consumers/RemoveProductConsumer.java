package com.br.rank.list.infra.kafka.consumers;

import com.br.rank.list.app.usecases.IRemoveSearchInformation;
import com.br.rank.list.infra.provider.IRemoveProductProvider;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RemoveProductConsumer {

    private final static String REMOVE_TOPIC_KAFKA = "remove.product.meiliSearch";

    private final IRemoveProductProvider removeProductProvider;
    private final IRemoveSearchInformation removeSearchInformation;

    public RemoveProductConsumer(final IRemoveProductProvider removeProductProvider, final IRemoveSearchInformation removeSearchInformation) {
        this.removeProductProvider = removeProductProvider;
        this.removeSearchInformation = removeSearchInformation;
    }

    @KafkaListener(topics = REMOVE_TOPIC_KAFKA, groupId = "group.meili.search")
    public void listener(final String productId) {
        try {
            removeProductProvider.execute(productId);
            removeSearchInformation.execute(productId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
