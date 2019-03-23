package br.com.saulo.order.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saulo.order.entidades.OrderItemEntidade;

@Repository
public interface OrderItemRepositorio extends JpaRepository<OrderItemEntidade, Long> {

	OrderItemEntidade findById(long id);

}
