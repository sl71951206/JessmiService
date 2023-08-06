package pe.jessmi.mapper;

import java.sql.Timestamp;

public class CompraMapper {
	
	private Integer cod_compra;
	private Timestamp fecha_compra;
    private Integer id_cliente;
    private Double total;
    
    public CompraMapper() {
		// TODO Auto-generated constructor stub
	}

	public CompraMapper(Integer cod_compra, Timestamp fecha_compra, Integer id_cliente, Double total) {
		super();
		this.cod_compra = cod_compra;
		this.fecha_compra = fecha_compra;
		this.id_cliente = id_cliente;
		this.total = total;
	}

	public Integer getCod_compra() {
		return cod_compra;
	}

	public void setCod_compra(Integer cod_compra) {
		this.cod_compra = cod_compra;
	}

	public Timestamp getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Timestamp fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
