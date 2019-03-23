package br.com.saulo.order.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulo.order.dto.persists.OrderItemPersist;
import br.com.saulo.order.dto.responses.OrderItemResponse;
import br.com.saulo.order.dto.responses.OrderResponse;
import br.com.saulo.order.entidades.OrderItemEntidade;
import br.com.saulo.order.servicos.OrderItemServico;
import br.com.saulo.order.ultil.GenericConvert;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/order-item", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "order-item")
public class OrderItemResource {
	
	 	@Autowired
		private OrderItemServico orderItemServico;
		
	 	@PostMapping
	    public ResponseEntity<?> salvar(@RequestBody @Valid OrderItemPersist request) {

			OrderItemEntidade orderItemEntidade = GenericConvert.convertModelMapper(request, OrderItemEntidade.class);
			orderItemEntidade 					= orderItemServico.salvarOrderItem(orderItemEntidade);
			OrderItemResponse response 			= GenericConvert.convertModelMapper(orderItemEntidade, OrderItemResponse.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }
	 	
		@PutMapping("/{id}")
	    public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody @Valid OrderItemPersist request ) {
			
			OrderItemEntidade orderItemEntidade 	= GenericConvert.convertModelMapper(request, OrderItemEntidade.class);
			orderItemEntidade.setId(id);
			
			orderItemEntidade 					= orderItemServico.atualizarOrderItem(orderItemEntidade);
			OrderResponse response 			= GenericConvert.convertModelMapper(orderItemEntidade, OrderResponse.class);

			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }

}
