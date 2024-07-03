package com.encomenda.infrastructure.repository;

import com.encomenda.infrastructure.entity.Condom;
import com.encomenda.infrastructure.entity.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CondomRepository extends JpaRepository<Condom, Long> {
    Optional<Morador> findByNome(String nome);
}
