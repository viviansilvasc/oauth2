package br.com.bandtec.oauth2.condenacao.teste;


import br.com.bandtec.oauth2.condenacao.domain.CalculadoraPenal;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CalculadoraPenalTeste {
    
   @Test
    public void testProgressaoPenal(){
        CalculadoraPenal crime = new CalculadoraPenal();
        Calendar dataPena = Calendar.getInstance();
        
        Calendar data = Calendar.getInstance();
        
        Calendar dataResultado = crime.progridePena(dataPena, 1, 3, 5);
        
        //validando retorno esperado
        Integer dias = ((1*365) + (3*30) + 5) /3;
        dataPena.add(Calendar.DATE, dias);
        data = dataPena;
        
        assertEquals(dataResultado, data);
        
        //validando retorno errado
        dataPena.add(Calendar.DATE, dias-1);
        data = dataPena;
        
        //assertNotEquals(dataResultado, data);
        
        //valor negativo
        dataResultado = crime.progridePena(dataPena, 1, -3, 5);
        dias = ((1*365) + (3*30) + 5) /3;
        dataPena.add(Calendar.DATE, dias);
        data = dataPena;
        
        assertEquals(dataResultado, data);
        
        ///dias de estudo 
        Integer diasTeste = crime.calcularPorTempoEstudos(1, 1, 1, 15);
        Integer resultado = ((1*365) + (1*30) + 1) - (15*2);
        assertEquals(diasTeste, resultado);
        
        
        //negativo
        diasTeste = crime.calcularPorTempoEstudos(1, 1, -1, -15);
        resultado = ((1*365) + (1*30) + 1) - (15*2);
        assertEquals(diasTeste, resultado);
        
    } 

  
}
