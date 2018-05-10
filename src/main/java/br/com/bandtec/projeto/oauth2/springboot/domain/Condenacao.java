package br.com.bandtec.projeto.oauth2.springboot.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_condenacao")


public class Condenacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "id_condenacao")
    private Integer id;
    
    private Integer anos;
    
    private Integer meses;
    
    private Integer dias;
    
    private Date data_inicio;
    
    private Boolean crime_hediondo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnos() {
        return anos;
    }

    public void setAnos(Integer anos) {
        this.anos = anos;
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Boolean getCrime_hediondo() {
        return crime_hediondo;
    }

    public void setCrime_hediondo(Boolean crime_hediondo) {
        this.crime_hediondo = crime_hediondo;
    }
    
    
    
}
