package pe.jessmi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="producto")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_producto;
	
	@Column
	private String nombre;
	
	@Column
	private String marca;
	
	@Column
	private Double precio;
	
	@Column
	private String foto;
	
	@Column
	private Integer stock;
	
	@OneToMany(mappedBy="producto")
	@JsonBackReference
	private Collection<DetalleCompra> detallesCompra = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="id_categoria_productos")
	private CategoriaProductos categoriaProductos;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, String marca, Double precio, String foto, Integer stock,
			CategoriaProductos categoriaProductos) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.foto = foto;
		this.stock = stock;
		this.categoriaProductos = categoriaProductos;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Collection<DetalleCompra> getDetallesCompra() {
		return detallesCompra;
	}

	public void setDetallesCompra(Collection<DetalleCompra> detallesCompra) {
		this.detallesCompra = detallesCompra;
	}

	public CategoriaProductos getCategoriaProductos() {
		return categoriaProductos;
	}

	public void setCategoriaProductos(CategoriaProductos categoriaProductos) {
		this.categoriaProductos = categoriaProductos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
