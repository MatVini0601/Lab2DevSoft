package com.labsoftware.Rent.Repositories;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.labsoftware.Rent.Model.Cliente;
import com.labsoftware.Rent.Model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    @Query(value = "SELECT * FROM veiculos where status = :status", nativeQuery = true)
    List<Veiculo> findByDisponibilidade(@Param("status") Integer status);
}
