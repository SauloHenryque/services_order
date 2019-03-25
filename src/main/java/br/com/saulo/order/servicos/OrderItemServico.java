package br.com.saulo.order.servicos;


import static br.com.saulo.order.exception.ExceptionOrder.checkThrow;
import static br.com.saulo.order.exception.ExceptionsMessagesEnum.REGISTRO_NAO_ENCONTRADO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saulo.order.entidades.OrderItemEntidade;
import br.com.saulo.order.repositorios.OrderItemRepositorio;
import br.com.saulo.order.repositorios.OrderRepositorio;
import lombok.Data;

@Data
@Service
public class OrderItemServico {
	
    
    @Autowired
    private OrderItemRepositorio orderItemRepositorio;
	
    @Autowired
    private OrderRepositorio orderRepositorio;

	/**
	 * Método responsável pela criação da order item.
	 *  
	 * @param orderItemEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link orderItemEntidade}
	 * 
	 * @return {@link OrderItemEntidade}
	 */
	public OrderItemEntidade salvarOrderItem(OrderItemEntidade orderItemEntidade) {
		
		checkThrow(!orderRepositorio.existsById(orderItemEntidade.getId_order_sale()), REGISTRO_NAO_ENCONTRADO);
        return orderItemRepositorio.save(orderItemEntidade);

	}
	
	/**
	 * Método responsável pela edição da order item.
	 *  
	 * @param orderItemEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link orderItemEntidade}
	 * 
	 * @return {@link OrderItemEntidade}
	 */
	public OrderItemEntidade atualizarOrderItem(OrderItemEntidade orderItemEntidade) {
		
    	checkThrow(!orderItemRepositorio.existsById(orderItemEntidade.getId()), REGISTRO_NAO_ENCONTRADO);
    	checkThrow(!orderRepositorio.existsById(orderItemEntidade.getId_order_sale()), REGISTRO_NAO_ENCONTRADO);
		return orderItemRepositorio.save(orderItemEntidade);
	} 
	
	/**
	 * Método responsável por deletar um order item.
	 *  
	 * @param id <br/>
	 * id order item a ser deletada
	 * 
	 */
    public void deletarOrderItem(long id) {
    	
    	checkThrow(!orderItemRepositorio.existsById(id), REGISTRO_NAO_ENCONTRADO);
    	OrderItemEntidade orderItemEntidade = orderItemRepositorio.findById(id);
    	orderItemRepositorio.delete(orderItemEntidade);
    }



}
