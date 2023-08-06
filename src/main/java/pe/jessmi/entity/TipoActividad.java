package pe.jessmi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tipo_actividad")
public class TipoActividad implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_tipo_actividad;
	
	@Column(unique=true)
	private String nombre;

	@OneToMany(mappedBy="tipoActividad")
	@JsonBackReference
	private Collection<ActividadCliente> actividadesCliente = new ArrayList<>();
	
	public TipoActividad() {
		// TODO Auto-generated constructor stub
	}

	public TipoActividad(String nombre) {
		super();
		this.nombre = nombre;
	}

	public TipoActividad(Integer id_tipo_actividad, String nombre) {
		super();
		this.id_tipo_actividad = id_tipo_actividad;
		this.nombre = nombre;
	}

	public Integer getId_tipo_actividad() {
		return id_tipo_actividad;
	}

	public void setId_tipo_actividad(Integer id_tipo_actividad) {
		this.id_tipo_actividad = id_tipo_actividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<ActividadCliente> getActividadesCliente() {
		return actividadesCliente;
	}

	public void setActividadesCliente(Collection<ActividadCliente> actividadesCliente) {
		this.actividadesCliente = actividadesCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
