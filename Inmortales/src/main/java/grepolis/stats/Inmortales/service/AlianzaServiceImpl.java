package grepolis.stats.Inmortales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grepolis.stats.Inmortales.model.Alianza;
import grepolis.stats.Inmortales.model.AlianzaServiceModel;
import grepolis.stats.Inmortales.model.JugadorServiceModel;
import grepolis.stats.Inmortales.repository.IntAlianzaRepository;

@Service
public class AlianzaServiceImpl implements AlianzaService {
	@Autowired
	private IntAlianzaRepository alianzaRepository;
	
	@Override
	public List<AlianzaServiceModel> getAllAlianzas() {
		Iterable<Alianza> alianzaIterable = alianzaRepository.findAll();
		List<AlianzaServiceModel> response = new ArrayList<>();
		for (Alianza alianza : alianzaIterable) {
			JugadorServiceModel jugador = new JugadorServiceModel(alianza.getLider().getId(),
					alianza.getLider().getNombre(), alianza.getLider().getCountCiudades(),
					alianza.getLider().getSenado());
			AlianzaServiceModel alianzaServiceModel = new AlianzaServiceModel(alianza.getId(), alianza.getNombre(),
					jugador);
			response.add(alianzaServiceModel);
		}

		return response;
	}

	@Override
	public AlianzaServiceModel getAlianzaById(Long id) {
		Alianza alianzaIterable = alianzaRepository.findById(id).orElse(null);
		JugadorServiceModel jugador = new JugadorServiceModel(alianzaIterable.getLider().getId(),
				alianzaIterable.getLider().getNombre(), alianzaIterable.getLider().getCountCiudades(),
				alianzaIterable.getLider().getSenado());
		AlianzaServiceModel response = new AlianzaServiceModel(alianzaIterable.getId(), alianzaIterable.getNombre(),
				jugador);
		return response;
	}

	@Override
	public Alianza createAlianza(Alianza request) {
		return alianzaRepository.save(request);
	}

	@Override
	public Alianza updateAlianza(Alianza request) {
		// TODO Auto-generated method stub
		return alianzaRepository.save(request);
	}

	@Override
	public void delete(Long id) {
		alianzaRepository.deleteById(id);
	}
}
