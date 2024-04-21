package pe.edu.tecsup.springbootapp.repositories;

import pe.edu.tecsup.springbootapp.entities.Categoria;

import java.util.List;

public interface CategoriaRepository {

    List<Categoria> findAll() throws Exception;

}
