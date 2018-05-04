package br.com.bandtec.projeto.oauth2.springboot.web;

import br.com.bandtec.projeto.oauth2.springboot.modelos.SegurancaAPI;
import br.com.bandtec.projeto.oauth2.springboot.seguranca.Privado;
import br.com.bandtec.projeto.oauth2.springboot.seguranca.Publico;
import br.com.bandtec.projeto.oauth2.springboot.seguranca.SegurancaServico;
import br.com.bandtec.projeto.oauth2.springboot.util.OAuthController;
import br.com.bandtec.projeto.oauth2.springboot.util.RoleEnum;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/seguranca")
public class SegurancaController extends OAuthController{
        
        @Autowired
        private SegurancaServico segurancaServico;
        
        //@Publico
        //@ResponseBody
        //@RequestMapping(value = "/logar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	//public String logar(HttpServletRequest request) {
        //        OAuthResponse response = segurancaServico.logarOAuth(request);
        //        return response.getBody();
	//}
        
        @Privado(role=RoleEnum.ROLE_GERAL)
        @ResponseBody
        @RequestMapping(value = "/usuario/logado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SegurancaAPI retornarUsuarioLogado(HttpServletRequest request) {
                return segurancaServico.getUsuarioLogado();
	}
}
