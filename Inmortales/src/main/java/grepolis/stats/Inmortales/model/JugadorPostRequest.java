package grepolis.stats.Inmortales.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class JugadorPostRequest {
	private String nombre;
	private int countCiudades;
	private String senado;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private AlianzaPostRequest alianza;

	public JugadorPostRequest() {
		super();
	}

	public JugadorPostRequest(String nombre, int countCiudades, String senado, AlianzaPostRequest alianza) {
		super();

		this.nombre = nombre;
		this.countCiudades = countCiudades;
		this.senado = senado;
		this.alianza = alianza;
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

	public AlianzaPostRequest getAlianza() {
		return alianza;
	}

	public void setAlianza(AlianzaPostRequest alianza) {
		this.alianza = alianza;
	}

}
