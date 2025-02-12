package grepolis.stats.Inmortales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grepolis.stats.Inmortales.model.Ciudad;
import grepolis.stats.Inmortales.model.CiudadServiceModel;
import grepolis.stats.Inmortales.model.JugadorServiceModel;
import grepolis.stats.Inmortales.repository.IntCiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService {
	@Autowired
	private IntCiudadRepository ciudadRepository;

	@Override
	public List<CiudadServiceModel> getAllCiudades() {
		Iterable<Ciudad> ciudadIterable = ciudadRepository.findAll();
		List<CiudadServiceModel> response = new ArrayList<>();
		for (Ciudad ciudad : ciudadIterable) {
			JugadorServiceModel jugador = new JugadorServiceModel(ciudad.getJugador().getId(),
					ciudad.getJugador().getNombre(), ciudad.getJugador().getCountCiudades(),
					ciudad.getJugador().getSenado());
			CiudadServiceModel ciudadServiceModel = new CiudadServiceModel(ciudad.getId(), ciudad.getNombre(),
					ciudad.getTipoCiudad(), ciudad.getPuntos(), jugador);
			response.add(ciudadServiceModel);
		}

		return response;
	}

	@Override
	public CiudadServiceModel getCiudadById(Long id) {
		Ciudad ciudad = ciudadRepository.findById(id).orElse(null);
		JugadorServiceModel jugador = new JugadorServiceModel(ciudad.getJugador().getId(),
				ciudad.getJugador().getNombre(), ciudad.getJugador().getCountCiudades(),
				ciudad.getJugador().getSenado());
		CiudadServiceModel ciudadServiceModel = new CiudadServiceModel(ciudad.getId(), ciudad.getNombre(),
				ciudad.getTipoCiudad(), ciudad.getPuntos(), jugador);

		return ciudadServiceModel;
	}

	@Override
	public Ciudad createCiudad(Ciudad request) {
		// TODO Auto-generated method stub
		return ciudadRepository.save(request);
	}

	@Override
	public Ciudad updateCiudad(Ciudad request) {
		// TODO Auto-generated method stub
		return ciudadRepository.save(request);
	}

	@Override
	public void deleteCiudad(Long id) {
		// TODO Auto-generated method stub
		ciudadRepository.deleteById(id);
	}

}
