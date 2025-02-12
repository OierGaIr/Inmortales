package grepolis.stats.Inmortales.service;

import java.util.List;

import grepolis.stats.Inmortales.model.Recuento;
import grepolis.stats.Inmortales.model.RecuentoServiceModel;

public interface RecuentoService {
	List<RecuentoServiceModel> getAllRecuentos();

	RecuentoServiceModel getRecuentoById(Long id);

	Recuento createRecuento(Recuento request);

	Recuento updateRecuento(Recuento request);

	void deleteRecuento(Long id);
}
