package spring.data.aula.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.data.aula.model.UsuarioSpringData;

//Ativar o serviço de persistência precisa dessa anotação
@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {

	@Transactional(readOnly = true)
	@Query(value = "Select p from UsuarioSpringData p where p.nome like %?1%")
	public List<UsuarioSpringData> buscaPorNome(String nome);

	@Lock(LockModeType.READ)
	@Transactional(readOnly = true)
	@Query(value = "Select p from UsuarioSpringData p where p.nome=:paramnome")
	public UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);

	// dize que o método vai fazer modificações no banco de dados
	@Modifying
	// para poder excluir e commitar
	@Transactional(rollbackFor = {SQLException.class, NullPointerException.class} )
	@Query(value = "Delete from UsuarioSpringData u where u.nome= ?1")
	public void deletePorNome(String nome);
	
	@Modifying
	@Transactional(rollbackFor = {SQLException.class, NullPointerException.class} )
	@Query(value = "Update UsuarioSpringData u set u.email = ?1 where u.nome = ?2 ")
	public void updatePorNome(String email, String nome);
}
