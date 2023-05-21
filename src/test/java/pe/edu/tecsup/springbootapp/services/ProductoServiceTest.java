package pe.edu.tecsup.springbootapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.tecsup.springbootapp.entities.Producto;

@SpringBootTest
public class ProductoServiceTest {

	private static Logger log 
	= LoggerFactory.getLogger(ProductoServiceTest.class);
	
	@Autowired
	private ProductoService productoService;

	@Test
	public void testListar() throws Exception {
		
		List<Producto> productos = productoService.listar();
	
		assertEquals(false, productos.isEmpty());
	
	}
	
	@Test
	public void testBuscarPorNombre() throws Exception {
		
		List<Producto> productos = productoService.buscarPorNombre("AMD");
		
		log.info("Print by productos");
		for(Producto producto : productos) log.info(producto.toString());
		
		assertEquals(false, productos.isEmpty());
		
	}

	@Test
	public void testRegistar() throws Exception {
		
		List<Producto> productos = productoService.listar();
		int totalAntes = productos.size();
		
		Producto producto = new Producto();
		producto.setCategorias_id(1L);
		producto.setNombre("AMD");
		producto.setDescripcion("AMD X10");
		producto.setPrecio(280.0);
		producto.setStock(6);
		producto.setEstado(1);

		productoService.registrar(producto);	
		
		productos = productoService.listar();
		int totalDespues = productos.size();
		
		assertEquals(1, totalDespues - totalAntes);
	}

	@Test
	public void testEliminar() throws Exception {
		
		List<Producto> productos = productoService.listar();
		int totalAntes = productos.size();
		if (productos.isEmpty()) {
			return; // test pass
		}

		Producto ultimoProducto = productos.get(productos.size() - 1);
		productoService.eliminar(ultimoProducto.getId());
		
		productos = productoService.listar();
		int totalDespues = productos.size();
		
		assertEquals(1, totalAntes - totalDespues);
	}
	
	
	@Test
	public void testActualizar() throws Exception {
		
		// Actualizar el nombre del producto
		Long id = 1L; // Relacionado con tus datos de pruebas
		String NOMBRE_ORIGINAL = "Kingstone" ;
		String NOMBRE_A_CAMBIAR = "Kingstone Cambiado" ;
		Producto prod = null;
		
		// Actualizar
		productoService.actualizar(id, NOMBRE_A_CAMBIAR);

		// Buscar el producto
		prod = productoService.buscarPorId(id);
		
		// Verificar que el nombre ha sido cambiado 
		assertEquals(NOMBRE_A_CAMBIAR, prod.getNombre());
		
		// Actualizar
		productoService.actualizar(id, NOMBRE_ORIGINAL);

		// Buscar el producto
		prod = productoService.buscarPorId(id);
		
		// Verificar que el nombre ha sido cambiado 
		assertEquals(NOMBRE_ORIGINAL,prod.getNombre());


	}
}
