package br.com.bandtec.projeto.oauth2.springboot.util;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtil {

    public static final int SEGUNDO = 1;
    public static final int MINUTO = 2;
    public static final int HORA = 3;
    public static final int DIA = 4;
    public static final int SEMANA = 5;
    public static final int MES = 6;
    public static final int ANO = 7;

    private static final DateFormat DF_DATA = new SimpleDateFormat("dd/MM/yyyy");

    public static final DateFormat DF_DATA_HORA_MINUTO = new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm");

    public static Date arredondaDataComMaximaHora(Date data) {
        if (data == null) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 23:59:59");
        DateFormat dateFormatTransf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            return dateFormatTransf.parse(dateFormat.format(data));
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String FormatData_ptBR(Date data) {
        return DF_DATA.format(data);
    }

    /**
     * @param data
     * @return {@link String} em formato ptBR com hora
     */
    public static String FormatDataHora_ptBR(Date data) {
        return DF_DATA_HORA_MINUTO.format(data);
    }

    /**
     * Format uma data de acordo com o padrao passado
     *
     * @param data
     * @param pattern
     * @return String
     * @see {@link SimpleDateFormat}
     */
    public static String FormatData_Pattern(Date data, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(data);
    }

    /**
     * Soma a uma data (dataInicio) um tempo especificado por valor e unidade
     * .Ex: Date dataAtualizada = DateUtilsTribunais.somaData(new Date(), 2,
     * DateUtilsTribunais.MES); <br/>
     * Pode-se subtrair uma data, passando o valor negativo.
     *
     * @param dataInicio
     * @param valor
     * @param unidade
     * @return {@link Date}
     */
    public static Date somaSubtraiData(Date data, int valor, int unidade) {
        Date dataReturn = (Date) data.clone();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dataReturn);

        if (unidade == DateUtil.SEGUNDO) {
            calendar.add(Calendar.SECOND, valor);
        } else if (unidade == DateUtil.MINUTO) {
            calendar.add(Calendar.MINUTE, valor);
        } else if (unidade == DateUtil.HORA) {
            calendar.add(Calendar.HOUR_OF_DAY, valor);
        } else if (unidade == DateUtil.DIA) {
            calendar.add(Calendar.DAY_OF_YEAR, valor);
        } else if (unidade == DateUtil.SEMANA) {
            calendar.add(Calendar.WEEK_OF_YEAR, valor);
        } else if (unidade == DateUtil.MES) {
            calendar.add(Calendar.MONTH, valor);
        } else if (unidade == DateUtil.ANO) {
            calendar.add(Calendar.YEAR, valor);
        }

        dataReturn.setTime(calendar.getTimeInMillis());
        return dataReturn;
    }

    public static Date retornaData(String data) {
        try {
            return DF_DATA.parse(data);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static Date retornaData(String data, DateFormat df) {
        try {
            return df.parse(data);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static Integer retornaUnidade(Date data, int unidade) throws IllegalArgumentException {
        Calendar cale = GregorianCalendar.getInstance();
        cale.setTime(data);

        if (unidade == DateUtil.DIA) {
            return cale.get(Calendar.DAY_OF_MONTH);
        } else if (unidade == DateUtil.MES) {
            return cale.get(Calendar.MONTH) + 1;
        } else if (unidade == DateUtil.ANO) {
            return cale.get(Calendar.YEAR);
        } else if (unidade == DateUtil.HORA) {
            return cale.get(Calendar.HOUR_OF_DAY);
        } else if (unidade == DateUtil.MINUTO) {
            return cale.get(Calendar.MINUTE);
        } else if (unidade == DateUtil.SEGUNDO) {
            return cale.get(Calendar.SECOND);
        } else if (unidade == DateUtil.SEMANA) {
            return cale.get(Calendar.WEEK_OF_MONTH);
        } else {
            throw new IllegalArgumentException("Unidade especificada nao valida. Escolha: DIA, MES ou ANO");
        }

    }

    public static String retornarHora(Date date) {
        DateFormat dateFormatHora = new SimpleDateFormat("HH:mm:ss");
        return dateFormatHora.format(date);
    }

    public static int retornarAnoCorrente() {
        return retornaUnidade(new Date(), DateUtil.ANO);
    }

    /**
     * Retorna lista com os nomes de todos os meses.
     *
     * OBS: nesta versao atual, no retorno de getMonths, o ultimo item sempre
     * era vazio. Por conta disso pega-se todos os dados do array menos o
     * ultimo.
     *
     * @return List<String>
     */
    public static List<String> retornarListaMesesExtenso() {
        return Arrays.asList(new DateFormatSymbols().getMonths()).subList(0, 12);
    }

}
