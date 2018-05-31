
package br.com.bandtec.oauth2.condenacao.repositorio;

import br.com.bandtec.oauth2.condenacao.domain.Condenacao;
import org.springframework.data.repository.CrudRepository;

public interface CondenacaoRepository 
        extends CrudRepository<Condenacao, Integer>{

}
