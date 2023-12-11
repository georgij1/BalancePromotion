package com.balance.balance.controllers;

import com.balance.balance.services.FindByClientId;
import com.balance.balance.services.SetBalanceCustomerCard;
import lombok.AllArgsConstructor;
import org.openapi.example.api.BalanceApi;
import org.openapi.example.model.BalanceTableDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BalanceController implements BalanceApi {
    private FindByClientId findByClientId;
    private SetBalanceCustomerCard setBalanceCustomerCard;

    @Override
    public ResponseEntity<BalanceTableDTO> getByClientID(Integer idClient) {
        return ResponseEntity.ok().body(findByClientId.findByClientId(idClient));
    }

    @Override
    public ResponseEntity<Void> setBalanceCustomerCard(BalanceTableDTO balanceTableDTO) {
        if (Boolean.TRUE.equals(setBalanceCustomerCard.findByClientIdBoolean(balanceTableDTO.getIdClient()))) {
            setBalanceCustomerCard.updateBalanceExists(balanceTableDTO.getBalance(), balanceTableDTO.getIdClient());
        }

        else {
            setBalanceCustomerCard.updateBalance(balanceTableDTO.getIdClient(), balanceTableDTO.getBalance());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}