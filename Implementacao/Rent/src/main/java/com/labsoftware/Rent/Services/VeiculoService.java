package com.labsoftware.Rent.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsoftware.Rent.Model.Veiculo;
import com.labsoftware.Rent.Repositories.VeiculoRepository;

import jakarta.transaction.Transactional;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional
    public Veiculo create(Veiculo v){
        v.setId(null);
        Veiculo v1 = v;
        v = this.veiculoRepository.saveAndFlush(v1);
        v.getId();
        return v;
    }

    public Veiculo update(Veiculo v){
        Veiculo newVeiculo = findById(v.getId());
        newVeiculo.setMatricula(v.getMatricula());
        newVeiculo.setAno(v.getAno());
        newVeiculo.setMarca(v.getMarca());
        newVeiculo.setModelo(v.getModelo());
        newVeiculo.setPlaca(v.getPlaca());

        return this.veiculoRepository.save(newVeiculo);
    }

    public Veiculo findById(Integer id){
        return this.veiculoRepository.findById(id).orElseThrow(() -> new RuntimeException(
            "Veiculo não encontrado"
        ));
    }

    public List<Veiculo> getAll(){
        List<Veiculo> v = this.veiculoRepository.findAll();
        return v;
    }

    public List<Veiculo> findByDisponibilidade(Integer status){
        List<Veiculo> v = this.veiculoRepository.findByDisponibilidade(status);
        return v;
    }
}
