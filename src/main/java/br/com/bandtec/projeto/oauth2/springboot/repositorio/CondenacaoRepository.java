
package br.com.bandtec.projeto.oauth2.springboot.repositorio;

import br.com.bandtec.projeto.oauth2.springboot.domain.Condenacao;
import org.springframework.data.repository.CrudRepository;

public interface CondenacaoRepository 
        extends CrudRepository<Condenacao, Integer>{

}
