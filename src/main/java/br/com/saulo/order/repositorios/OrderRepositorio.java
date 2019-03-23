package br.com.saulo.order.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saulo.order.entidades.OrderEntidade;

@Repository
public interface OrderRepositorio extends JpaRepository<OrderEntidade, Long> {

	OrderEntidade findById(long id);

}
