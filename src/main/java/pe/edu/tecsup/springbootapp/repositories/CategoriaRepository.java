package pe.edu.tecsup.springbootapp.repositories;

import java.util.List;

import pe.edu.tecsup.springbootapp.entities.Categoria;

public interface CategoriaRepository {

	List<Categoria> listar() throws Exception;
	
}
