package com.github.silviacristinaa.mscards.infra.repository;

import com.github.silviacristinaa.mscards.domain.CustomerCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerCardRepository extends JpaRepository<CustomerCard, Long> {

    List<CustomerCard> findByCpf(String cpf);
}
