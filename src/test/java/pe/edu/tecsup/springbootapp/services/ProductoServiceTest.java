package pe.edu.tecsup.springbootapp.services;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.springbootapp.entities.Producto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
@Log
@SpringBootTest
public class ProductoServiceTest {

	@Autowired
	private ProductoService productoService;

	/**
	 *  Test busqueda de tddos los productos
	 * @throws Exception
	 */
	@Test
	public void testFindAll() throws Exception {

		boolean VALUE_EXPECTED = false;

		List<Producto> productos = productoService.findAll();

		productos.stream().forEach(item -> log.info(item.toString()));

		assertEquals(VALUE_EXPECTED, productos.isEmpty());
	
	}

	/**
	 *  Test busqueda de productos por nombre
	 * @throws Exception
	 */
	@Test
	public void testFindByName() throws Exception {

		boolean VALUE_EXPECTED = false;

		List<Producto> productos = productoService.findByName("AMD");

		log.info("Productos encontrados :");
		productos.stream().forEach(item -> log.info(item.toString()));

		assertEquals(VALUE_EXPECTED, productos.isEmpty());

	}




}
