package pe.edu.tecsup.springbootapp.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.tecsup.springbootapp.entities.Categoria;
import pe.edu.tecsup.springbootapp.services.CategoriaServiceImpl;

import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Override
    public List<Categoria> findAll() throws Exception {

        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Computadoras");

        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Monitores");

        return List.of(categoria1, categoria2);
        //return List.of();
    }

}
