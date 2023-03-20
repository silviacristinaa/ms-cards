package com.github.silviacristinaa.mscards.application.representation;

import com.github.silviacristinaa.mscards.domain.Card;
import com.github.silviacristinaa.mscards.domain.CardFlag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;
    private CardFlag cardFlag;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public Card toModel(){
        return new Card(name, cardFlag, income, basicLimit);
    }
}
