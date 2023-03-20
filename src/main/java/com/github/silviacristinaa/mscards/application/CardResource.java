package com.github.silviacristinaa.mscards.application;

import com.github.silviacristinaa.mscards.application.representation.CardSaveRequest;
import com.github.silviacristinaa.mscards.application.representation.CustomerCardResponse;
import com.github.silviacristinaa.mscards.domain.Card;
import com.github.silviacristinaa.mscards.domain.CustomerCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardResource {

    private final CardService cardService;
    private final CustomerCardService customerCardService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CardSaveRequest request) {
        Card card = request.toModel();
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsByIncome(@RequestParam("income") Long income) {
        List<Card> cards = cardService.getCardsByIncomeLessEqual(income);
        return ResponseEntity.ok(cards);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CustomerCardResponse>> getCardsByCustomer(@RequestParam("cpf") String cpf) {
        List<CustomerCard> customerCardList = customerCardService.listCardsByCpf(cpf);
        List<CustomerCardResponse> resultList = customerCardList.stream()
                .map(CustomerCardResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
