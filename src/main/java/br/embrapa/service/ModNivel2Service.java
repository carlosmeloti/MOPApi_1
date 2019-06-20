package br.embrapa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.embrapa.model.ModNivel1;
import br.embrapa.model.ModNivel2;
import br.embrapa.model.pk.ModNivel1_PK;
import br.embrapa.model.pk.ModNivel2_PK;
import br.embrapa.repository.ModNivel1Repository;
import br.embrapa.repository.ModNivel2Repository;

@Service
public class ModNivel2Service {

	@Autowired
	private ModNivel2Repository modNivel2Repository;
	
	/*public ModNivel1 findByKey(ModNivel1_PK pk) {
        
      return modNivel1Repository.buscarPorPK(pk.getCdNivel1(), pk.getCdEmpresa());
	}*/
	
	
	public ModNivel2 atualizar(ModNivel2_PK pk, ModNivel2 modNivel2) {
		
		ModNivel2 modNivel2Salva = buscarModNivel2PeloCodigo(pk);
		BeanUtils.copyProperties(modNivel2, modNivel2Salva, "codigo");
		return modNivel2Repository.save(modNivel2Salva);
	}
	
	

	public ModNivel2 buscarModNivel2PeloCodigo(ModNivel2_PK pk) {
		ModNivel2 modNivel2Salva = modNivel2Repository.findOne(pk);
		if (modNivel2Salva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return modNivel2Salva;
	}	
}
