package com.br.rank.list.infra.provider.impl;

import com.br.rank.list.infra.provider.IGetProvider;
import com.br.rank.list.infra.provider.IRemoveProductProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RemoveProductMeiliSearch implements IRemoveProductProvider {

    private final IGetProvider getProvider;
    private final String hostUrl;
    private final String apiKey;
    private final String indexUUID;

    public RemoveProductMeiliSearch(final IGetProvider getProvider,
                                    @Value("${provider.meili.search.host.url}") final String hostUrl,
                                    @Value("${provider.meili.search.api.key}") final String apiKey,
                                    @Value("${provider.meili.search.index.products}") final String indexUUID) {
        this.getProvider = getProvider;
        this.hostUrl = hostUrl;
        this.apiKey = apiKey;
        this.indexUUID = indexUUID;
    }

    @Override
    public void execute(final String productId) {
        try {
            final var index = getProvider.getIndex(hostUrl, apiKey, indexUUID);
            index.deleteDocument(productId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
