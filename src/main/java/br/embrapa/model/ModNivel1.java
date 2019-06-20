package br.embrapa.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.embrapa.model.pk.ModNivel1_PK;

@Entity
@Table(name="d10_nivel1_m")
public class ModNivel1 {
	
		
	@EmbeddedId
	private ModNivel1_PK pkNivel1;
	
	@Column(name="d10_nmnivel1")
	private String nmNivel1;

	public ModNivel1_PK getPkNivel1() {
		return pkNivel1;
	}

	public void setPkNivel1(ModNivel1_PK pkNivel1) {
		this.pkNivel1 = pkNivel1;
	}

	public String getNmNivel1() {
		return nmNivel1;
	}

	public void setNmNivel1(String nmNivel1) {
		this.nmNivel1 = nmNivel1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nmNivel1 == null) ? 0 : nmNivel1.hashCode());
		result = prime * result + ((pkNivel1 == null) ? 0 : pkNivel1.hashCode());
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
		ModNivel1 other = (ModNivel1) obj;
		if (nmNivel1 == null) {
			if (other.nmNivel1 != null)
				return false;
		} else if (!nmNivel1.equals(other.nmNivel1))
			return false;
		if (pkNivel1 == null) {
			if (other.pkNivel1 != null)
				return false;
		} else if (!pkNivel1.equals(other.pkNivel1))
			return false;
		return true;
	}
	
	
	
	

	
}
