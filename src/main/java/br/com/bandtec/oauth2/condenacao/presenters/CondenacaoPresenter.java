package br.com.bandtec.oauth2.condenacao.presenters;

import br.com.bandtec.oauth2.condenacao.domain.Apenado;
import br.com.bandtec.oauth2.condenacao.domain.Calculadora;
import br.com.bandtec.oauth2.condenacao.domain.Condenacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class CondenacaoPresenter {
    
    private Integer meses;
    private Integer anos;
    private Integer dias;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;
    private Boolean crimeHediondo;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataSoltura;
    
    private Apenado apenado;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calculadora calculadora;
    
    public CondenacaoPresenter(Condenacao condenacao){
        this.meses = condenacao.getMeses();
        this.dias = condenacao.getDias();
        this.anos = condenacao.getAnos();
        this.dataInicio = condenacao.getDataInicio();
        this.crimeHediondo = condenacao.getCrimeHediondo();
        this.dataSoltura = calculadora.calcularSoltura(dataInicio, dias, meses, anos);
        this.apenado = condenacao.getApenado();
    }

    public Apenado getApenado() {
        return apenado;
    }

    public void setApenado(Apenado apenado) {
        this.apenado = apenado;
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
