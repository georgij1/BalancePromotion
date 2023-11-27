package com.balance.balance.repoBalance;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.ArrayList;
import java.util.Map;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<BalanceTable, Long> {
    @Transactional
    @Query("select balance from BalanceTable balance where balance.id_client=:idClient")
    ArrayList<Map<?, ?>> findByClientIdArray(String idClient);

    @Transactional
    @Query("select exists (select balance from BalanceTable balance where balance.id_client=:idClient)")
    boolean findByClientIdBoolean(String idClient);

    @Modifying
    @Transactional
    @Query(value = "insert into balance(id_client, balance) VALUES (:idClient, :balance)", nativeQuery = true)
    void updateBalance(@Param("idClient") String idClient, @Param("balance") Integer balance);

    @Modifying
    @Transactional
    @Query(value = "update balance set balance=:balance where id_client=:idClient", nativeQuery = true)
    void updateBalanceExists(@Param("balance") Integer balance, @Param("idClient") String idClient);
}