package br.com.saulo.order.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.saulo.order.entidades.StoreConfigEntidade;

@Repository
public interface StoreConfigRepositorio extends JpaRepository<StoreConfigEntidade, Long> {
	
	@Query(value = "SELECT SC.valor from  store_config SC where SC.id_store = :idStore AND SC.chave = :chave", nativeQuery = true)
	String findByIdStoreAndChave(@Param("idStore") Long idStore, @Param("chave") String chave);
}
