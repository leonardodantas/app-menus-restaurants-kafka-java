package com.br.rank.list.infra.provider;

import com.meilisearch.sdk.Index;

public interface IGetProvider {

    Index getIndex(String hostUrl, String apiKey, String indexUUID);
}
