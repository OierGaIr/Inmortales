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

import grepolis.stats.Inmortales.model.Ciudad;
import grepolis.stats.Inmortales.model.CiudadServiceModel;
import grepolis.stats.Inmortales.service.CiudadServiceImpl;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {
	@Autowired
	private CiudadServiceImpl ciudadService;

	@GetMapping("/{id}")
	public ResponseEntity<CiudadServiceModel> getCiudadById(@PathVariable Long id) {
		CiudadServiceModel ciudad = ciudadService.getCiudadById(id);
		if (ciudad != null) {
			return new ResponseEntity<>(ciudad, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<List<CiudadServiceModel>> getAllCiudades() {
		List<CiudadServiceModel> ciudades = ciudadService.getAllCiudades();
		return new ResponseEntity<>(ciudades, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Ciudad> createCiudad(@RequestBody Ciudad ciudad) {
		Ciudad nuevaCiudad = ciudadService.createCiudad(ciudad);
		return new ResponseEntity<>(nuevaCiudad, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Ciudad> updateCiudad(@RequestBody Ciudad ciudadDetails) {
		Ciudad updatedCiudad = ciudadService.updateCiudad(ciudadDetails);
		if (updatedCiudad != null) {
			return new ResponseEntity<>(updatedCiudad, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCiudad(@PathVariable Long id) {
		ciudadService.deleteCiudad(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
