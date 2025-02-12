package grepolis.stats.Inmortales.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CiudadServiceModel {
	private Long id;
	private String nombre;
	private String tipoCiudad;
	private int puntos;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private JugadorServiceModel jugador;

	public CiudadServiceModel(Long id, String nombre, String tipoCiudad, int puntos, JugadorServiceModel jugador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoCiudad = tipoCiudad;
		this.puntos = puntos;
		this.jugador = jugador;
	}

	public CiudadServiceModel() {
		super();
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

	public String getTipoCiudad() {
		return tipoCiudad;
	}

	public void setTipoCiudad(String tipoCiudad) {
		this.tipoCiudad = tipoCiudad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public JugadorServiceModel getJugador() {
		return jugador;
	}

	public void setJugador(JugadorServiceModel jugador) {
		this.jugador = jugador;
	}

}
