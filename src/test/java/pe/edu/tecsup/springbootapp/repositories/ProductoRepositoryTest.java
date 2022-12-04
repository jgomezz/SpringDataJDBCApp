package pe.edu.tecsup.springbootapp.repositories;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.tecsup.springbootapp.entities.Producto;

@SpringBootTest
class ProductoRepositoryTest {

	private static Logger log = LoggerFactory.getLogger(ProductoRepositoryTest.class);

	@Autowired
	ProductoRepository productoRepository;

	@Test
	void testListar() {

		List<Producto> prods = null;

		try {

			prods = productoRepository.listar();

			// foreach
			for (Producto item : prods) {
				log.info(item.toString());
			}

			// stream
			prods.stream().forEach(item -> log.info(item.toString()));

		} catch (Exception e) {

			fail("Exception " + e.getMessage());

		}

		// Test validation..!
		assertThat(prods.isEmpty(), is(false));

	}

	@Test
	void testRegistrar() {

		Producto nuevoProducto = new Producto();
		nuevoProducto.setCategorias_id(1L);
		nuevoProducto.setNombre("AMD");
		nuevoProducto.setDescripcion("AMD X10");
		nuevoProducto.setPrecio(280.0);
		nuevoProducto.setStock(6);

		try {

			List<Producto> productos = productoRepository.listar();
			int totalAntes = productos.size();

			productoRepository.registrar(nuevoProducto);

			productos = productoRepository.listar();
			int totalDespues = productos.size();

			assertThat(totalDespues - totalAntes, is(1));

		} catch (Exception e) {

			fail("Exception " + e.getMessage());

		}

	}

	@Test
	void testEliminar() {
		
		try {
		
			List<Producto> productos = productoRepository.listar(); 
			
			int totalAntes = productos.size();
			
			if (productos.isEmpty()) {
				return; // test pass 
			}
			
			Producto ultimoProducto = productos.get(productos.size() - 1);
			
			productoRepository.eliminar(ultimoProducto.getId()); 
			
			// Lee nuevamente
			productos = productoRepository.listar();
			
			int totalDespues = productos.size();
			
			// Validacion
			assertThat(totalAntes - totalDespues, is(1));
		
		} catch (Exception e) {

			fail("Exception " + e.getMessage());

		}		
	}

}
