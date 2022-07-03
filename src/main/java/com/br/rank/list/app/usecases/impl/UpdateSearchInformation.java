package com.br.rank.list.app.usecases.impl;

import com.br.rank.list.app.messages.ISendSearchInformationMessage;
import com.br.rank.list.app.usecases.IUpdateSearchInformation;
import org.springframework.stereotype.Component;

@Component
public class UpdateSearchInformation implements IUpdateSearchInformation {

    private final ISendSearchInformationMessage sendSearchInformation;
    public UpdateSearchInformation(final ISendSearchInformationMessage sendSearchInformation) {
        this.sendSearchInformation = sendSearchInformation;
    }

    @Override
    public void execute(final String message) {
        sendSearchInformation.execute(message);
    }
}
