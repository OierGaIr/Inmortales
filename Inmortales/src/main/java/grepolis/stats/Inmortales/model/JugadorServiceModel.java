package grepolis.stats.Inmortales.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class JugadorServiceModel {
	private Long id;
	private String nombre;
	private int countCiudades;
	private String senado;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private AlianzaServiceModel alianza;

	public JugadorServiceModel() {
		super();
	}

	public JugadorServiceModel(Long id, String nombre, int countCiudades, String senado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.countCiudades = countCiudades;
		this.senado = senado;
	}

	public JugadorServiceModel(Long id, String nombre, int countCiudades, String senado, AlianzaServiceModel alianza) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.countCiudades = countCiudades;
		this.senado = senado;
		this.alianza = alianza;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCountCiudades() {
		return countCiudades;
	}

	public void setCountCiudades(int countCiudades) {
		this.countCiudades = countCiudades;
	}

	public String getSenado() {
		return senado;
	}

	public void setSenado(String senado) {
		this.senado = senado;
	}

	public AlianzaServiceModel getAlianza() {
		return alianza;
	}

	public void setAlianza(AlianzaServiceModel alianza) {
		this.alianza = alianza;
	}

}
