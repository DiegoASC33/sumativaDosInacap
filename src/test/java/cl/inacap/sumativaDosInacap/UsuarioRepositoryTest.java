package cl.inacap.sumativaDosInacap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.inacap.sumativaDosInacap.entity.UsuarioEntity;
import cl.inacap.sumativaDosInacap.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Test
	public void test_save_succes() throws ParseException{
		
		UsuarioEntity u = new UsuarioEntity();
		u.setNombre("Diego");
		u.setPassword("123456");
		u.setEdad(24);
		u.setPerfil("Soy Diego");
		
		UsuarioEntity saved = repo.save(u);
		assertEquals(u.getNombre(),saved.getNombre());
	}
	@Test
	public void test_delete_succes() throws ParseException{
		
		UsuarioEntity u = new UsuarioEntity();
		u.setNombre("Diego");
		u.setPassword("123456");
		u.setEdad(24);
		u.setPerfil("soyDiego");
		
		UsuarioEntity saved = repo.save(u);
		
		repo.deleteById(saved.getId());
		UsuarioEntity after = repo.findById(saved.getId()).orElse(null);
		assertNull(after);
	}
}
