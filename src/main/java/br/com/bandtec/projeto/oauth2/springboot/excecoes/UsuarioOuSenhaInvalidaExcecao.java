package br.com.bandtec.projeto.oauth2.springboot.excecoes;

public class UsuarioOuSenhaInvalidaExcecao extends OAuthExcecao {

        public UsuarioOuSenhaInvalidaExcecao(String message) {
                super(message);
        }

        public UsuarioOuSenhaInvalidaExcecao(Throwable cause) {
                super(cause);
        }
        
}

