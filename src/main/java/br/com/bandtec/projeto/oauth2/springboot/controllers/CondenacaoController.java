
package br.com.bandtec.projeto.oauth2.springboot.controllers;

import br.com.bandtec.projeto.oauth2.springboot.domain.Condenacao;
import br.com.bandtec.projeto.oauth2.springboot.repositorio.CondenacaoRepository;
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
@RequestMapping("/condenacao")
public class CondenacaoController {
    
    static List<Condenacao> condenacoes = new ArrayList<>();
    
    @Autowired
    private CondenacaoRepository repository;
    
    @GetMapping
    public ResponseEntity getTodos(){
        Iterable<Condenacao> condenacoes = this.repository.findAll();
        
        return ResponseEntity.ok(condenacoes);
    }
    
    @PostMapping
    public ResponseEntity criar(@RequestBody Condenacao condenacao){
        this.repository.save(condenacao);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(
        @PathVariable("id") Integer id){
        
        this.repository.delete(id);
        
        return ResponseEntity.ok().build();
    }
    
    @PutMapping
    public ResponseEntity atualizar (@RequestBody Condenacao condenacao){
        for (Condenacao condenacaoBase : condenacoes) {
            if(condenacaoBase.getId() == condenacao.getId()){
            condenacaoBase.setAnos(condenacao.getAnos());
            condenacaoBase.setMeses(condenacao.getMeses());
            condenacaoBase.setDias(condenacao.getDias());
            condenacaoBase.setDataInicio(condenacao.getDataInicio());
            condenacaoBase.setCrimeHediondo(condenacao.getCrimeHediondo());
            condenacaoBase.setApenado(condenacao.getApenado());
            return ResponseEntity.ok().build();
            }
        }
        
        return ResponseEntity.badRequest().build();
    }
   
    
}
