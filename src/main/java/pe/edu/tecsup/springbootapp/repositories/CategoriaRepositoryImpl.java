package pe.edu.tecsup.springbootapp.repositories;

import pe.edu.tecsup.springbootapp.entities.Categoria;

import java.util.List;

public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Override
    public List<Categoria> findAll() throws Exception {
        return List.of();
    }

}
