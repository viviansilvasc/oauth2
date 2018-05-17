
package br.com.bandtec.projeto.oauth2.springboot.repositorio;

import br.com.bandtec.projeto.oauth2.springboot.domain.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository 
        extends CrudRepository<Evento, Integer>{
    
}