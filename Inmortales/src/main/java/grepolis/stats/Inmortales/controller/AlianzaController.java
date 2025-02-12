package grepolis.stats.Inmortales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grepolis.stats.Inmortales.model.Alianza;
import grepolis.stats.Inmortales.model.AlianzaServiceModel;
import grepolis.stats.Inmortales.service.AlianzaServiceImpl;

@RestController
@RequestMapping("/api/alianzas")
public class AlianzaController {
	@Autowired
	private AlianzaServiceImpl alianzaService;

	@GetMapping("/{id}")
	public ResponseEntity<AlianzaServiceModel> getAlianzaById(@PathVariable Long id) {
		AlianzaServiceModel alianza = alianzaService.getAlianzaById(id);
		if (alianza != null) {
			return new ResponseEntity<>(alianza, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<List<AlianzaServiceModel>> getAllAlianzas() {
		List<AlianzaServiceModel> alianzas = alianzaService.getAllAlianzas();
		return new ResponseEntity<>(alianzas, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Alianza> createAlianza(@RequestBody Alianza alianza) {
		Alianza nuevaAlianza = alianzaService.createAlianza(alianza);
		return new ResponseEntity<>(nuevaAlianza, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Alianza> updateAlianza(@RequestBody Alianza alianzaDetails) {
		Alianza updatedAlianza = alianzaService.updateAlianza(alianzaDetails);
		if (updatedAlianza != null) {
			return new ResponseEntity<>(updatedAlianza, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteAlianza(@PathVariable Long id) {
		alianzaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
