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

import grepolis.stats.Inmortales.model.Jugador;
import grepolis.stats.Inmortales.model.JugadorServiceModel;
import grepolis.stats.Inmortales.service.JugadorServiceImpl;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {
	@Autowired
	private JugadorServiceImpl jugadorService;

	@GetMapping
	public ResponseEntity<List<JugadorServiceModel>> getAllJugadores() {
		List<JugadorServiceModel> jugadores = jugadorService.getAllJugadores();
		return new ResponseEntity<>(jugadores, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Jugador> createJugador(@RequestBody Jugador jugador) {
		Jugador nuevoJugador = jugadorService.createJugador(jugador);
		return new ResponseEntity<>(nuevoJugador, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<JugadorServiceModel> getJugadorById(@PathVariable Long id) {
		JugadorServiceModel jugador = jugadorService.getJugadorById(id);
		if (jugador != null) {
			return new ResponseEntity<>(jugador, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@PutMapping
	public ResponseEntity<Jugador> updateJugador( @RequestBody Jugador jugadorDetails) {
		Jugador updatedJugador = jugadorService.updateJugador(jugadorDetails);
		if (updatedJugador != null) {
			return new ResponseEntity<>(updatedJugador, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteJugador(@PathVariable Long id) {
		jugadorService.deleteJugador(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
