package com.br.rank.list.infra.provider.impl;

import com.br.rank.list.infra.provider.IGetProvider;
import com.br.rank.list.infra.provider.ISendProductProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SendProductMeiliSearch implements ISendProductProvider {

    private final IGetProvider getProvider;
    private final String hostUrl;
    private final String apiKey;
    private final String indexUUID;

    public SendProductMeiliSearch(final IGetProvider getProvider,
                                  @Value("${provider.meili.search.host.url}") final String hostUrl,
                                  @Value("${provider.meili.search.api.key}") final String apiKey,
                                  @Value("${provider.meili.search.index.products}") final String indexUUID) {
        this.getProvider = getProvider;
        this.hostUrl = hostUrl;
        this.apiKey = apiKey;
        this.indexUUID = indexUUID;
    }

    @Override
    public void execute(final String json) {
        try {
            final var index = getProvider.getIndex(hostUrl, apiKey, indexUUID);
            index.addDocuments(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
