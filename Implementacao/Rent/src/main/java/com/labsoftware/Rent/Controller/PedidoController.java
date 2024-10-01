package com.labsoftware.Rent.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.labsoftware.Rent.Model.Cliente;
import com.labsoftware.Rent.Model.Pedido;
import com.labsoftware.Rent.Services.ClienteService;
import com.labsoftware.Rent.Services.PedidoService;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService  pedidoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> p = this.pedidoService.getAll();
        return ResponseEntity.ok().body(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id){
        Pedido p = this.pedidoService.findById(id);
        return ResponseEntity.ok().body(p);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Pedido p){
        Cliente c = clienteService.findByUserId(p.getCliente().getUserId());
        p.setDataFim(p.getDataInicio().plusMonths(p.getDuracaoMeses()));
        p.setStatus(false);
        p.setCliente(c);
        p.setId(null);
        p.getVeiculo().setStatus(true);
        this.pedidoService.create(p);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Pedido p){
        p.setId(id);
        
        this.pedidoService.update(p);
        return ResponseEntity.noContent().build();
    }
}
