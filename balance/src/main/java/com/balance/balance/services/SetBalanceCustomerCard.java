package com.balance.balance.services;

import com.balance.balance.repoBalance.BalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SetBalanceCustomerCard {
    public BalanceRepository balanceRepository;

    public void updateBalance(Integer idClient, Integer balance) {
        balanceRepository.updateBalance(idClient, balance);
    }

    public void updateBalanceExists(Integer balance, Integer idClient) {
        throw new RuntimeException();
    }

    public Boolean findByClientIdBoolean(Integer idClient) {
        return balanceRepository.findByClientIdBoolean(idClient);
    }
}