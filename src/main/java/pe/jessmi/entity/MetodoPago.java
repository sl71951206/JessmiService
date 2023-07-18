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
@Table(name="metodo_pago")
public class MetodoPago implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_metodo_pago;
	
	@Column(unique=true)
	private String nombre;
	
	@OneToMany(mappedBy="metodoPago")
	@JsonBackReference
	private Collection<Compra> compras = new ArrayList<>();
	
	public MetodoPago() {
		// TODO Auto-generated constructor stub
	}

	public MetodoPago(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_metodo_pago() {
		return id_metodo_pago;
	}

	public void setId_metodo_pago(Integer id_metodo_pago) {
		this.id_metodo_pago = id_metodo_pago;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Collection<Compra> compras) {
		this.compras = compras;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
