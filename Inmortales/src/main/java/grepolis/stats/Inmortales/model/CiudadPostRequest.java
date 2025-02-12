package grepolis.stats.Inmortales.model;

public class CiudadPostRequest {
	private String nombre;
	private String tipoCiudad;
	private int puntos;
	private JugadorPostRequest jugador;

	public CiudadPostRequest(String nombre, String tipoCiudad, int puntos, JugadorPostRequest jugador) {
		super();
		this.nombre = nombre;
		this.tipoCiudad = tipoCiudad;
		this.puntos = puntos;
		this.jugador = jugador;
	}

	public CiudadPostRequest() {
		super();
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

	public JugadorPostRequest getJugador() {
		return jugador;
	}

	public void setJugador(JugadorPostRequest jugador) {
		this.jugador = jugador;
	}

}
