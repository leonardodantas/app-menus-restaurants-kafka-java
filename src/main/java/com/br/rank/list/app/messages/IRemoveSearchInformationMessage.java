package com.br.rank.list.app.messages;

import com.br.rank.list.domains.SearchInformation;

public interface IRemoveSearchInformationMessage {

    void execute(SearchInformation searchInformation);
}
