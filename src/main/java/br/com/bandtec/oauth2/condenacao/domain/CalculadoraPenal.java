package br.com.bandtec.oauth2.condenacao.domain;

import br.com.bandtec.calculadoraexecucaopenal.TempoPena;
import java.time.LocalDate;
import java.util.Calendar;

public class CalculadoraPenal {
    
     public Calendar progridePena(Calendar dataPena, Integer ano, Integer mes, Integer dias){
        
        if(ano < 0 || mes < 0 || dias < 0){
            throw new IllegalArgumentException("Valor nao pode ser negativo");
        }
        
        Integer nroDias = ((ano*365) + (mes*30) + dias) /3;
       
        Calendar dia = dataPena;
        dia.add(Calendar.DATE, nroDias);
 
        return dia;
    }
     
     public LocalDate 
        progridePenaJava8(
                LocalDate dataPena, Integer ano, Integer mes, Integer dias){
        
        if(ano < 0 || mes < 0 || dias < 0){
            throw new IllegalArgumentException("Valor nao pode ser negativo");
        }
        LocalDate dataFinal = LocalDate
                .from(dataPena)
                .plusDays(dias)
                .plusMonths(mes)
                .plusYears(ano);
        
        return dataFinal;
    }
        
     //quantos dias pode abater a partir de dias estudados
    public Integer calcularPorTempoEstudos(Integer ano, Integer mes, Integer dias, Integer tempoEstudo){
        
        if(ano < 0 || mes < 0 || dias < 0 || tempoEstudo < 0){
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        
        Integer nroDias = ((ano*365) + (mes*30) + dias) - (tempoEstudo*2);
       
        return nroDias;
    }
      
    public TempoPena calculaTempoPena(TempoPena pena, TempoPena prisaoTemp){
        
        TempoPena tempoCalculado = new TempoPena(pena.getDias(),pena.getMeses(),pena.getAnos());
        
        tempoCalculado.setAnos(pena.getAnos() - prisaoTemp.getAnos());
        tempoCalculado.setMeses(pena.getMeses() - prisaoTemp.getMeses());
        tempoCalculado.setDias(pena.getDias() - prisaoTemp.getDias());
       
        return tempoCalculado;
    }
    
}
