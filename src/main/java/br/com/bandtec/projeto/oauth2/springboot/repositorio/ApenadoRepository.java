
package br.com.bandtec.projeto.oauth2.springboot.repositorio;

import br.com.bandtec.projeto.oauth2.springboot.domain.Apenado;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ApenadoRepository 
        extends CrudRepository<Apenado, Integer>{
    
    List<Apenado> findByNome(String nome);
}
