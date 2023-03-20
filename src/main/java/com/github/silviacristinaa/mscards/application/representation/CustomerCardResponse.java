package com.github.silviacristinaa.mscards.application.representation;

import com.github.silviacristinaa.mscards.application.CustomerCardService;
import com.github.silviacristinaa.mscards.domain.CardFlag;
import com.github.silviacristinaa.mscards.domain.CustomerCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCardResponse {

    private String name;
    private CardFlag cardFlag;
    private BigDecimal limitReleased;

    public static CustomerCardResponse fromModel(CustomerCard model) {
        return new CustomerCardResponse(
                model.getCard().getName(),
                model.getCard().getCardFlag(),
                model.getCardLimit()
        );
    }
}
