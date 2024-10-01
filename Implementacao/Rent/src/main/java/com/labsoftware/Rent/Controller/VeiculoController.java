package com.labsoftware.Rent.Controller;

import org.apache.catalina.connector.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labsoftware.Rent.Model.Veiculo;
import com.labsoftware.Rent.Services.VeiculoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/Veiculo")
public class VeiculoController {
    
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping()
    public ResponseEntity<List<Veiculo>> findAll(){
        List<Veiculo> v = this.veiculoService.getAll();
        return ResponseEntity.ok().body(v);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Integer id){
        Veiculo v = this.veiculoService.findById(id);
        return ResponseEntity.ok().body(v);
    }

    @PostMapping()
    public ResponseEntity<Void> create( @RequestBody Veiculo v){
        v.setId(null);
        this.veiculoService.create(v);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Veiculo v, @PathVariable Integer id){
        v.setId(id);
        this.veiculoService.update(v);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/Disponibilidade/{status}")
    public ResponseEntity<List<Veiculo>> findByDisponibilidade(@PathVariable Integer status){
        List<Veiculo> v = this.veiculoService.findByDisponibilidade(status);
        return ResponseEntity.ok().body(v);
    }

}
