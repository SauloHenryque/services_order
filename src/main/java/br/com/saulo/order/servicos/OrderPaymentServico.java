package br.com.saulo.order.servicos;


import static br.com.saulo.order.exception.ExceptionOrder.checkThrow;
import static br.com.saulo.order.exception.ExceptionsMessagesEnum.REGISTRO_NAO_ENCONTRADO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saulo.order.entidades.OrderPaymentEntidade;
import br.com.saulo.order.repositorios.OrderPaymentRepositorio;
import br.com.saulo.order.repositorios.OrderRepositorio;
import lombok.Data;

@Data
@Service
public class OrderPaymentServico {
	
    
    @Autowired
    private OrderPaymentRepositorio orderPaymentRepositorio;
    
    @Autowired
    private OrderRepositorio orderRepositorio;
	

	/**
	 * Método responsável pela criação da order payment.
	 *  
	 * @param orderPaymentEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link orderPaymentEntidade}
	 * 
	 * @return {@link OrderPaymentEntidade}
	 */
	public OrderPaymentEntidade salvarOrderPayment(OrderPaymentEntidade orderPaymentEntidade) {
		
		checkThrow(!orderRepositorio.existsById(orderPaymentEntidade.getId_order_sale()), REGISTRO_NAO_ENCONTRADO);
        return orderPaymentRepositorio.save(orderPaymentEntidade);

	}
	
	/**
	 * Método responsável pela edição da order payment.
	 *  
	 * @param orderPaymentEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link orderPaymentEntidade}
	 * 
	 * @return {@link OrderPaymentEntidade}
	 */
	public OrderPaymentEntidade atualizarOrderPayment(OrderPaymentEntidade orderPaymentEntidade) {
		
		checkThrow(!orderPaymentRepositorio.existsById(orderPaymentEntidade.getId()), REGISTRO_NAO_ENCONTRADO);
		return orderPaymentRepositorio.save(orderPaymentEntidade);
	} 
	
	/**
	 * Método responsável por deletar um order payment.
	 *  
	 * @param id <br/>
	 * id order payment a ser deletada
	 * 
	 */
    public void deletarOrderPayment(long id) {
    	
    	checkThrow(!orderPaymentRepositorio.existsById(id), REGISTRO_NAO_ENCONTRADO);
    	OrderPaymentEntidade orderPaymentEntidade = orderPaymentRepositorio.findById(id);
    	orderPaymentRepositorio.delete(orderPaymentEntidade);
    }



}
