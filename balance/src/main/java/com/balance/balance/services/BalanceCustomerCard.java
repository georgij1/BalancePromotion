package com.balance.balance.services;

import com.balance.balance.repoBalance.Balance;
import com.balance.balance.repoBalance.BalanceRepository;
import lombok.AllArgsConstructor;
import org.openapi.example.model.BalanceTableDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BalanceCustomerCard {
    public BalanceRepository balanceRepository;

    public void createBalance(
            Integer card_id,
            Integer value,
            String exp
    ) {
        balanceRepository.createBalance(UUID.randomUUID(), card_id, value, exp);
    }

    public void updateBalance(
            UUID uuid,
            Integer value
    ) {
        balanceRepository.updateBalance(uuid, value);
    }

    public BalanceTableDTO findByClientId(Integer cardId) {
        ArrayList<Balance> balances = balanceRepository.findByCardId(cardId);
        ArrayList<Integer> number = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < balances.toArray().length; i++) {
            number.add(balances.get(i).getValue());
        }

        for (Integer numbers : number) {
            sum += numbers;
        }

        return new BalanceTableDTO(
                cardId,
                sum,
                balances.get(0).getExp()
        );
    }
}