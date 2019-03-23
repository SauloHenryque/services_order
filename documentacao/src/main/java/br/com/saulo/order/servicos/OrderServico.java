package br.com.saulo.order.servicos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saulo.order.entidades.OrderEntidade;
import br.com.saulo.order.repositorios.OrderRepositorio;
import lombok.Data;

@Data
@Service
public class OrderServico {
	
    
    @Autowired
    private OrderRepositorio orderRepositorio;
	

	/**
	 * Método responsável pela criação da order.
	 *  
	 * @param orderEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link orderEntidade}
	 * 
	 * @return {@link OrderEntidade}
	 */
	public OrderEntidade salvarOrder(OrderEntidade orderEntidade) {
		
        return orderRepositorio.save(orderEntidade);

	}



}
