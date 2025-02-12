package grepolis.stats.Inmortales.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Entidad Recuento
@Entity
public class Recuento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipoCiudad;
	private int cantidad;

	// Getters y Setters
	public Recuento() {
		super();
	}

	public Recuento(Long id, String tipoCiudad, int cantidad) {
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

	@Override
	public String toString() {
		return "Recuento [id=" + id + ", tipoCiudad=" + tipoCiudad + ", cantidad=" + cantidad + "]";
	}

}