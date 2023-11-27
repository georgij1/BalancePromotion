package com.balance.balance.repoBalance;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="balance")
@Data
public class BalanceTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "id_client")
    private String id_client;
    @Column(name = "balance")
    private Integer balance;
}