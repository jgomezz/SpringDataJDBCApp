package pe.edu.tecsup.springbootapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.tecsup.springbootapp.entities.Categoria;

@SpringBootTest
class CategoriaServiceTest {

	private static Logger log 
		= LoggerFactory.getLogger(CategoriaServiceTest.class);

	@Autowired
	CategoriaService categoriaService;
	
	@Test
	void testListar() throws Exception {
		
		List<Categoria> cats = categoriaService.listar();
		
		log.info("cats.toString() " + cats.toString());

		log.info("Print by foreach");
		for(Categoria cat : cats) log.info(cat.toString());
				
		log.info("Print by stream");
		cats.stream().forEach(item -> log.info(item.toString()));

        assertEquals(false, cats.isEmpty());

	}

	
}
