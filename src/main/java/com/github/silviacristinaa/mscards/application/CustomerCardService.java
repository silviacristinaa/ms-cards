package com.github.silviacristinaa.mscards.application;

import com.github.silviacristinaa.mscards.domain.CustomerCard;
import com.github.silviacristinaa.mscards.infra.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCardService {

    private final CustomerCardRepository customerCardRepository;

    public List<CustomerCard> listCardsByCpf(String cpf) {
        return customerCardRepository.findByCpf(cpf);
    }
}
