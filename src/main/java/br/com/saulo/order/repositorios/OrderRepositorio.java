package br.com.saulo.order.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.saulo.order.entidades.OrderEntidade;

@Repository
public interface OrderRepositorio extends JpaRepository<OrderEntidade, Long> {

	OrderEntidade findById(int id);

	@Query(value = "SELECT OS.id from  order_sale OS INNER JOIN order_sale_payment OSP ON OSP.id_order_sale = OS.id where DATEADD(DAY, :dias, OS.data_confirmacao )  >=  CONVERT (date, GETDATE()) AND OS.status = 'CONFIRMADO' AND  OSP.status = 'CONCLUIDO' AND OS.id = :id", nativeQuery = true)
	Long findByIdAndDias(@Param("id") Long id, @Param("dias") Long dias);

}
