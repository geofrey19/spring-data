package spring.data.aula;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Integrar o spring com o Junit
@RunWith(SpringJUnit4ClassRunner.class)
//ler o arquivo spring-config
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppStripngDataTest {

	@Test
	public void testInsert() {
		System.out.println("Iniciou o spring com sucesso");
	}
}
