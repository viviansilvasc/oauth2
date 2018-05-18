
package br.com.bandtec.projeto.oauth2.springboot.repositorio;

import br.com.bandtec.projeto.oauth2.springboot.domain.TipoEvento;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TipoEventoRepository 
        extends CrudRepository<TipoEvento, Integer>{
    
    List<TipoEvento> findById(Integer id);
}
