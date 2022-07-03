package com.br.rank.list.app.usecases.impl;

import com.br.rank.list.app.messages.IRemoveSearchInformationMessage;
import com.br.rank.list.app.usecases.IRemoveSearchInformation;
import org.springframework.stereotype.Component;

@Component
public class RemoveSearchInformation implements IRemoveSearchInformation {

    private final IRemoveSearchInformationMessage removeSearchInformation;

    public RemoveSearchInformation(final IRemoveSearchInformationMessage removeSearchInformation) {
        this.removeSearchInformation = removeSearchInformation;
    }

    @Override
    public void execute(final String productId) {
        removeSearchInformation.execute(productId);

    }
}
