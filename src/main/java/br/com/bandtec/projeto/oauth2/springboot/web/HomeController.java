package br.com.bandtec.projeto.oauth2.springboot.web;

import br.com.bandtec.projeto.oauth2.springboot.seguranca.Privado;
import br.com.bandtec.projeto.oauth2.springboot.util.OAuthController;
import br.com.bandtec.projeto.oauth2.springboot.util.RoleEnum;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/home")
public class HomeController extends OAuthController{
    
    @Privado(role = RoleEnum.ROLE_GERAL)
    @ResponseBody
    @RequestMapping(value = "/acesso/geral", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String acessoGeral() {
        return "Geral: Acesso Permitido!";
    }

    @Privado(role = RoleEnum.ROLE_VISITANTE)
    @ResponseBody
    @RequestMapping(value = "/acesso/visitante", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String acessoVisitante() {
        return "Visitante: Acesso Permitido!";
    }

    @Privado(role = RoleEnum.ROLE_ADMIN)
    @ResponseBody
    @RequestMapping(value = "/acesso/admin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String acessoAdmin() {
        return "Admin: Acesso Permitido!";
    }
}
