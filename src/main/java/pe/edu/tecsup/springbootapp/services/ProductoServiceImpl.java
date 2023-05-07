package pe.edu.tecsup.springbootapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.springbootapp.entities.Producto;
import pe.edu.tecsup.springbootapp.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	private static Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

//	@Autowired
//	ProductoRepository productoRepository;

	ProductoRepository productoRepository;

	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	
	@Override
	public List<Producto> listar() throws Exception {
		log.info("call listar()");
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> buscarPorNombre(String nombre) 
			throws Exception {
		log.info("call buscarPorNombre()");
		return productoRepository.findByName(nombre);
	}

	@Override
	public Producto buscarPorId(Long id) throws Exception {
		// TODO Auto-generated method stub
		log.info("call buscarPorId()");
		return productoRepository.findById(id);
	}

	
	@Override
	public void registrar(Producto producto) throws Exception {
		log.info("call registrar(producto: " + producto + ")");
		productoRepository.save(producto);
	}

	@Override
	public void eliminar(Long id) throws Exception {
		log.info("call eliminar(id: " + id + ")");
		productoRepository.deleteById(id);
	}

	@Override
	public void actualizar(Long id, String nombreProducto) throws Exception {
		log.info("call actualizar(id: " + id + ")");
		productoRepository.update(id, nombreProducto);
		
	}



}
