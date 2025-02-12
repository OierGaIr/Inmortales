package grepolis.stats.Inmortales.service;

import java.util.List;

import grepolis.stats.Inmortales.model.Ciudad;
import grepolis.stats.Inmortales.model.CiudadServiceModel;

public interface CiudadService {
	
	List<CiudadServiceModel> getAllCiudades();

	CiudadServiceModel getCiudadById(Long id);

	Ciudad createCiudad(Ciudad request);

	Ciudad updateCiudad(Ciudad request);

	void deleteCiudad(Long id);
}
