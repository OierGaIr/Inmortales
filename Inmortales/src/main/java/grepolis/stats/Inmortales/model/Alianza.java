package grepolis.stats.Inmortales.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

//Entidad Alianza
@Entity
public class Alianza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@OneToOne
	@JoinColumn(name = "idLider")
	@OnDelete(action = OnDeleteAction.SET_NULL)
	@Nullable
	private Jugador lider;

	// Getters y Setters

	public Alianza() {

	}

	public Alianza(Long id, String nombre, Jugador lider) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lider = lider;
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

	public Jugador getLider() {
		return lider;
	}

	public void setLider(Jugador lider) {
		this.lider = lider;
	}

	@Override
	public String toString() {
		return "Alianza [id=" + id + ", nombre=" + nombre + ", lider=" + lider + "]";
	}
	
}