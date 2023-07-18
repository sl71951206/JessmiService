package pe.jessmi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cliente;
	
	@Column
	private String nombres;
	
	@Column
	private String apellidos;
	
	@Column(unique=true)
	private String correo;
	
	@Column
	private String contrasena;
	
	@OneToMany(mappedBy="clienteActividadCliente", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<ActividadCliente> actividadesCliente = new ArrayList<>();
	
	@OneToMany(mappedBy="clienteCompra")
	@JsonIgnore
	private Collection<Compra> compras = new ArrayList<>();

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombres, String apellidos, String correo, String contrasena) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Collection<ActividadCliente> getActividadesCliente() {
		return actividadesCliente;
	}

	public void setActividadesCliente(Collection<ActividadCliente> actividadesCliente) {
		this.actividadesCliente = actividadesCliente;
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
