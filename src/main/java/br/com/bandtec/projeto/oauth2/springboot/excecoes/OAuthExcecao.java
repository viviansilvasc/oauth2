package br.com.bandtec.projeto.oauth2.springboot.excecoes;

public class OAuthExcecao extends RuntimeException {

        public OAuthExcecao() {
                super();
        }
        
        public OAuthExcecao(String message) {
                super(message);
        }

        public OAuthExcecao(Throwable cause) {
                super(cause);
        }
        
}
