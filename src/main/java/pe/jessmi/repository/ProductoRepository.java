package pe.jessmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.jessmi.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
