package spring.data.aula.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.data.aula.model.UsuarioSpringData;

//Ativar o serviço de persistência precisa dessa anotação
@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long>{

	
}
