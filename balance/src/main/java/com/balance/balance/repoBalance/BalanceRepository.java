package com.balance.balance.repoBalance;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface BalanceRepository extends ListCrudRepository<Balance, Long> {
    @Transactional
    @Query(value = "select * from balance where card_id=:idCard", nativeQuery = true)
    ArrayList<Balance> findByCardId(Integer idCard);

    @Modifying
    @Transactional
    @Query(value = "insert into balance(id, card_id, value, exp, date_create_upd) VALUES (:uuid, :card_id, :value, :exp, current_date)", nativeQuery = true)
    void createBalance(UUID uuid, Integer card_id, Integer value, String exp);

    @Modifying
    @Transactional
    @Query(value = "update balance set value=:value where id=:uuid", nativeQuery = true)
    void updateBalance(UUID uuid, Integer value);
}