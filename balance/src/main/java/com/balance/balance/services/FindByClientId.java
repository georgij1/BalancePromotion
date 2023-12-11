package com.balance.balance.services;

import com.balance.balance.repoBalance.BalanceRepository;
import com.balance.balance.repoBalance.BalanceTable;
import lombok.AllArgsConstructor;
import org.openapi.example.model.BalanceTableDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FindByClientId {
    public BalanceRepository balanceRepository;

    public BalanceTableDTO findByClientId(Integer cardId) {
        Optional<BalanceTable> cardOptional = balanceRepository.findById_client(cardId);
        var balance = cardOptional.get();
        System.out.println(balance);
        return new BalanceTableDTO(balance.getId(), balance.getId_client(), balance.getBalance());
    }
}