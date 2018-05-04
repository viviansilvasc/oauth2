package br.com.bandtec.projeto.oauth2.springboot.repositorio;

import br.com.bandtec.projeto.oauth2.springboot.modelos.SegurancaAPI;
import br.com.bandtec.projeto.oauth2.springboot.modelos.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SegurancaRepositorio extends CrudRepository<SegurancaAPI, Long> {
        
        @Query("SELECT s FROM SegurancaAPI s WHERE s.token = :token")
        SegurancaAPI findByToken(@Param("token") String token);
        
        SegurancaAPI findByUsuario(Usuario usuario);
        
}
