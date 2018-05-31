
package br.com.bandtec.oauth2.condenacao.repositorio;

import br.com.bandtec.oauth2.condenacao.domain.Apenado;
import org.springframework.data.repository.CrudRepository;

public interface ApenadoRepository 
        extends CrudRepository<Apenado, Integer>{
}
