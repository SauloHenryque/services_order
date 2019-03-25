package br.com.saulo.order.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulo.order.dto.persists.OrderPaymentPersist;
import br.com.saulo.order.dto.responses.OrderPaymentResponse;
import br.com.saulo.order.entidades.OrderPaymentEntidade;
import br.com.saulo.order.servicos.OrderPaymentServico;
import br.com.saulo.order.ultil.GenericConvert;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/order-payment", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "order-payment")
public class OrderPaymentResource {
	
	 	@Autowired
		private OrderPaymentServico orderPaymentServico;
		
	 	@PostMapping
	    public ResponseEntity<?> salvar(@RequestBody @Valid OrderPaymentPersist request) {

			OrderPaymentEntidade orderPaymentEntidade 	= GenericConvert.convertModelMapper(request, OrderPaymentEntidade.class);
			orderPaymentEntidade 						= orderPaymentServico.salvarOrderPayment(orderPaymentEntidade);
			OrderPaymentResponse response 				= GenericConvert.convertModelMapper(orderPaymentEntidade, OrderPaymentResponse.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }
	 	
		@PutMapping("/{id}")
	    public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody @Valid OrderPaymentPersist request ) {
			
			OrderPaymentEntidade orderPaymentEntidade 	= GenericConvert.convertModelMapper(request, OrderPaymentEntidade.class);
			orderPaymentEntidade.setId(id);
			
			orderPaymentEntidade 					= orderPaymentServico.atualizarOrderPayment(orderPaymentEntidade);
			OrderPaymentResponse response 			= GenericConvert.convertModelMapper(orderPaymentEntidade, OrderPaymentResponse.class);

			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }
		
		@DeleteMapping("/{id}")
	    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
			
			orderPaymentServico.deletarOrderPayment(id);
	        return ResponseEntity.ok(HttpStatus.OK);
	    }

}
