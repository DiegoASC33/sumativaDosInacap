package cl.inacap.sumativaDosInacap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.inacap.sumativaDosInacap.entity.ProductoEntity;
import cl.inacap.sumativaDosInacap.repository.ProductoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductoRepositoryTest {
	
	@Autowired
	private ProductoRepository repo;
	
	@Test
	public void test_save_succes() throws ParseException {
		
		ProductoEntity p = new ProductoEntity();
		p.setNombre("Google");
		p.setPrecio(3412);
		p.setCategoria("Arte");
		p.setCaracteristicas("Fusce mi lorem, vehicula et, rutrum eu, ultrices sit");
		
		ProductoEntity saved = repo.save(p);
		//assertNotNull(saved);
		assertEquals(p.getNombre(), saved.getNombre());
	}
	@Test
	public void test_delete_succes() throws ParseException{
		
		ProductoEntity p = new ProductoEntity();
		p.setNombre("Google");
		p.setPrecio(3412);
		p.setCategoria("Arte");
		p.setCaracteristicas("Fusce mi lorem, vehicula et, rutrum eu, ultrices sit");
		
		ProductoEntity saved = repo.save(p);
		
		repo.deleteById(saved.getId());
		ProductoEntity after = repo.findById(saved.getId()).orElse(null);
		assertNull(after);
	}
	

}
