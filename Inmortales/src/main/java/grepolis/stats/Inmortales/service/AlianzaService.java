package grepolis.stats.Inmortales.service;

import java.util.List;

import grepolis.stats.Inmortales.model.Alianza;
import grepolis.stats.Inmortales.model.AlianzaServiceModel;

public interface AlianzaService {
	List<AlianzaServiceModel> getAllAlianzas();

	AlianzaServiceModel getAlianzaById(Long id);

	Alianza createAlianza(Alianza request);

	Alianza updateAlianza(Alianza request);

	void delete(Long id);
}
