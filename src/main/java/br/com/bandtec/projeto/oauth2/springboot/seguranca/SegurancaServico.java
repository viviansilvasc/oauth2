package br.com.bandtec.projeto.oauth2.springboot.seguranca;

import br.com.bandtec.projeto.oauth2.springboot.excecoes.TokenCriadoExcecao;
import br.com.bandtec.projeto.oauth2.springboot.excecoes.TokenExpiradoExcecao;
import br.com.bandtec.projeto.oauth2.springboot.excecoes.TokenInvalidoExcecao;
import br.com.bandtec.projeto.oauth2.springboot.excecoes.UsuarioOuSenhaInvalidaExcecao;
import br.com.bandtec.projeto.oauth2.springboot.modelos.SegurancaAPI;
import br.com.bandtec.projeto.oauth2.springboot.modelos.Usuario;
import br.com.bandtec.projeto.oauth2.springboot.repositorio.SegurancaRepositorio;
import br.com.bandtec.projeto.oauth2.springboot.repositorio.UsuarioRepositorio;
import br.com.bandtec.projeto.oauth2.springboot.util.DateUtil;
import br.com.bandtec.projeto.oauth2.springboot.util.Formatador;
import br.com.bandtec.projeto.oauth2.springboot.util.SegurancaAPIThreadLocal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SegurancaServico {

        private final String APP_CLIENT_ID = "exemploaplicativocliente";
        private final String APP_CLIENT_PASSWD = "9834ba657bb2c60b5bb53de6f4201905";

        @Autowired
        private SegurancaRepositorio segurancaRepository;

        @Autowired
        private UsuarioRepositorio usuarioRepository;

        private SegurancaAPI retornarPorToken(String token) {
                return this.segurancaRepository.findByToken(token);
        }

        private SegurancaAPI retornarPorUsuario(Usuario usuario) {
                return this.segurancaRepository.findByUsuario(usuario);
        }

        private synchronized void atualizarToken(Usuario usuario, String token, Date proximaDataExpiracao) throws TokenInvalidoExcecao, TokenExpiradoExcecao, TokenCriadoExcecao {
                if (usuario == null) {
                        throw new TokenInvalidoExcecao("Problema interno ao criar token: usuario nulo.");
                }
                if (proximaDataExpiracao == null) {
                        throw new TokenInvalidoExcecao("Problema interno ao criar token: proximaDataExpiracao nula.");
                }

                SegurancaAPI segurancaAPI = this.retornarPorUsuario(usuario);
                if (segurancaAPI == null) {
                        segurancaAPI = new SegurancaAPI(token, proximaDataExpiracao, usuario);
                } else {
                        segurancaAPI.atualizarToken(token, proximaDataExpiracao);
                }

                segurancaAPI = this.segurancaRepository.save(segurancaAPI);
                
                if (segurancaAPI.isSalvo()) {
                        if (segurancaAPI.expirado()) {
                                throw new TokenExpiradoExcecao("Token de acesso expirado. Gere um novo token e tente novamente.");
                        }
                        else {
                                throw new TokenCriadoExcecao(segurancaAPI);
                        }
                }
        }

        private Date retornarProximaDataExpiracao() {
                Date agora = new Date();
                int dia = DateUtil.retornaUnidade(agora, DateUtil.DIA);
                int mes = DateUtil.retornaUnidade(agora, DateUtil.MES);
                int ano = DateUtil.retornaUnidade(agora, DateUtil.ANO);
                return DateUtil.retornaData(dia + "/" + mes + "/" + ano + " 23:59:59", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));
        }

        private void validarAcessoAplicativo(String appClientId, String appClientSecret) throws TokenInvalidoExcecao {
                if (!appClientId.equalsIgnoreCase(APP_CLIENT_ID) && !appClientSecret.equalsIgnoreCase(APP_CLIENT_PASSWD)) {
                        throw new TokenInvalidoExcecao("Seguranca: aplicativo nao autorizado.");
                }
        }
        
        /*private Usuario retornarPorLoginESenha(String login, String senha) throws UsuarioOuSenhaInvalidaExcecao{
                Usuario  usuario = this.usuarioRepository.findByLoginAndSenha(login, Formatador.encryptMD5(senha));
                if(usuario == null){
                        throw new UsuarioOuSenhaInvalidaExcecao("Usuário não encontrado.");
                }
                return usuario;
        }*/
      
        public SegurancaAPI getUsuarioLogado() throws TokenInvalidoExcecao {
                SegurancaAPI seg = SegurancaAPIThreadLocal.getSegurancaAPI();
                if (seg == null) {
                        throw new TokenInvalidoExcecao("Usuário não logado.");
                } else {
                        return seg;
                }
        }

}
