package grepolis.stats.Inmortales.model;

public class RecuentoServiceModel {
	private Long id;
	private String tipoCiudad;
	private int cantidad;

	public RecuentoServiceModel() {
		super();
	}

	public RecuentoServiceModel(Long id, String tipoCiudad, int cantidad) {
		super();
		this.id = id;
		this.tipoCiudad = tipoCiudad;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
