package pe.jessmi.mapper;

public class ProductoMapper {

	private Integer id_producto;
	private String nombre;
	private String marca;
	private Double precio;
	private String foto;
	private Integer stock;
	private Integer cantidad;
	
	public ProductoMapper() {
		// TODO Auto-generated constructor stub
	}

	public ProductoMapper(Integer id_producto, String nombre, String marca, Double precio, String foto, Integer stock,
			Integer cantidad) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.foto = foto;
		this.stock = stock;
		this.cantidad = cantidad;
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
