package br.com.bandtec.projeto.oauth2.springboot.repositorio;

import br.com.bandtec.projeto.oauth2.springboot.modelos.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
        
        @EntityGraph(value = "perfil.permissoes", type = EntityGraph.EntityGraphType.FETCH)
        Usuario findByLogin(String login);
        
        @EntityGraph(value = "perfil.permissoes", type = EntityGraph.EntityGraphType.FETCH)
        Usuario findByLoginAndSenha(String login, String senha);
        
}

