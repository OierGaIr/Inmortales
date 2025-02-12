package grepolis.stats.Inmortales.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int countCiudades;
	private String senado;
	@ManyToOne
	@JoinColumn(name = "idAlianza")
	private Alianza alianza;

	// Getters y Setters
	public Jugador() {
		super();
	}

	public Jugador(Long id, String nombre, int countCiudades, String senado, Alianza alianza) {
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

	public Alianza getAlianza() {
		return alianza;
	}

	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", countCiudades=" + countCiudades + ", senado=" + senado
				+ ", alianza=" + alianza + "]";
	}

}
