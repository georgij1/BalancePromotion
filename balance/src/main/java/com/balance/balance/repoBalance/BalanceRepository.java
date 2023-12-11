package com.balance.balance.repoBalance;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalanceRepository extends ListCrudRepository<BalanceTable, Long> {
    @Transactional
    @Query(value = "select * from balance where id_client=:idClient", nativeQuery = true)
    Optional<BalanceTable> findById_client(Integer idClient);

    @Transactional
    @Query(value = "select exists (select * from balance where balance.id_client=:idClient)", nativeQuery = true)
    boolean findByClientIdBoolean(Integer idClient);

    @Modifying
    @Transactional
    @Query(value = "insert into balance(id_client, balance) VALUES (:idClient, :balance)", nativeQuery = true)
    void updateBalance(@Param("idClient") Integer idClient, @Param("balance") Integer balance);
}