package br.com.saulo.order.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saulo.order.entidades.OrderPaymentEntidade;

@Repository
public interface OrderPaymentRepositorio extends JpaRepository<OrderPaymentEntidade, Long> {

	OrderPaymentEntidade findById(long id);

}
