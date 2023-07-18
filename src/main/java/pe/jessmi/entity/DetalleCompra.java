package pe.jessmi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_compra")
public class DetalleCompra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_detalle_compra;

	@Column
	private Integer num_detalle;
	
	@Column
	private Integer cantidad;
	
	@ManyToOne
	@JoinColumn(name="cod_compra")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	public DetalleCompra() {
		// TODO Auto-generated constructor stub
	}

	public DetalleCompra(Integer num_detalle, Integer cantidad, Compra compra, Producto producto) {
		this.num_detalle = num_detalle;
		this.cantidad = cantidad;
		this.compra = compra;
		this.producto = producto;
	}

	public Integer getId_detalle_compra() {
		return id_detalle_compra;
	}

	public void setId_detalle_compra(Integer id_detalle_compra) {
		this.id_detalle_compra = id_detalle_compra;
	}

	public Integer getNum_detalle() {
		return num_detalle;
	}

	public void setNum_detalle(Integer num_detalle) {
		this.num_detalle = num_detalle;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
