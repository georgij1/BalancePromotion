package com.balance.balance.controllers;

import com.balance.balance.services.ServiceImpl;
import lombok.AllArgsConstructor;
import org.openapi.example.api.BalanceApi;
import org.openapi.example.model.BalanceTableDTO;
import org.openapi.example.model.UpdateBalanceTableDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class BalanceController implements BalanceApi {
    private ServiceImpl service;

    @Override
    public ResponseEntity<Void> createBalanceCustomerCard(
            BalanceTableDTO balanceTableDTO
    ) {
        service.createBalance(
                balanceTableDTO.getCardId(),
                balanceTableDTO.getValue(),
                balanceTableDTO.getExp()
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateBalanceCustomerCard(
            UpdateBalanceTableDto updateBalanceTableDto
    ) {
        service.updateBalance(
                UUID.fromString(String.valueOf(updateBalanceTableDto.getId())),
                updateBalanceTableDto.getValue()
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BalanceTableDTO> getBalanceClient(Integer CardId) {
        BalanceTableDTO arr = service.findByClientId(CardId);
        return ResponseEntity.ok().body(arr);
    }

    @Override
    public ResponseEntity<Void> halfCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}