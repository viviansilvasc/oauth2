package br.com.bandtec.projeto.oauth2.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_apenado")

public class Apenado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "id_apenado")
    private Integer id;
    
    private String nome;
    
    @ManyToOne
    private Condenacao condenacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Condenacao getCondenacao() {
        return condenacao;
    }

    public void setCondenacao(Condenacao condenacao) {
        this.condenacao = condenacao;
    }
    
    
    
    
}
