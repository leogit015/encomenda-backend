package com.encomenda.infrastructure.repository;

import com.encomenda.infrastructure.entity.Porteiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorteiroRepository extends JpaRepository<Porteiro, Long> {
}
