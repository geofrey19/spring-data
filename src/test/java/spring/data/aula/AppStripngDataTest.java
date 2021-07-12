package spring.data.aula;

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
		System.out.println("Iniciou o spring com sucesso");
	}
}
