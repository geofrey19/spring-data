package spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.data.aula.dao.InterfaceSpringDataUser;
import spring.data.aula.dao.InterfaceTelefone;
import spring.data.aula.model.Telefone;
import spring.data.aula.model.UsuarioSpringData;

//Integrar o spring com o Junit
@RunWith(SpringJUnit4ClassRunner.class)
//ler o arquivo spring-config
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppStripngDataTest {

	//Faz injeção de dependência
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	@Test
	public void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("geofrey@gmail.com");
		usuarioSpringData.setIdade(19);
		usuarioSpringData.setLogin("teste 1234");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Hilton");
		
		interfaceSpringDataUser.save(usuarioSpringData);
	}
	
	@Test
	public void testeConsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getLogin());
		
		for(Telefone telefone : usuarioSpringData.get().getTelefones()) {
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
		}
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
	
	@Test
	public void testeConsultaNome() {
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("George");
		for (UsuarioSpringData usuarioSpringData : list) {
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getId());
			System.out.println("--------------------------------------------------");
		}
	}
	
	@Test
	public void testeConsultaNomeParam() {
		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("Hilton");
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getId());
	}
	
	@Test
	public void testeDeletePorNome() {
		interfaceSpringDataUser.deletePorNome("Hilton");
	}
	
	@Test
	public 	void testeUpdatePorNome() {
		interfaceSpringDataUser.updatePorNome("geofrey1982@hotmail.com", "Frey");
	}
	
	@Test
	public void testeSetTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
				
		Telefone telefone = new Telefone();
		telefone.setTipo("Casa");
		telefone.setNumero("(71)3233-5565");
		telefone.setUsuario(usuarioSpringData.get());
		
		interfaceTelefone.save(telefone);
	}
}
