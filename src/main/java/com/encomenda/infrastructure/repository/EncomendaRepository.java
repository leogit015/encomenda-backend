package com.encomenda.infrastructure.repository;

import com.encomenda.infrastructure.entity.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {
}
