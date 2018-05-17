
package br.com.bandtec.projeto.oauth2.springboot.controllers;

import br.com.bandtec.projeto.oauth2.springboot.repositorio.CondenacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condenacao")
public class CondenacaoController {
    
    @Autowired
    private CondenacaoRepository repository;
    
}
