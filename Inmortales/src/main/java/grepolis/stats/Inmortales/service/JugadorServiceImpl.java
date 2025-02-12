package grepolis.stats.Inmortales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grepolis.stats.Inmortales.model.AlianzaServiceModel;
import grepolis.stats.Inmortales.model.Jugador;
import grepolis.stats.Inmortales.model.JugadorServiceModel;
import grepolis.stats.Inmortales.repository.IntJugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService {
	@Autowired
	private IntJugadorRepository jugadorRepository;

	@Override
	public List<JugadorServiceModel> getAllJugadores() {
		Iterable<Jugador> jugadorIterable = jugadorRepository.findAll();
		List<JugadorServiceModel> response = new ArrayList<>();
		for (Jugador jugador : jugadorIterable) {
			AlianzaServiceModel alianzaServiceModel = new AlianzaServiceModel(jugador.getAlianza().getId(),
					jugador.getAlianza().getNombre());
			JugadorServiceModel jugadorServiceModel = new JugadorServiceModel(jugador.getId(), jugador.getNombre(),
					jugador.getCountCiudades(), jugador.getSenado(), alianzaServiceModel);

			response.add(jugadorServiceModel);
		}

		return response;
	}

	@Override
	public JugadorServiceModel getJugadorById(Long id) {
		Jugador jugador = jugadorRepository.findById(id).orElse(null);
		AlianzaServiceModel alianzaServiceModel = new AlianzaServiceModel(
				jugador.getAlianza().getId(),
				jugador.getAlianza().getNombre()
				);
		JugadorServiceModel jugadorServiceModel = new JugadorServiceModel(
				jugador.getId(), 
				jugador.getNombre(),
				jugador.getCountCiudades(), 
				jugador.getSenado(), 
				alianzaServiceModel
				);
		return jugadorServiceModel;
	}

	@Override
	public Jugador createJugador(Jugador request) {
		// TODO Auto-generated method stub
		return jugadorRepository.save(request);
	}

	@Override
	public Jugador updateJugador(Jugador request) {
		// TODO Auto-generated method stub
		return jugadorRepository.save(request);
	}

	@Override
	public void deleteJugador(Long id) {

		jugadorRepository.deleteById(id);
	}

//	public Jugador createJugador(Jugador jugador) {
//		return jugadorRepository.save(jugador);
//	}
//
//	public Jugador getJugadorById(Long id) {
//		return jugadorRepository.findById(id).orElse(null);
//	}
//
//	public List<Jugador> getAllJugadores() {
//		return (List<Jugador>) jugadorRepository.findAll();
//	}
//
//	public Jugador updateJugador(Long id, Jugador jugadorDetails) {
//		Jugador jugador = jugadorRepository.findById(id).orElse(null);
//		if (jugador != null) {
//			jugador.setNombre(jugadorDetails.getNombre());
//			jugador.setCountCiudades(jugadorDetails.getCountCiudades());
//			jugador.setSenado(jugadorDetails.getSenado());
//			jugador.setAlianza(jugadorDetails.getAlianza());
//			return jugadorRepository.save(jugador);
//		}
//		return null;
//	}
//
//	public void deleteJugador(Long id) {
//		jugadorRepository.deleteById(id);
//	}
}
