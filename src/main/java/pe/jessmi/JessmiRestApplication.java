package pe.jessmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.jessmi.service.CategoriaProductosService;
import pe.jessmi.service.MetodoPagoService;
import pe.jessmi.service.TipoActividadService;

@SpringBootApplication
public class JessmiRestApplication implements CommandLineRunner {
	
	@Autowired
	TipoActividadService tipoActividadService;
	@Autowired
	MetodoPagoService metodoPagoService;
	@Autowired
	CategoriaProductosService categoriaProductosService;

	public static void main(String[] args) {
		SpringApplication.run(JessmiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tipoActividadService.load();
		metodoPagoService.load();
		categoriaProductosService.load();
	}

}
