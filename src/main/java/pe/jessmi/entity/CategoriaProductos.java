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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="categoria_productos")
public class CategoriaProductos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_categoria_productos;
	
	@Column(unique=true)
	private String titulo;
	
	@OneToMany(mappedBy="categoriaProductos", cascade=CascadeType.ALL)
	@JsonBackReference
	private Collection<Producto> productos = new ArrayList<>();
	
	public CategoriaProductos() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaProductos(String titulo) {
		this.titulo = titulo;
	}

	public Integer getId_categoria_productos() {
		return id_categoria_productos;
	}

	public void setId_categoria_productos(Integer id_categoria_productos) {
		this.id_categoria_productos = id_categoria_productos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
