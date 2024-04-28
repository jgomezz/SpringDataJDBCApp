package pe.edu.tecsup.springbootapp.repositories;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.springbootapp.entities.Categoria;
import pe.edu.tecsup.springbootapp.entities.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
class ProductoRowMapper implements RowMapper<Producto> {

	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {

		// Set categoria
		Categoria categoria = new Categoria();
		categoria.setId(rs.getLong("categorias_id"));
		categoria.setNombre(rs.getString("categorias_nombre"));

		// Set producto
		Producto producto = new Producto();
		producto.setId(rs.getLong("id"));
		producto.setCategorias_id(rs.getLong("categorias_id"));
		producto.setCategoria(categoria);
		producto.setNombre(rs.getString("nombre"));
		producto.setDescripcion(rs.getString("descripcion"));
		producto.setPrecio(rs.getDouble("precio"));
		producto.setStock(rs.getInt("stock"));
		producto.setImagen_nombre(rs.getString("imagen_nombre"));
		producto.setImagen_tipo(rs.getString("imagen_tipo"));
		producto.setImagen_tamanio(rs.getLong("imagen_tamanio"));
		producto.setEstado(rs.getInt("estado"));
		
		return producto;
	}
	
}

/**
 *
 */
@Log
@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

	JdbcTemplate jdbcTemplate;

	public ProductoRepositoryImpl(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Producto> findAll() throws Exception {
		log.info("call findAll()");
		String sql =
				"""
					SELECT p.id, p.categorias_id, c.nombre AS categorias_nombre, p.nombre, 
						   p.descripcion, p.precio, p.stock, p.imagen_nombre, p.imagen_tipo, 
						   p.imagen_tamanio, p.creado, p.estado 
					FROM productos p  
					INNER JOIN categorias c ON c.id = p.categorias_id
					WHERE estado=1 
					ORDER BY id
				""";
		
		List<Producto> productos = jdbcTemplate.query(sql, new ProductoRowMapper());

		log.info("Productos: " + productos);

		return productos;
	}

	/**
	 *
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Producto> findByName(String nombre) throws Exception {

		log.info("call findByName()");

		String sql =
				""" 
					SELECT 	p.id, p.categorias_id, c.nombre AS categorias_nombre, p.nombre, 
							p.descripcion, p.precio, p.stock, p.imagen_nombre, p.imagen_tipo, 
							p.imagen_tamanio, p.creado, p.estado 
					FROM productos p  
					INNER JOIN categorias c ON c.id = p.categorias_id 
					WHERE estado = 1 AND upper(p.nombre) LIKE upper(?)  
					ORDER BY id
				""";

		Object[] parameters = new Object[] {nombre}; // new Object[] {parameter1, parameter2 , .....,}
		List<Producto> productos = jdbcTemplate.query(sql, new ProductoRowMapper(), parameters );
		log.info("Productos: " + productos);

		return productos;
	}


	@Override
	public Producto findById(Long id) throws Exception {
		return null;
	}

	/**
	 *
	 * @param producto
	 * @throws Exception
	 */
	@Override
	public void save(Producto producto) throws Exception {

		log.info("call save()");

		String sql =
				"""
					INSERT INTO  productos (categorias_id, nombre, descripcion, precio, stock, estado, 
										   imagen_nombre, imagen_tipo, imagen_tamanio) 
					VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
				""";

		jdbcTemplate.update(sql,
				producto.getCategorias_id(),
				producto.getNombre(),
				producto.getDescripcion(),
				producto.getPrecio(),
				producto.getStock(),
				producto.getEstado(),
				producto.getImagen_nombre(),
				producto.getImagen_tipo(),
				producto.getImagen_tamanio());
	}

	@Override
	public void update(Long id, String nombreProducto) throws Exception {

	}

	@Override
	public void deleteById(Long id) throws Exception {

	}

}
