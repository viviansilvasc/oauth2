
package br.com.bandtec.projeto.oauth2.springboot.controllers;

import br.com.bandtec.projeto.oauth2.springboot.domain.Apenado;
import br.com.bandtec.projeto.oauth2.springboot.repositorio.ApenadoRepository;
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
@RequestMapping("/apenado")
public class ApenadoController {
    
    @Autowired
    private ApenadoRepository repository;
    
    @GetMapping
    public ResponseEntity getTodos(){
        Iterable<Apenado> apenados = this.repository.findAll();
        
        return ResponseEntity.ok(apenados);
    }
    
    @GetMapping("/apenado/{nome}")
    public ResponseEntity pesquisarPorNome(
            @PathVariable("nome") String nome){
        
        List<Apenado> encontrados = this.repository.findByNome(nome);
        
        return ResponseEntity.ok(encontrados);
    }
    
    @PostMapping
    public ResponseEntity criar(@RequestBody Apenado apenado){
        this.repository.save(apenado);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(
        @PathVariable("id") Integer id){
        
        this.repository.delete(id);
        
        return ResponseEntity.ok().build();
    }
   
}
