package grepolis.stats.Inmortales.model;

public class RecuentoPostRequest {

	private String tipoCiudad;
	private int cantidad;

	public RecuentoPostRequest() {
		super();
	}

	public RecuentoPostRequest(String tipoCiudad, int cantidad) {
		super();
		this.tipoCiudad = tipoCiudad;
		this.cantidad = cantidad;
	}

	public String getTipoCiudad() {
		return tipoCiudad;
	}

	public void setTipoCiudad(String tipoCiudad) {
		this.tipoCiudad = tipoCiudad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
