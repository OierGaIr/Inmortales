package grepolis.stats.Inmortales.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AlianzaServiceModel {
	private Long id;
	private String nombre;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private JugadorServiceModel lider;

	public AlianzaServiceModel(Long id, String nombre, JugadorServiceModel lider) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lider = lider;
	}

	public AlianzaServiceModel(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		
	}

	public AlianzaServiceModel() {
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

	public JugadorServiceModel getLider() {
		return lider;
	}

	public void setLider(JugadorServiceModel lider) {
		this.lider = lider;
	}

}
