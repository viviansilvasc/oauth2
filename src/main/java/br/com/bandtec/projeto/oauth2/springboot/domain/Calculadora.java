package br.com.bandtec.projeto.oauth2.springboot.domain;

import java.time.LocalDate;

public class Calculadora {
    
    public LocalDate calcularSoltura(LocalDate dtInicio, Integer dias, 
            Integer meses, Integer anos){
        
        LocalDate dtSoltura = LocalDate.from(dtInicio)
                .plusDays(dias).plusMonths(meses).plusYears(anos);
       
        return dtSoltura;
    }
    
}
