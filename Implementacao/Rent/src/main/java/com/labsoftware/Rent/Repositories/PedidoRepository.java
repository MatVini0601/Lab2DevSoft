package com.labsoftware.Rent.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labsoftware.Rent.Model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}
