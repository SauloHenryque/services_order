package br.com.saulo.order.web;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulo.order.dto.persists.OrderPersist;
import br.com.saulo.order.dto.requests.OrderRequest;
import br.com.saulo.order.dto.responses.OrderResponse;
import br.com.saulo.order.entidades.OrderEntidade;
import br.com.saulo.order.servicos.OrderServico;
import br.com.saulo.order.ultil.GenericConvert;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "order")
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
	 	
		@PutMapping("/{id}")
	    public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody @Valid OrderPersist request ) {
			
			OrderEntidade orderEntidade 	= GenericConvert.convertModelMapper(request, OrderEntidade.class);
			orderEntidade.setId(id);
			
			orderEntidade 					= orderServico.atualizarOrder(orderEntidade);
			OrderResponse response 			= GenericConvert.convertModelMapper(orderEntidade, OrderResponse.class);

			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }
		
		@GetMapping
	    public ResponseEntity<?> listar(@Valid OrderRequest orderRequest) {
			
			OrderEntidade orderEntidade = GenericConvert.convertModelMapper(orderRequest, OrderEntidade.class);	
			return ResponseEntity.status(HttpStatus.OK).body(orderServico.listarOrder(orderEntidade));
	    }
		
		@PatchMapping("/{id}")
	    public ResponseEntity<?> reembolsar(@PathVariable("id") int id) throws Exception {
			
			OrderEntidade orderEntidade = orderServico.reembolsarOrder(id);
			OrderResponse response 		= GenericConvert.convertModelMapper(orderEntidade, OrderResponse.class);
			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }
		
		

}
