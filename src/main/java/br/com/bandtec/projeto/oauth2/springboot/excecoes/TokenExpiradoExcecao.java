package br.com.bandtec.projeto.oauth2.springboot.excecoes;

public class TokenExpiradoExcecao extends OAuthExcecao {

        public TokenExpiradoExcecao(String message) {
                super(message);
        }

        public TokenExpiradoExcecao(Throwable cause) {
                super(cause);
        }
        
}
