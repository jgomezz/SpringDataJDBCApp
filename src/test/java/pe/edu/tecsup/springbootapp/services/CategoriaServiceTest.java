package pe.edu.tecsup.springbootapp.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.springbootapp.entities.Categoria;
import pe.edu.tecsup.springbootapp.repositories.CategoriaRepositoryImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoriaServiceTest {

    private static Logger log = LoggerFactory.getLogger(CategoriaServiceTest.class);

    @Autowired
    CategoriaService categoriaService;

    @Test
    void testfindAll() throws Exception {

        boolean VALUE_EXPECTED = false;

        List<Categoria> categorias = categoriaService.findAll();

        log.info("cats.toString() " + categorias.toString());

        log.info("Print by foreach");
        for(Categoria cat : categorias) log.info(cat.toString());

        log.info("Print by stream");
        categorias.stream().forEach(item -> log.info(item.toString()));

        assertEquals(VALUE_EXPECTED, categorias.isEmpty());

    }
}