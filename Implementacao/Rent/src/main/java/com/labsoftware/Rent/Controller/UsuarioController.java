package com.labsoftware.Rent.Controller;

import java.net.URI;
import java.util.List;

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
import com.labsoftware.Rent.Services.UsuarioService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario u){
        u = this.usuarioService.create(u);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(u.getId()).toUri();
        
            return ResponseEntity.created(uri).body(u);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> u = this.usuarioService.findAll();
        return ResponseEntity.ok().body(u);
    }

     @GetMapping("/logar/{email}")
    public ResponseEntity<Usuario> findLogin(@PathVariable String email){
        Usuario c = this.usuarioService.findByEmail(email);
        return ResponseEntity.ok().body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Usuario u, @PathVariable Integer id){
        u.setId(id);
        this.usuarioService.update(u);
        return ResponseEntity.noContent().build();
    }
}