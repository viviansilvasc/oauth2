package br.com.bandtec.oauth2.condenacao.domain;

import java.time.LocalDate;

public class Calculadora {
    
    public LocalDate calcularSoltura(LocalDate dtInicio, Integer dias, 
            Integer meses, Integer anos){
        
        LocalDate dtSoltura = LocalDate.from(dtInicio)
                .plusDays(dias).plusMonths(meses).plusYears(anos);
       
        return dtSoltura;
    }
    
}
