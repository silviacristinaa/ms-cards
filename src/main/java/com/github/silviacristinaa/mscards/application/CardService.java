package com.github.silviacristinaa.mscards.application;

import com.github.silviacristinaa.mscards.domain.Card;
import com.github.silviacristinaa.mscards.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card){
        return cardRepository.save(card);
    }

    public List<Card> getCardsByIncomeLessEqual(Long income) {
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return cardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
