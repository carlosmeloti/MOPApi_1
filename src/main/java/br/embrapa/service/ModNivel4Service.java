package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.ModNivel4;
import br.embrapa.model.ModNivel4;
import br.embrapa.model.pk.ModNivel4_PK;
import br.embrapa.repository.ModNivel4Repository;
import br.embrapa.repository.ModNivel4Repository;

@Service
public class ModNivel4Service {

	@Autowired
	private ModNivel4Repository modNivel4Repository;
	
	/*public ModNivel1 findByKey(ModNivel1_PK pk) {
        
      return modNivel1Repository.buscarPorPK(pk.getCdNivel1(), pk.getCdEmpresa());
	}*/
	
	
	public ModNivel4 atualizar(ModNivel4_PK pk, ModNivel4 modNivel4) {
		
		ModNivel4 modNivel4Salva = buscarModNivel4PeloCodigo(pk);
		BeanUtils.copyProperties(modNivel4, modNivel4Salva, "codigo");
		return modNivel4Repository.save(modNivel4Salva);
	}
	
	

	public ModNivel4 buscarModNivel4PeloCodigo(ModNivel4_PK pk) {
		ModNivel4 modNivel4Salva = modNivel4Repository.findOne(pk);
		if (modNivel4Salva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return modNivel4Salva;
	}	
	
}
