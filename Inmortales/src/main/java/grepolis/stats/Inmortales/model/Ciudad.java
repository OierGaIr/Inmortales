package grepolis.stats.Inmortales.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Entidad Ciudad
@Entity
public class Ciudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String tipoCiudad;
	private int puntos;
	@ManyToOne
	@JoinColumn(name = "idJugador")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Jugador jugador;

	// Getters y Setters
	public Ciudad() {
		super();
	}

	public Ciudad(Long id, String nombre, String tipoCiudad, int puntos, Jugador jugador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoCiudad = tipoCiudad;
		this.puntos = puntos;
		this.jugador = jugador;
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

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre=" + nombre + ", tipoCiudad=" + tipoCiudad + ", puntos=" + puntos
				+ ", jugador=" + jugador + "]";
	}

}