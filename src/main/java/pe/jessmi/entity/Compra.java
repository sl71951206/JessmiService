package pe.jessmi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name="compra")
public class Compra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_compra;
	
	@Column(columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime fecha_compra;

	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente clienteCompra;
	
	@ManyToOne
	@JoinColumn(name="id_metodo_pago")
	private MetodoPago metodoPago;
	
	@OneToMany(mappedBy="compra")
	@JsonBackReference
	private Collection<DetalleCompra> detallesCompra = new ArrayList<>();
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Compra(Cliente cliente, MetodoPago metodoPago) {
		this.clienteCompra = cliente;
		this.metodoPago = metodoPago;
	}

	public Integer getCod_compra() {
		return cod_compra;
	}

	public void setCod_compra(Integer cod_compra) {
		this.cod_compra = cod_compra;
	}

	public LocalDateTime getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(LocalDateTime fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public Cliente getCliente() {
		return clienteCompra;
	}

	public void setCliente(Cliente cliente) {
		this.clienteCompra = cliente;
	}

	public Collection<DetalleCompra> getDetallesCompra() {
		return detallesCompra;
	}

	public void setDetallesCompra(Collection<DetalleCompra> detallesCompra) {
		this.detallesCompra = detallesCompra;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
