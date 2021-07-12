package spring.data.aula;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.data.aula.dao.InterfaceSpringDataUser;
import spring.data.aula.model.UsuarioSpringData;

//Integrar o spring com o Junit
@RunWith(SpringJUnit4ClassRunner.class)
//ler o arquivo spring-config
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppStripngDataTest {

	//Faz injeção de dependência
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("geodfrey@gmail.com");
		usuarioSpringData.setIdade(19);
		usuarioSpringData.setLogin("teste 123");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Frey");
		
		interfaceSpringDataUser.save(usuarioSpringData);
	}
	
	@Test
	public void testeConsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(5L);
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getLogin());
	}
	
	@Test
	public void testeConsultaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getId());
			System.out.println("--------------------------------------------------");
		}
	}
	
	@Test
	public void testeUpdate() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(4L);
		UsuarioSpringData data = usuarioSpringData.get();
		
		data.setNome("Hilton");
		interfaceSpringDataUser.save(data);
	}
	
	@Test
	public void testeDelete() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		interfaceSpringDataUser.delete(usuarioSpringData.get());
	}
}
