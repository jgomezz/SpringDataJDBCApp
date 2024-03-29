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

//Mapper
class CategoriaRowMapper implements RowMapper<Categoria> {

	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categoria categoria = new Categoria();
		
		categoria.setId(rs.getLong("id"));
		categoria.setNombre(rs.getString("nombre"));
		categoria.setOrden(rs.getInt("orden"));
		
		return categoria;
	}
	
}

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

	private static Logger log = LoggerFactory.getLogger(CategoriaRepositoryImpl.class);
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	private JdbcTemplate jdbcTemplate;

	public CategoriaRepositoryImpl(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
		
	}
	
	
	@Override
	public List<Categoria> findAll() throws Exception {
		
		log.info("call listar()");
		
		String sql = "select * from categorias";
		
		List<Categoria> categorias 
			= jdbcTemplate.query(sql, new CategoriaRowMapper());

		return categorias;

	}

}
