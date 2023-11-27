package com.balance.balance.controllers;

import com.balance.balance.forms.SetBalance;
import com.balance.balance.repoBalance.Repository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("balance")
@AllArgsConstructor
@Tag(name = "Карта", description = "Бонусная Карта клиента")
public class BalanceController {
    public Repository repository;

    @PostMapping("/setBalance")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "setBalance",
            description = "Добавление баланса"
    )
    public String setBalance(@RequestBody SetBalance setBalance) {
        if (Boolean.TRUE.equals(repository.findByClientIdBoolean(setBalance.getId_client()))) {
            repository.updateBalanceExists(setBalance.getBalance(), setBalance.getId_client());
        }

        else {
            repository.updateBalance(setBalance.getId_client(), setBalance.getBalance());
        }

        return "Success update balance";
    }

    @GetMapping("/getByClientID/{idClient}")
    @CrossOrigin("*")
    @ResponseBody
    @Operation(
            summary = "Balance",
            description = "Получение баланса по idClient"
    )
    public String getByClientID(
            @PathVariable("idClient") String idClient
    ) {
        return repository.findByClientIdArray(idClient).toString();
    }
}