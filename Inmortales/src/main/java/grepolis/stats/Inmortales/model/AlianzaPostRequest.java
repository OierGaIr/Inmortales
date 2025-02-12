package grepolis.stats.Inmortales.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AlianzaPostRequest {
	
	private String nombre;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private JugadorPostRequest lider;
	public AlianzaPostRequest(String nombre, JugadorPostRequest lider) {
		super();
		this.nombre = nombre;
		this.lider = lider;
	}
	public AlianzaPostRequest() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public JugadorPostRequest getLider() {
		return lider;
	}
	public void setLider(JugadorPostRequest lider) {
		this.lider = lider;
	}
	
}
