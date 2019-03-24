package br.com.saulo.order.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.saulo.order.entidades.OrderEntidade;
import br.com.saulo.order.exception.ExceptionOrder;
import br.com.saulo.order.repositorios.OrderRepositorio;
import br.com.saulo.order.ultil.Utils;
import br.com.twsoftware.alfred.object.Objeto;
import lombok.Data;

@Data
@Service
public class OrderServico {
	
    
    @Autowired
    private OrderRepositorio orderRepositorio;
    
    @Autowired
    private Utils uteis;
	
    @Autowired
    private ExceptionOrder exceptionOrder;

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
	
	/**
	 * Método responsável pela edição da order.
	 *  
	 * @param storeEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link orderEntidade}
	 * 
	 * @return {@link orderEntidade}
	 */
	public OrderEntidade atualizarOrder(OrderEntidade orderEntidade) {
		
		return orderRepositorio.save(orderEntidade);
	} 
	
	/**
	 * Método responsável pela listagem das store.
	 * 
	 * @param storeEntidade <br/>
	 *                   Objeto que representa a requisição do serviço
	 *                   {@link AddressEntidade}
	 * 
	 * @return {@link List(addressEntidade)}
	 */

    public List<OrderEntidade> listarOrder(OrderEntidade orderEntidade) {

    	return orderRepositorio.findAll(Example.of(orderEntidade));

    }

	public OrderEntidade reembolsarOrder(long id) throws Exception {
		
		OrderEntidade orderEntidade = orderRepositorio.findById(id);
		Long diasLimiteReembolso  = uteis.recuperarParametroEmissor(orderEntidade.getId_store(), "REEMBOLSODIAS");  
		Long idOrder 				= orderRepositorio.findByIdAndDias(id, diasLimiteReembolso);
		
		exceptionOrder.checkThrow(Objeto.isBlank(idOrder), "Order bloqueado para reembolso!");
		
		orderEntidade.setStatus("REEMBOLSO");
		return orderRepositorio.save(orderEntidade);
	}
	



}
