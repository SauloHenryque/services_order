package br.com.saulo.store.unitario;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.saulo.order.entidades.OrderPaymentEntidade;
import br.com.saulo.order.exception.NotFoundException;
import br.com.saulo.order.repositorios.OrderPaymentRepositorio;
import br.com.saulo.order.repositorios.OrderRepositorio;
import br.com.saulo.order.servicos.OrderPaymentServico;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
public class OrderItemServicoTest {
 
	 @InjectMocks
     private OrderPaymentServico orderPaymentServicoMock;
	
     @Mock
     private OrderPaymentRepositorio orderPaymentRepositorio;
     
     @Mock
     private OrderRepositorio orderRepositorio;
     
     @Mock
     private OrderPaymentEntidade orderPaymentEntidade;

     @Before
     public void setup() {

          MockitoAnnotations.initMocks(this);
     }
     
     @Test
     public void salvarOrderPayment(){
    	 
    	 OrderPaymentEntidade	orderPaymentEntidadeNovo		 = new OrderPaymentEntidade();
    	 
    	 orderPaymentEntidadeNovo.setStatus("ABERTO");
    	 orderPaymentEntidadeNovo.setNumero_cartao("13213213565465");
    	 orderPaymentEntidadeNovo.setData_pagamento(LocalDate.now());
    	 orderPaymentEntidadeNovo.setId_order_sale(1L);
    	 	
    	 Mockito.when(orderRepositorio.existsById(1L)).thenReturn(true);
         Mockito.when(orderPaymentRepositorio.save(Mockito.any(OrderPaymentEntidade.class))).thenReturn(orderPaymentEntidadeNovo);

         OrderPaymentEntidade orderPaymentEntidadeCadastrado = orderPaymentServicoMock.salvarOrderPayment(orderPaymentEntidadeNovo);

         testCase(orderPaymentEntidadeNovo, orderPaymentEntidadeCadastrado);
     }
     
     @Test(expected = NotFoundException.class)
     public void salvarOrderPaymentOrderInexistente(){
    	 
    	 OrderPaymentEntidade	orderPaymentEntidadeNovo		 = new OrderPaymentEntidade();
    	 
    	 orderPaymentEntidadeNovo.setStatus("ABERTO");
    	 orderPaymentEntidadeNovo.setNumero_cartao("13213213565465");
    	 orderPaymentEntidadeNovo.setData_pagamento(LocalDate.now());
    	 orderPaymentEntidadeNovo.setId_order_sale(1L);
    	 	
    	 Mockito.when(orderRepositorio.existsById(1L)).thenReturn(false);
         Mockito.when(orderPaymentRepositorio.save(Mockito.any(OrderPaymentEntidade.class))).thenReturn(orderPaymentEntidadeNovo);

         orderPaymentServicoMock.salvarOrderPayment(orderPaymentEntidadeNovo);
     }
     
    @Test
    public void atualizarOrderPayment(){
    	 
   	 	OrderPaymentEntidade	orderPaymentEntidadeNovo		 = new OrderPaymentEntidade();
    	 
   	 	orderPaymentEntidadeNovo.setId(1L);
   	 	orderPaymentEntidadeNovo.setStatus("ABERTO");
	 	orderPaymentEntidadeNovo.setNumero_cartao("13213213565465");
	 	orderPaymentEntidadeNovo.setData_pagamento(LocalDate.now());
	 	orderPaymentEntidadeNovo.setId_order_sale(1L);
    	 	
    	 Mockito.when(orderPaymentRepositorio.existsById(1L)).thenReturn(true);
    	 Mockito.when(orderRepositorio.existsById(1L)).thenReturn(true);
         Mockito.when(orderPaymentRepositorio.save(Mockito.any(OrderPaymentEntidade.class))).thenReturn(orderPaymentEntidadeNovo);

         OrderPaymentEntidade orderPaymentEntidadeCadastrado = orderPaymentServicoMock.atualizarOrderPayment(orderPaymentEntidadeNovo);

         testCase(orderPaymentEntidadeNovo, orderPaymentEntidadeCadastrado);
         TestCase.assertEquals(orderPaymentEntidadeNovo.getId(), orderPaymentEntidadeCadastrado.getId());
    }
    
