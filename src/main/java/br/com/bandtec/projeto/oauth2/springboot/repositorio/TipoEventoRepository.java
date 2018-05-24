
package br.com.bandtec.projeto.oauth2.springboot.repositorio;

import br.com.bandtec.projeto.oauth2.springboot.domain.TipoEvento;
import org.springframework.data.repository.CrudRepository;

public interface TipoEventoRepository 
        extends CrudRepository<TipoEvento, Integer>{
 
}
