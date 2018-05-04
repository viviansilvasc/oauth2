package br.com.bandtec.projeto.oauth2.springboot.excecoes;

import br.com.bandtec.projeto.oauth2.springboot.modelos.SegurancaAPI;

public class TokenCriadoExcecao extends OAuthExcecao {

        private SegurancaAPI segurancaAPI;
        
        public TokenCriadoExcecao(SegurancaAPI segurancaAPI) {
                super("Token ja criado para este usuario.");
                this.segurancaAPI = segurancaAPI;
        }

        public SegurancaAPI getSegurancaAPI() {
                return segurancaAPI;
        }
}
