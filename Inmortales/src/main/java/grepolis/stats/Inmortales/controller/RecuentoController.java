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

import grepolis.stats.Inmortales.model.Recuento;
import grepolis.stats.Inmortales.model.RecuentoServiceModel;
import grepolis.stats.Inmortales.service.RecuentoServiceImpl;

@RestController
@RequestMapping("/api/recuentos")
public class RecuentoController {
	@Autowired
	private RecuentoServiceImpl recuentoService;

	@GetMapping
	public ResponseEntity<List<RecuentoServiceModel>> getAllRecuentos() {
		List<RecuentoServiceModel> recuentos = recuentoService.getAllRecuentos();
		return new ResponseEntity<>(recuentos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RecuentoServiceModel> getRecuentoById(@PathVariable Long id) {
		RecuentoServiceModel recuento = recuentoService.getRecuentoById(id);
		if (recuento != null) {
			return new ResponseEntity<>(recuento, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Recuento> createRecuento(@RequestBody Recuento recuento) {
		Recuento nuevoRecuento = recuentoService.createRecuento(recuento);
		return new ResponseEntity<>(nuevoRecuento, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Recuento> updateRecuento(@RequestBody Recuento recuentoDetails) {
		Recuento updatedRecuento = recuentoService.updateRecuento(recuentoDetails);
		if (updatedRecuento != null) {
			return new ResponseEntity<>(updatedRecuento, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteRecuento(@PathVariable Long id) {
		recuentoService.deleteRecuento(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
