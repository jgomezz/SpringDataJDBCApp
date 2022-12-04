package pe.edu.tecsup.springbootapp.services;

import java.util.List;

import pe.edu.tecsup.springbootapp.entities.Categoria;

public interface CategoriaService {

	List<Categoria> listar() throws Exception;
}
