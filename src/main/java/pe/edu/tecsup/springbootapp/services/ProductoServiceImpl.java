package pe.edu.tecsup.springbootapp.services;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.springbootapp.entities.Producto;
import pe.edu.tecsup.springbootapp.repositories.ProductoRepository;

import java.util.List;

/**
 *
 */
@Log
@Service
public class ProductoServiceImpl implements ProductoService {

	ProductoRepository productoRepository;

	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	/**
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Producto> findAll() throws Exception {
		log.info("call findAll()");
		return productoRepository.findAll();
	}

	/**
	 *
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Producto> findByName(String nombre) 
			throws Exception {
		log.info("call findByName()");
		return productoRepository.findByName(nombre);
	}

	/**
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Producto findById(Long id) throws Exception {
		log.info("call findById()");
		return productoRepository.findById(id);
	}

	/**
	 *
	 * @param producto
	 * @throws Exception
	 */
	@Override
	public void save(Producto producto) throws Exception {
		log.info("call save()");
		productoRepository.save(producto);
	}

	/**
	 *
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteById(Long id) throws Exception {
		log.info("call deleteById()");
		productoRepository.deleteById(id);
	}

	/**
	 *
	 * @param id
	 * @param nombreProducto
	 * @throws Exception
	 */
	@Override
	public void update(Long id, String nombreProducto) throws Exception {
		log.info("call update()");
		productoRepository.update(id, nombreProducto);
	}

}
