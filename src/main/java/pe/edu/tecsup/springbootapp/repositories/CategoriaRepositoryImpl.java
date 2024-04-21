package pe.edu.tecsup.springbootapp.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.tecsup.springbootapp.entities.Categoria;

import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Override
    public List<Categoria> findAll() throws Exception {
        return List.of();
    }

}
