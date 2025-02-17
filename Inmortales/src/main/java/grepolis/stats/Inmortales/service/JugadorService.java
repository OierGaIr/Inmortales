package grepolis.stats.Inmortales.service;

import java.util.List;

import grepolis.stats.Inmortales.model.Jugador;
import grepolis.stats.Inmortales.model.JugadorServiceModel;

public interface JugadorService {
	List<JugadorServiceModel> getAllJugadores();

	JugadorServiceModel getJugadorById(Long id);

	Jugador getById(Long id);
	Jugador createJugador(Jugador request);

	Jugador updateJugador(Jugador request);

	void deleteJugador(Long id);
}
