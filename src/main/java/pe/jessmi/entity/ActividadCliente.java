package pe.jessmi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="actividad_cliente")
public class ActividadCliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_actividad_cliente;
	
	@Column(columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_actividad")
	private TipoActividad tipoActividad;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente clienteActividadCliente;
	
	public ActividadCliente() {
		// TODO Auto-generated constructor stub
	}

	public ActividadCliente(TipoActividad tipoActividad, Cliente clienteActividadCliente) {
		super();
		this.tipoActividad = tipoActividad;
		this.clienteActividadCliente = clienteActividadCliente;
	}

	public Integer getId_actividad_cliente() {
		return id_actividad_cliente;
	}

	public void setId_actividad_cliente(Integer id_actividad_cliente) {
		this.id_actividad_cliente = id_actividad_cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public Cliente getClienteActividadCliente() {
		return clienteActividadCliente;
	}

	public void setClienteActividadCliente(Cliente clienteActividadCliente) {
		this.clienteActividadCliente = clienteActividadCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
