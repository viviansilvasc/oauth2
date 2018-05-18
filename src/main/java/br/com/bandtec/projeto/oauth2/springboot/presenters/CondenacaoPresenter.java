package br.com.bandtec.projeto.oauth2.springboot.presenters;

import br.com.bandtec.projeto.oauth2.springboot.domain.Condenacao;
import java.util.Date;


public class CondenacaoPresenter {
    
    private Integer meses;
    private Integer dias;
    private Date dataInicio;
    private Boolean crimeHediondo;
    private String dataSoltura;
    
    public CondenacaoPresenter(Condenacao condenacao){
        this.meses = condenacao.getMeses();
        this.dias = condenacao.getDias();
        this.dataInicio = condenacao.getDataInicio();
        this.crimeHediondo = condenacao.getCrimeHediondo();
    }

    public Integer getMeses() {
        return meses;
    }

    public Integer getDias() {
        return dias;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Boolean getCrimeHediondo() {
        return crimeHediondo;
    }

    public String getDataSoltura() {
        return dataSoltura;
    }
    
    
}
