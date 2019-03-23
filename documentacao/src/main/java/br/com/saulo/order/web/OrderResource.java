package br.com.saulo.order.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.saulo.order.dto.persists.OrderPersist;

import br.com.saulo.order.dto.responses.OrderResponse;
import br.com.saulo.order.entidades.OrderEntidade;
import br.com.saulo.order.servicos.OrderServico;
import br.com.saulo.order.ultil.GenericConvert;

@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderResource {
	
	 	@Autowired
		private OrderServico orderServico;
		
	 	@PostMapping
	    public ResponseEntity<?> salvar(@RequestBody @Valid OrderPersist request) {

			OrderEntidade orderEntidade = GenericConvert.convertModelMapper(request, OrderEntidade.class);
			orderEntidade 				= orderServico.salvarOrder(orderEntidade);
			OrderResponse response 		= GenericConvert.convertModelMapper(orderEntidade, OrderResponse.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }

}
