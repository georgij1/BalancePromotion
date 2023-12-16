package com.balance.balance.repoBalance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.util.UUID;

@Accessors(chain = true)
@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column("card_id")
    private Integer card_id;
    @Column("value")
    private Integer value;
    @Column("exp")
    private String exp;
    @Column("date_create_upd")
    private String date_create_upd;
}