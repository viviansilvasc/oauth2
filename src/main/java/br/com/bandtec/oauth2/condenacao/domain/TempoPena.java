package br.com.bandtec.oauth2.condenacao.domain;

public class TempoPena {
    private int dias;
    private int meses;
    private int anos;

    public TempoPena(int dias, int meses, int anos) {
        this.dias = dias;
        this.meses = meses;
        this.anos = anos;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getAnos() {
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }
    
   
    
}
