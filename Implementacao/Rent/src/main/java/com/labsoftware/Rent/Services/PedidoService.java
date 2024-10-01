package com.labsoftware.Rent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labsoftware.Rent.Model.Cliente;
import com.labsoftware.Rent.Model.Pedido;
import com.labsoftware.Rent.Model.Veiculo;
import com.labsoftware.Rent.Repositories.PedidoRepository;
import java.util.List;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido create(Pedido p){
        p.setId(null);
        Pedido p1 = p;
        p = this.pedidoRepository.saveAndFlush(p1);
        p.getId();
        return p;
    }

    public Pedido update(Pedido p){
        Pedido newPedido = findById(p.getId());
        newPedido.setCliente(findByPedidoId(p.getId()));
        newPedido.setVeiculo(findVeiculoByPedidoId(p.getId()));
        newPedido.setDataInicio(p.getDataInicio());
        newPedido.setDataFim(p.getDataInicio().plusMonths(p.getDuracaoMeses()));
        newPedido.setStatus(p.getStatus());
        newPedido.setOpcaoCompra(p.getOpcaoCompra());

        return this.pedidoRepository.save(newPedido);
    }

    public Cliente findByPedidoId(Integer id){
        Pedido p = findById(id);
        return p.getCliente();
    }

    public Veiculo findVeiculoByPedidoId(Integer id){
        Pedido p = findById(id);
        return p.getVeiculo();
    }

    public Pedido alterarSituacao(Pedido p, Boolean status){
        Pedido newPedido = findById(p.getId());
        newPedido.setStatus(status);

        return this.pedidoRepository.save(newPedido);
    }

    public Pedido findById(Integer id){
        return this.pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException(
            "Pedido não encontrado"
        ));
    }

    public List<Pedido> getAll(){
        List<Pedido> p = this.pedidoRepository.findAll();
        return p;
    }
}
