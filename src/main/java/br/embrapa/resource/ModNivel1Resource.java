package br.embrapa.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.embrapa.event.RecursoCriadoEvent;
import br.embrapa.model.CadEmpresa;
import br.embrapa.model.ModLocal1;
import br.embrapa.model.ModNivel1;
import br.embrapa.model.ModNivel2;
import br.embrapa.model.pk.ModLocal1_PK;
import br.embrapa.model.pk.ModNivel1_PK;
import br.embrapa.repository.ModNivel1Repository;
import br.embrapa.repository.filter.ModNivel1Filter;
import br.embrapa.service.ModNivel1Service;
import br.embrapa.service.ModNivel2Service;



@RestController
@RequestMapping("/modnivel1")
public class ModNivel1Resource {
	
	@Autowired
	private ModNivel1Repository modNivel1Repository;
	
	@Autowired
	private ModNivel1Service modNivel1Service;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<ModNivel1> criar(@RequestBody ModNivel1 ModNivel1, HttpServletResponse response) {
		ModNivel1 ModNivel1Salva = modNivel1Repository.save(ModNivel1);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, ModNivel1Salva.getPkNivel1().getCdNivel1()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ModNivel1Salva);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_MODLOCAL1') and #oauth2.hasScope('read')")
	public Page<ModNivel1> Pesquisar(ModNivel1Filter modNivel1Filter, Pageable pageable) {
		return modNivel1Repository.filtrar(modNivel1Filter, pageable);
	}
	
	
	
	@GetMapping("/{cdNivel1}/{cdEmpresa}")
	public ModNivel1 buscarPeloCodigo(ModNivel1_PK pk) {
		return modNivel1Repository.findOne(pk);
		
	}
	
		
	@DeleteMapping("/{cdNivel1}/{cdEmpresa}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cdNivel1, @PathVariable CadEmpresa cdEmpresa) {
		ModNivel1_PK pk = new ModNivel1_PK(cdNivel1,cdEmpresa);
		modNivel1Repository.delete(pk);
	}
	
	@PutMapping("/{cdLocal1}/{cdEmpresa}")
	public ResponseEntity<ModNivel1> atualizar(@PathVariable ModNivel1_PK pk, @Valid @RequestBody ModNivel1 cadModNivel1) {
		ModNivel1 modNivel1Salva = modNivel1Service.atualizar(pk, cadModNivel1);
		return ResponseEntity.ok(modNivel1Salva);
	}
}