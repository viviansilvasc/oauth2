
package br.com.bandtec.oauth2.condenacao.repositorio;

import br.com.bandtec.oauth2.condenacao.domain.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository 
        extends CrudRepository<Evento, Integer>{
   
}
