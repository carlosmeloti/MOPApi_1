package br.embrapa.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.embrapa.model.pk.ModNivel3_PK;

@Entity
@Table(name="d12_nivel3_m")
public class ModNivel3 {
	
	@EmbeddedId
	private ModNivel3_PK pkNivel3;
	
	@Column(name="d12_nmnivel3")
	private String nmNivel3;

	public ModNivel3_PK getPkNivel3() {
		return pkNivel3;
	}

	public void setPkNivel3(ModNivel3_PK pkNivel3) {
		this.pkNivel3 = pkNivel3;
	}

	public String getNmNivel3() {
		return nmNivel3;
	}

	public void setNmNivel3(String nmNivel3) {
		this.nmNivel3 = nmNivel3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nmNivel3 == null) ? 0 : nmNivel3.hashCode());
		result = prime * result + ((pkNivel3 == null) ? 0 : pkNivel3.hashCode());
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
		ModNivel3 other = (ModNivel3) obj;
		if (nmNivel3 == null) {
			if (other.nmNivel3 != null)
				return false;
		} else if (!nmNivel3.equals(other.nmNivel3))
			return false;
		if (pkNivel3 == null) {
			if (other.pkNivel3 != null)
				return false;
		} else if (!pkNivel3.equals(other.pkNivel3))
			return false;
		return true;
	}
	
	

	
}
