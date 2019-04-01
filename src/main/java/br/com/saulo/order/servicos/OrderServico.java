package br.com.saulo.order.servicos;

import static br.com.saulo.order.exception.ExceptionOrder.checkThrow;
import static br.com.saulo.order.exception.ExceptionsMessagesEnum.ORDER_REEMBOLSO_NAO_ENCONTRADO;
import static br.com.saulo.order.exception.ExceptionsMessagesEnum.REGISTRO_NAO_ENCONTRADO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.github.thiagonego.alfred.object.Objeto;

import br.com.saulo.order.entidades.OrderEntidade;
import br.com.saulo.order.repositorios.OrderRepositorio;
import br.com.saulo.order.ultil.Utils;
import lombok.Data;

@Data
@Service
public class OrderServico {
	
    
    @Autowired
    private OrderRepositorio orderRepositorio;
    
    @Autowired
    private Utils uteis;


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
	public OrderEntidade atualizarOrder(OrderEntidade orderEntidadeUpdate) {
		
		checkThrow(!orderRepositorio.existsById(orderEntidadeUpdate.getId()), REGISTRO_NAO_ENCONTRADO);
		
		return orderRepositorio.save(orderEntidadeUpdate);
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

    public List<OrderEntidade> listarOrder(OrderEntidade orderEntidadeUpdate) {

    	return orderRepositorio.findAll(Example.of(orderEntidadeUpdate));

    }

    
	/**
	 * Método responsável pelo reembolso do order
	 *  
	 * @param id <br/>
	 * 
	 * @return {@link orderEntidade}
	 */
	public OrderEntidade reembolsarOrder(int id) {
		
		Long idLong = new Long(id);
		checkThrow(!orderRepositorio.existsById(idLong), REGISTRO_NAO_ENCONTRADO);
		OrderEntidade orderEntidade = orderRepositorio.findById(id);
		
		Long diasLimiteReembolso  	= uteis.recuperarParametroEmissor(orderEntidade.getId_store(), "REEMBOLSODIAS");  
		Long idOrder 				= orderRepositorio.findByIdAndDias(idLong, diasLimiteReembolso);
		checkThrow(Objeto.isBlank(idOrder), ORDER_REEMBOLSO_NAO_ENCONTRADO);
		
		orderEntidade.setStatus("REEMBOLSO");
		return orderRepositorio.save(orderEntidade);
	}
	



}
