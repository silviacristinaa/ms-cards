package com.github.silviacristinaa.mscards.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardFlag cardFlag;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public Card(String name,
                CardFlag cardFlag,
                BigDecimal income,
                BigDecimal basicLimit) {
        this.name = name;
        this.cardFlag = cardFlag;
        this.income = income;
        this.basicLimit = basicLimit;
    }
}
