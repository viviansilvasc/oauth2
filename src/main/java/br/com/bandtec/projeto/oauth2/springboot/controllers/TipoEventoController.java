
package br.com.bandtec.projeto.oauth2.springboot.controllers;

import br.com.bandtec.projeto.oauth2.springboot.repositorio.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoevento")
public class TipoEventoController {
    
    @Autowired
    private TipoEventoRepository repository;
    
}
