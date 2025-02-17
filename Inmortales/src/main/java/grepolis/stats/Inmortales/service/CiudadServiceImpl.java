package grepolis.stats.Inmortales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grepolis.stats.Inmortales.model.Ciudad;
import grepolis.stats.Inmortales.model.CiudadServiceModel;
import grepolis.stats.Inmortales.model.Jugador;
import grepolis.stats.Inmortales.model.JugadorServiceModel;
import grepolis.stats.Inmortales.model.Recuento;
import grepolis.stats.Inmortales.repository.IntCiudadRepository;
import grepolis.stats.Inmortales.repository.IntJugadorRepository;
import grepolis.stats.Inmortales.repository.IntRecuentoRepository;

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

	@Autowired
	private IntJugadorRepository jugadorRepository;
	@Autowired
	private JugadorServiceImpl service;
	@Autowired
	private IntRecuentoRepository recuentoReposotory;

	// ESTA FUNCION SUMA + 1 AL CONTADOR DE CIUDADES Y AL RECUENTO
	@Override
	public Ciudad createCiudad(Ciudad request) {
		System.out.println(request.toString());
		Jugador jugador = service.getById(request.getJugador().getId());
		System.out.println(jugador.toString());
		jugador.setCountCiudades(jugador.getCountCiudades() + 1);
		jugadorRepository.save(jugador);
		Ciudad saveCiudad = ciudadRepository.save(request);
		Recuento recuento = recuentoReposotory.findByTipoCiudad(saveCiudad.getTipoCiudad());
		System.out.println(recuento.toString());
		recuento.setCantidad(recuento.getCantidad() + 1);
		recuentoReposotory.save(recuento);

		return saveCiudad;
	}

	@Override
	public Ciudad updateCiudad(Ciudad request) {
		// TODO Auto-generated method stub
		return ciudadRepository.save(request);
	}

	@Override
	public void deleteCiudad(Long id) {
		// TODO Auto-generated method stub
		Ciudad ciudad = ciudadRepository.getById(id);
		Jugador jugador = service.getById(ciudad.getJugador().getId());
		System.out.println(jugador.toString());
		jugador.setCountCiudades(jugador.getCountCiudades() - 1);
		jugadorRepository.save(jugador);
		Recuento recuento = recuentoReposotory.findByTipoCiudad(ciudad.getTipoCiudad());
		System.out.println(recuento.toString());
		recuento.setCantidad(recuento.getCantidad() - 1);
		ciudadRepository.deleteById(id);
	}

}
