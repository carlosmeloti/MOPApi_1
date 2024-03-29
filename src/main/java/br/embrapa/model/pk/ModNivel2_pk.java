package br.embrapa.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import br.embrapa.model.ModNivel1;
import br.embrapa.model.ModNivel2;

@Embeddable
public class ModNivel2_PK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="d11_cdempresa", referencedColumnName="d10_cdempresa", foreignKey = @ForeignKey(name="nivel1_empresa_fk")),
		@JoinColumn(name="d11_cdnivel1", referencedColumnName="d10_cdnivel1", foreignKey = @ForeignKey(name="nivel1_empresa_fk"))
	})
	private ModNivel1 modNivel1;
	
	@Column(name="d11_cdnivel2")
	private Long cdNivel2;

	public ModNivel1 getModNivel1() {
		return modNivel1;
	}

	public void setModNivel1(ModNivel1 modNivel1) {
		this.modNivel1 = modNivel1;
	}

	public Long getCdNivel2() {
		return cdNivel2;
	}

	public void setCdNivel2(Long cdNivel2) {
		this.cdNivel2 = cdNivel2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdNivel2 == null) ? 0 : cdNivel2.hashCode());
		result = prime * result + ((modNivel1 == null) ? 0 : modNivel1.hashCode());
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
		ModNivel2_PK other = (ModNivel2_PK) obj;
		if (cdNivel2 == null) {
			if (other.cdNivel2 != null)
				return false;
		} else if (!cdNivel2.equals(other.cdNivel2))
			return false;
		if (modNivel1 == null) {
			if (other.modNivel1 != null)
				return false;
		} else if (!modNivel1.equals(other.modNivel1))
			return false;
		return true;
	}

	
	
	

}
