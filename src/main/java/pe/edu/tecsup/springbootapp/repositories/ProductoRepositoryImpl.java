package pe.edu.tecsup.springbootapp.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.edu.tecsup.springbootapp.entities.Categoria;
import pe.edu.tecsup.springbootapp.entities.Producto;


//Class Mapper
class ProductoRowMapper implements RowMapper<Producto> {

	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Producto producto = new Producto();
		producto.setId(rs.getLong("id"));
		producto.setCategorias_id(rs.getLong("categorias_id"));
		
		// set categoria
		Categoria categoria = new Categoria();
		categoria.setId(rs.getLong("categorias_id"));
		categoria.setNombre(rs.getString("categorias_nombre"));
		producto.setCategoria(categoria);
		
		producto.setNombre(rs.getString("nombre"));
		producto.setDescripcion(rs.getString("descripcion"));
		producto.setPrecio(rs.getDouble("precio"));
		
		if (rs.wasNull())
			producto.setPrecio(null);
		producto.setStock(rs.getInt("stock"));
		producto.setImagen_nombre(rs.getString("imagen_nombre"));
		producto.setImagen_tipo(rs.getString("imagen_tipo"));
		producto.setImagen_tamanio(rs.getLong("imagen_tamanio"));
		
		if (rs.wasNull())
			producto.setImagen_tamanio(null);
		producto.setEstado(rs.getInt("estado"));
		
		return producto;
	}
	
}

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

	private static Logger log = LoggerFactory.getLogger(ProductoRepositoryImpl.class);

//	@Autowired
//	JdbcTemplate jdbcTemplate;

	JdbcTemplate jdbcTemplate;

    public ProductoRepositoryImpl(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	// jdbcTemplate.query
	@Override
	public List<Producto> findAll() throws Exception {
		log.info("call listar()");
		String sql = "SELECT p.id, p.categorias_id, c.nombre AS categorias_nombre, p.nombre, "
				+ " p.descripcion, p.precio, p.stock, p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio, p.creado, "
				+ " p.estado " 
				+ "FROM productos p " 
				+ "INNER JOIN categorias c ON c.id=p.categorias_id\r\n"
				//+ "WHERE estado=1 AND p.nombre =  ? " 
				+ "WHERE estado=1 " 
				+ "ORDER BY id";
		
		//List<Producto> productos = jdbcTemplate.query(sql,  new Object[] {"Kingstone"}, new RowMapper<Producto>() {
		List<Producto> productos = jdbcTemplate.query(sql, new ProductoRowMapper());
		log.info("productos: " + productos);
		return productos;
	}
	
	
	
	@Override
	public List<Producto> findByName(String nombre) throws Exception {
		
		log.info("call buscarPorNombre()");
		
		String sql = "SELECT p.id, p.categorias_id, c.nombre AS categorias_nombre, p.nombre, "
				+ " p.descripcion, p.precio, p.stock, p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio, p.creado, "
				+ " p.estado " 
				+ "FROM productos p " 
				+ "INNER JOIN categorias c ON c.id=p.categorias_id "
				+ "WHERE estado=1 AND upper(p.nombre) LIKE  upper(?) " 
				+ "ORDER BY id";
		
		Object[] parameters = new Object[] {nombre}; // new Object[] {parameter1, parameter2 , .....,}
		List<Producto> productos = jdbcTemplate.query(sql, new ProductoRowMapper(), parameters );  
		log.info("productos: " + productos);
		
		return productos;
	}
	

	@Override
	public Producto findById(Long id) throws Exception {

		String sql = "SELECT p.id, p.categorias_id, c.nombre AS categorias_nombre, p.nombre, p.estado,"
				+ " p.descripcion, p.precio, p.stock, p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio, p.creado "
				+ " FROM productos p " 
				+ " INNER JOIN categorias c ON c.id=p.categorias_id "
				+ " WHERE estado=1 AND p.id = ? ";
		
		Object[] parameter = new Object[] {id}; 
		Producto prod = jdbcTemplate.queryForObject(sql, new ProductoRowMapper(), parameter) ;
		return prod;
	}
	

	// jdbcTemplate.update
	@Override
	public void save(Producto producto) throws Exception {
		
		log.info("call registrar(producto: " + producto + ")");
		
		String sql = "INSERT INTO productos (categorias_id, nombre, descripcion, precio, stock, estado, imagen_nombre, imagen_tipo, imagen_tamanio) " +
		             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
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

	// jdbcTemplate.update
	@Override
	public void deleteById(Long id) throws Exception {
		log.info("call eliminar(id: " + id + ")");
		String sql = "DELETE FROM productos WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	// jdbcTemplate.update
	@Override
	public void update(Long id, String nombreProducto) throws Exception {
		log.info("call actualizar(id: " + id + ")");
		String sql = "UPDATE productos SET  nombre = ?  WHERE id = ?";
		jdbcTemplate.update(sql, 
							nombreProducto,
							id);
	}




}
