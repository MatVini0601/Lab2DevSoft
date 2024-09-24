package com.labsoftware.Rent.Controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.labsoftware.Rent.Model.Cliente;
import com.labsoftware.Rent.Model.Usuario;
import com.labsoftware.Rent.Services.ClienteService;
import com.labsoftware.Rent.Services.UsuarioService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> c = this.clienteService.getAll();
        return ResponseEntity.ok().body(c);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable Integer id, 
                                       @RequestBody Cliente c){
        Usuario u = this.usuarioService.findById(id);
        c.setUsuario(u);
        this.clienteService.create(c);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(c.getUserId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Cliente c, @PathVariable Integer id){
        Usuario u = this.usuarioService.findById(id);
        c.setUsuario(u);
        this.clienteService.update(c);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findByUserId(@PathVariable Integer id){
        Cliente c = this.clienteService.findByUserId(id);
        return ResponseEntity.ok().body(c);
    }
}