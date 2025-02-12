package grepolis.stats.Inmortales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grepolis.stats.Inmortales.model.Recuento;
import grepolis.stats.Inmortales.model.RecuentoServiceModel;
import grepolis.stats.Inmortales.repository.IntRecuentoRepository;

@Service
public class RecuentoServiceImpl implements RecuentoService {
	@Autowired
	private IntRecuentoRepository recuentoRepository;

	@Override
	public List<RecuentoServiceModel> getAllRecuentos() {
		Iterable<Recuento> recuentoIterable = recuentoRepository.findAll();
		List<RecuentoServiceModel> response = new ArrayList<>();
		for (Recuento recuento : recuentoIterable) {
			RecuentoServiceModel recuentoServiceModel = new RecuentoServiceModel(recuento.getId(),
					recuento.getTipoCiudad(), recuento.getCantidad());
			response.add(recuentoServiceModel);
		}

		return response;
	}

	@Override
	public RecuentoServiceModel getRecuentoById(Long id) {
		Recuento recuento = recuentoRepository.findById(id).orElse(null);
		RecuentoServiceModel recuentoServiceModel = new RecuentoServiceModel(recuento.getId(), recuento.getTipoCiudad(),
				recuento.getCantidad());
		return recuentoServiceModel;
	}

	@Override
	public Recuento createRecuento(Recuento request) {
		// TODO Auto-generated method stub
		return recuentoRepository.save(request);
	}

	@Override
	public Recuento updateRecuento(Recuento request) {
		// TODO Auto-generated method stub
		return recuentoRepository.save(request);
	}

	@Override
	public void deleteRecuento(Long id) {
		// TODO Auto-generated method stub
		recuentoRepository.deleteById(id);
	}

//	public Recuento createRecuento(Recuento recuento) {
//		return recuentoRepository.save(recuento);
//	}
//
//	public Recuento getRecuentoById(Long id) {
//		return recuentoRepository.findById(id).orElse(null);
//	}
//
//	public List<Recuento> getAllRecuentos() {
//		return (List<Recuento>) recuentoRepository.findAll();
//	}
//
//	public Recuento updateRecuento(Long id, Recuento recuentoDetails) {
//		Recuento recuento = recuentoRepository.findById(id).orElse(null);
//		if (recuento != null) {
//			recuento.setTipoCiudad(recuentoDetails.getTipoCiudad());
//			recuento.setCantidad(recuentoDetails.getCantidad());
//			return recuentoRepository.save(recuento);
//		}
//		return null;
//	}
//
//	public void deleteRecuento(Long id) {
//		recuentoRepository.deleteById(id);
//	}
}
