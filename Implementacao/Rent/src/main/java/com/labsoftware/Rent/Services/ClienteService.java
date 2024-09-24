package com.labsoftware.Rent.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labsoftware.Rent.Model.Cliente;
import com.labsoftware.Rent.Repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente create(Cliente c){
        c.setId(null);
        Cliente c1 = c;
        c = this.clienteRepository.saveAndFlush(c1);
        c.getId();
        return c;
    }

    public Cliente update(Cliente c){
        Cliente newCliente = findByUserId(c.getUserId());
        newCliente.setNome(c.getNome());
        newCliente.setCpf(c.getCpf());
        newCliente.setRg(c.getRg());
        newCliente.setProfissao(c.getProfissao());
        newCliente.setEndereco(c.getEndereco());

        return this.clienteRepository.save(newCliente);
    }

    public Cliente findByUserId(Integer id){
        Optional<Cliente> c = this.clienteRepository.findByUsuario_Id(id);
        return c.orElseThrow(() -> new RuntimeException(
            "Cliente não encontrado"
        ));
    }

    public List<Cliente> getAll(){
        List<Cliente> c = this.clienteRepository.findAll();
        return c;
    } 
}
