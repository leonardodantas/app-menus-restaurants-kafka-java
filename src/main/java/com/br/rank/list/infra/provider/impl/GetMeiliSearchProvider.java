package com.br.rank.list.infra.provider.impl;

import com.br.rank.list.infra.provider.IGetProvider;
import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;
import com.meilisearch.sdk.Index;
import org.springframework.stereotype.Component;

@Component
public class GetMeiliSearchProvider implements IGetProvider {

    @Override
    public Index getIndex(String hostUrl, String apiKey, String indexUUID) {
        try {
            final var client = new Client(new Config("http://127.0.0.1:7700", apiKey));
            return client.index(indexUUID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
