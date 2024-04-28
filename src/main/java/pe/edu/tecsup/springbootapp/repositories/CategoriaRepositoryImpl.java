package pe.edu.tecsup.springbootapp.repositories;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.springbootapp.entities.Categoria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
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

/**
 *
 */
@Log
@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    /* Forma 1 : Inyeccion
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //*/

    //* Forma 2 : Inyeccion
    private JdbcTemplate jdbcTemplate;

    public CategoriaRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //*/

    @Override
    public List<Categoria> findAll() throws Exception {

        log.info("call findAll()");

        String sql = "SELECT * FROM categorias";

        List<Categoria> categorias
                = jdbcTemplate.query(sql, new CategoriaRowMapper());

        return categorias;
    }

}