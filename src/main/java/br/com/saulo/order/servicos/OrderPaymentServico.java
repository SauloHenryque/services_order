package br.com.saulo.order.servicos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saulo.order.entidades.OrderPaymentEntidade;
import br.com.saulo.order.repositorios.OrderPaymentRepositorio;
import lombok.Data;

@Data
@Service
public class OrderPaymentServico {
	
    
    @Autowired
    private OrderPaymentRepositorio orderPaymentRepositorio;
	

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
    	
    	OrderPaymentEntidade orderPaymentEntidade = orderPaymentRepositorio.findById(id);
    	orderPaymentRepositorio.delete(orderPaymentEntidade);
    }



}
