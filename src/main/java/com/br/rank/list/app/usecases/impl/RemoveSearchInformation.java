package com.br.rank.list.app.usecases.impl;

import com.br.rank.list.app.messages.ISendSearchInformationMessage;
import com.br.rank.list.app.usecases.IRemoveSearchInformation;
import org.springframework.stereotype.Component;

@Component
public class RemoveSearchInformation implements IRemoveSearchInformation {

    private final ISendSearchInformationMessage sendSearchInformation;

    public RemoveSearchInformation(final ISendSearchInformationMessage sendSearchInformation) {
        this.sendSearchInformation = sendSearchInformation;
    }

    @Override
    public void execute(final String productId) {
        sendSearchInformation.execute(productId);

    }
}
