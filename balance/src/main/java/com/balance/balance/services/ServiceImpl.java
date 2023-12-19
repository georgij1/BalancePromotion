package com.balance.balance.services;

import org.openapi.example.model.BalanceTableDTO;

import java.util.UUID;

public interface ServiceImpl {
    void createBalance(
            Integer card_id,
            Integer value,
            String exp
    );
    void updateBalance(
            UUID uuid,
           Integer value
    );
    BalanceTableDTO findByClientId(Integer cardId);
}