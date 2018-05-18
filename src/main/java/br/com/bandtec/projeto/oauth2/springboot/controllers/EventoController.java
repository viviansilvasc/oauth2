
package br.com.bandtec.projeto.oauth2.springboot.controllers;

import br.com.bandtec.projeto.oauth2.springboot.domain.Evento;
import br.com.bandtec.projeto.oauth2.springboot.repositorio.EventoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {
    static List<Evento> eventos = new ArrayList<>();
    
    @Autowired 
    private EventoRepository repository;
    
    @GetMapping
    public ResponseEntity getTodos(){
        Iterable<Evento> eventos = this.repository.findAll();
        
        return ResponseEntity.ok(eventos);
    }
    
    @GetMapping("/evento/{id}")
    public ResponseEntity pesquisarPorID(
            @PathVariable("id") Integer id){
        
        List<Evento> encontrados = this.repository.findById(id);
        
        return ResponseEntity.ok(encontrados);
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
    
    @PutMapping
    public ResponseEntity atualizar (@RequestBody Evento evento){
        for (Evento eventoBase : eventos) {
            if(eventoBase.getId() == evento.getId()){
            eventoBase.setAnos(evento.getAnos());
            eventoBase.setMeses(evento.getMeses());
            eventoBase.setDias(evento.getDias());
            eventoBase.setHoras(evento.getHoras());
            eventoBase.setCondenacao(evento.getCondenacao());
            eventoBase.setTipoEvento(evento.getTipoEvento());
            return ResponseEntity.ok().build();
            }
        }
        
        return ResponseEntity.badRequest().build();
    }
    
}
