
package br.com.bandtec.oauth2.condenacao.controllers;

import br.com.bandtec.oauth2.condenacao.domain.TipoEvento;
import br.com.bandtec.oauth2.condenacao.repositorio.TipoEventoRepository;
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
@RequestMapping("/tipoevento")
public class TipoEventoController {
    
    static List<TipoEvento> tipoEventos = new ArrayList<>();
    
    @Autowired
    private TipoEventoRepository repository;
    
    @GetMapping
    public ResponseEntity getTodos(){
        Iterable<TipoEvento> condenacoes = this.repository.findAll();
        
        return ResponseEntity.ok(condenacoes);
    }
    
    @GetMapping("/tipoevento/{id}")
    public ResponseEntity pesquisarPorID(
            @PathVariable("id") Integer id){
        
        TipoEvento encontrado = this.repository.findOne(id);
        
        return ResponseEntity.ok(encontrado);
    }
    
    @PostMapping
    public ResponseEntity criar(@RequestBody TipoEvento tipoEvento){
        this.repository.save(tipoEvento);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping
    public ResponseEntity atualizar (@RequestBody TipoEvento tipoEvento){
        for (TipoEvento tipoEventoBase : tipoEventos) {
            if(tipoEventoBase.getId() == tipoEvento.getId()){
            tipoEventoBase.setNome(tipoEvento.getNome());
            
            return ResponseEntity.ok().build();
            }
        }
        
        return ResponseEntity.badRequest().build();
    }
    
}
