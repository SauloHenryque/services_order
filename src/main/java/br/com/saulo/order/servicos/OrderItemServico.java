package br.com.saulo.order.servicos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saulo.order.entidades.OrderItemEntidade;
import br.com.saulo.order.repositorios.OrderItemRepositorio;
import lombok.Data;

@Data
@Service
public class OrderItemServico {
	
    
    @Autowired
    private OrderItemRepositorio orderItemRepositorio;
	

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
    	
    	OrderItemEntidade orderItemEntidade = orderItemRepositorio.findById(id);
    	orderItemRepositorio.delete(orderItemEntidade);
    }



}
