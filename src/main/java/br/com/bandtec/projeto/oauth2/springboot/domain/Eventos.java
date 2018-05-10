package br.com.bandtec.projeto.oauth2.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_eventos")

public class Eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "id_eventos")
    private Integer id;
    
    private Integer anos;
    
    private Integer meses;
    
    private Integer dias;
    
    private Integer horas;
    
    @ManyToOne
    private Condenacao condenacao;
    
    @OneToOne
    private Tipo_Evento tipo_evento;

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

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Condenacao getCondenacao() {
        return condenacao;
    }

    public void setCondenacao(Condenacao condenacao) {
        this.condenacao = condenacao;
    }

    public Tipo_Evento getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(Tipo_Evento tipo_evento) {
        this.tipo_evento = tipo_evento;
    }
    
    
    
    
}
