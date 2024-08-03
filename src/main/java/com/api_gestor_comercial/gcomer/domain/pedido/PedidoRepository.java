package com.api_gestor_comercial.gcomer.domain.pedido;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Page<Pedido> findByEnviadoTrue();

    Page<Pedido> findByEnviadoFalse();
}
