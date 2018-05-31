package br.com.bandtec.oauth2.condenacao.presenters;

import br.com.bandtec.oauth2.condenacao.domain.Calculadora;
import br.com.bandtec.oauth2.condenacao.domain.Condenacao;
import java.time.LocalDate;

public class CondenacaoPresenter {
    
    private Integer meses;
    private Integer anos;
    private Integer dias;
    private LocalDate dataInicio;
    private Boolean crimeHediondo;
    private LocalDate dataSoltura;
    private Calculadora calculadora;
    
    public CondenacaoPresenter(Condenacao condenacao){
        this.meses = condenacao.getMeses();
        this.dias = condenacao.getDias();
        this.anos = condenacao.getAnos();
        this.dataInicio = condenacao.getDataInicio();
        this.crimeHediondo = condenacao.getCrimeHediondo();
        this.dataSoltura = calculadora.calcularSoltura(dataInicio, dias, meses, anos);
    }

    public Calculadora getCalculadora() {
        return calculadora;
    }
    
    public Integer getAnos() {
        return anos;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataSoltura() {
        return dataSoltura;
    }
    
    public Integer getMeses() {
        return meses;
    }

    public Integer getDias() {
        return dias;
    }

    public Boolean getCrimeHediondo() {
        return crimeHediondo;
    }

    
    
    
}
