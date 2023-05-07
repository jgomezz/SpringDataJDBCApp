package pe.edu.tecsup.springbootapp.repositories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.tecsup.springbootapp.entities.Categoria;

@SpringBootTest
class CategoriaRepositoryTest {

	private static Logger log = LoggerFactory.getLogger(CategoriaRepositoryTest.class);
	
	@Autowired
	CategoriaRepository categoriaRepository;	
	
	@Test
	void testListar() {

		List<Categoria> cats = null;
		
		try {
			
			cats = categoriaRepository.findAll();
			
			// foreach
			for (Categoria item : cats) {
				log.info(item.toString());
			}
			
			// stream 
			cats.stream().forEach(item -> log.info(item.toString()));
			
		} catch (Exception e) {
			
			fail("Exception " + e.getMessage());
		
		}

		// Test validation..!
		assertThat(cats.isEmpty(), is(false));
		
	}

}
