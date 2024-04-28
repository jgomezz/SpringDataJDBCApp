package pe.edu.tecsup.springbootapp.services;

import org.springframework.stereotype.Service;
import pe.edu.tecsup.springbootapp.entities.Categoria;
import pe.edu.tecsup.springbootapp.repositories.CategoriaRepository;

import java.util.List;

/**
 *
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{

    CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Categoria> findAll() throws Exception {
        return this.categoriaRepository .findAll();
    }

}
