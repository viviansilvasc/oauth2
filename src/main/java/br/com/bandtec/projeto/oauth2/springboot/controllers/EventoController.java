
package br.com.bandtec.projeto.oauth2.springboot.controllers;

import br.com.bandtec.projeto.oauth2.springboot.domain.Evento;
import br.com.bandtec.projeto.oauth2.springboot.repositorio.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {
    
    @Autowired 
    private EventoRepository repository;
    
    @GetMapping
    public ResponseEntity getTodos(){
        Iterable<Evento> eventos = this.repository.findAll();
        
        return ResponseEntity.ok(eventos);
    }
    
    @PostMapping
    public ResponseEntity criar (@RequestBody Evento evento){
        this.repository.save(evento);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(
        @PathVariable("id") Integer id){
        
        this.repository.delete(id);
        
        return ResponseEntity.ok().build();
    }
    
}
