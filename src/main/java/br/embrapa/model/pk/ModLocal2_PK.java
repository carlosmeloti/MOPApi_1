package br.embrapa.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import br.embrapa.model.ModLocal1;

@Embeddable
public class ModLocal2_PK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="d04_cdempresa", referencedColumnName="d03_cdempresa", foreignKey = @ForeignKey(name="local2_fk")),
		@JoinColumn(name="d04_cdlocal1", referencedColumnName="d03_cdlocal1", foreignKey = @ForeignKey(name="local2_fk"))
	})
	private ModLocal1 modLocal1;

	@Column(name="d04_cdlocal2")
	private Long cdLocal2;
	
	
	
	public ModLocal2_PK() {
	}

	


	public ModLocal2_PK(Long cdLocal2, ModLocal1 modLocal1) {
		this.cdLocal2 = cdLocal2;
		this.modLocal1 = modLocal1;
	}




	public Long getCdLocal2() {
		return cdLocal2;
	}



	public void setCdLocal2(Long cdLocal2) {
		this.cdLocal2 = cdLocal2;
	}



	public ModLocal1 getModLocal1() {
		return modLocal1;
	}



	public void setModLocal1(ModLocal1 modLocal1) {
		this.modLocal1 = modLocal1;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdLocal2 == null) ? 0 : cdLocal2.hashCode());
		result = prime * result + ((modLocal1 == null) ? 0 : modLocal1.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModLocal2_PK other = (ModLocal2_PK) obj;
		if (cdLocal2 == null) {
			if (other.cdLocal2 != null)
				return false;
		} else if (!cdLocal2.equals(other.cdLocal2))
			return false;
		if (modLocal1 == null) {
			if (other.modLocal1 != null)
				return false;
		} else if (!modLocal1.equals(other.modLocal1))
			return false;
		return true;
	}


	
}