package br.com.bandtec.projeto.oauth2.springboot.excecoes;

public class TokenInvalidoExcecao extends OAuthExcecao {

        public TokenInvalidoExcecao(String message) {
                super(message);
        }

        public TokenInvalidoExcecao(Throwable cause) {
                super(cause);
        }
        
}