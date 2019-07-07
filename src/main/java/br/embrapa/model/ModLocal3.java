package br.embrapa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="d05_local3_m")
public class ModLocal3 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="d05_cdlocal3")
	private Long cdLocal3;
		
	
	@ManyToOne
	@JoinColumn(name="d05_cdlocal2", referencedColumnName="d04_cdlocal2")
	private ModLocal2 modLocal2;

	
		
	@Column(name="d05_nmlocal3")
	private String nmLocal3;



	public Long getCdLocal3() {
		return cdLocal3;
	}



	public void setCdLocal3(Long cdLocal3) {
		this.cdLocal3 = cdLocal3;
	}



	public ModLocal2 getModLocal2() {
		return modLocal2;
	}



	public void setModLocal2(ModLocal2 modLocal2) {
		this.modLocal2 = modLocal2;
	}



	public String getNmLocal3() {
		return nmLocal3;
	}



	public void setNmLocal3(String nmLocal3) {
		this.nmLocal3 = nmLocal3;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdLocal3 == null) ? 0 : cdLocal3.hashCode());
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
		ModLocal3 other = (ModLocal3) obj;
		if (cdLocal3 == null) {
			if (other.cdLocal3 != null)
				return false;
		} else if (!cdLocal3.equals(other.cdLocal3))
			return false;
		return true;
	}


	
}
