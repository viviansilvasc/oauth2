package br.com.bandtec.projeto.oauth2.springboot.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.log4j.Logger;

@MappedSuperclass
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class Modelos implements Serializable {
        
	protected static final Logger logger = Logger.getLogger(Modelos.class);
	private static final long serialVersionUID = -1340481266616282366L;
        
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();
        
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
        
	public abstract Long getId();
      	        
	@Override
	public String toString() {
		return this.getClass().getName()+"[id=" + getId() + "]";
	}
        
	public boolean isSalvo() {
		return getId() != null;
	}

	public boolean isNaoSalvo() {
		return !isSalvo();
	}

        public Date getDataCriacao() {
                return dataCriacao;
        }

        public Date getDataAtualizacao() {
                return dataAtualizacao;
        }

}