    @Test(expected = NotFoundException.class)
    public void atualizarOrderPaymentNaoEncontrado(){
   	 
    	OrderPaymentEntidade	orderPaymentEntidadeNovo		 = new OrderPaymentEntidade();
	 
   	 	orderPaymentEntidadeNovo.setId(1L);
   	 	orderPaymentEntidadeNovo.setStatus("ABERTO");
	 	orderPaymentEntidadeNovo.setNumero_cartao("13213213565465");
	 	orderPaymentEntidadeNovo.setData_pagamento(LocalDate.now());
	 	orderPaymentEntidadeNovo.setId_order_sale(1L);
   	 	
   	 	Mockito.when(orderPaymentRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(orderRepositorio.existsById(1L)).thenReturn(true);
        Mockito.when(orderPaymentRepositorio.save(Mockito.any(OrderPaymentEntidade.class))).thenReturn(orderPaymentEntidadeNovo);

        orderPaymentServicoMock.atualizarOrderPayment(orderPaymentEntidadeNovo);
    }
    
    @Test(expected = NotFoundException.class)
    public void atualizarOrderPaymentOrderNaoEncontrado(){
   	 
    	OrderPaymentEntidade	orderPaymentEntidadeNovo		 = new OrderPaymentEntidade();
	 
   	 	orderPaymentEntidadeNovo.setId(1L);
   	 	orderPaymentEntidadeNovo.setStatus("ABERTO");
	 	orderPaymentEntidadeNovo.setNumero_cartao("13213213565465");
	 	orderPaymentEntidadeNovo.setData_pagamento(LocalDate.now());
	 	orderPaymentEntidadeNovo.setId_order_sale(1L);
   	 	
   	 	Mockito.when(orderPaymentRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(orderRepositorio.existsById(1L)).thenReturn(false);
        Mockito.when(orderPaymentRepositorio.save(Mockito.any(OrderPaymentEntidade.class))).thenReturn(orderPaymentEntidadeNovo);

        orderPaymentServicoMock.atualizarOrderPayment(orderPaymentEntidadeNovo);

    }
    
    @Test()
    public void deletarOrderPayment(){
   	 
   	 	Mockito.when(orderPaymentRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(orderPaymentRepositorio.findById(1L)).thenReturn(orderPaymentEntidade);

   	 	orderPaymentServicoMock.deletarOrderPayment(1L);
    }
    
    @Test(expected = NotFoundException.class)
    public void deletarOrderPaymentInexistente(){
   	 
   	 	Mockito.when(orderPaymentRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(orderPaymentRepositorio.findById(1L)).thenReturn(orderPaymentEntidade);

   	 	orderPaymentServicoMock.deletarOrderPayment(1L);
    }


	private static void testCase(OrderPaymentEntidade orderPaymentEntidade, OrderPaymentEntidade orderPaymentEntidadeCadastrado) {
         
         TestCase.assertNotNull(orderPaymentEntidadeCadastrado);
         TestCase.assertEquals(orderPaymentEntidade.getData_pagamento(), orderPaymentEntidadeCadastrado.getData_pagamento());
         TestCase.assertEquals(orderPaymentEntidade.getStatus(), orderPaymentEntidadeCadastrado.getStatus());
         TestCase.assertEquals(orderPaymentEntidade.getNumero_cartao(), orderPaymentEntidadeCadastrado.getNumero_cartao());
         TestCase.assertEquals(orderPaymentEntidade.getId_order_sale(), orderPaymentEntidadeCadastrado.getId_order_sale());
         
         
    }
     

}
