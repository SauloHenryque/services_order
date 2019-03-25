package br.com.saulo.store.unitario;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import br.com.saulo.order.entidades.OrderItemEntidade;
import br.com.saulo.order.exception.BadRequestException;
import br.com.saulo.order.exception.NotFoundException;
import br.com.saulo.order.repositorios.OrderItemRepositorio;
import br.com.saulo.order.repositorios.OrderRepositorio;
import br.com.saulo.order.servicos.OrderItemServico;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
public class OrderPaymentServicoTest {
 
	 @InjectMocks
     private OrderItemServico orderItemServicoMock;
	
     @Mock
     private OrderItemRepositorio orderItemRepositorio;
     
     @Mock
     private OrderRepositorio orderRepositorio;
     
     @Mock
     private OrderItemEntidade orderItemEntidade;

     @Before
     public void setup() {

          MockitoAnnotations.initMocks(this);
     }
     
     @Test
     public void salvarOrderItem(){
    	 
    	 OrderItemEntidade	orderItemEntidadeNovo		 = new OrderItemEntidade();
    	 
    	 orderItemEntidadeNovo.setDescricao("Nome Teste");
    	 orderItemEntidadeNovo.setPreco_unitario(new BigDecimal("10.00"));
    	 orderItemEntidadeNovo.setQuantidade(10L);
    	 orderItemEntidadeNovo.setId_order_sale(1L);
    	 	
    	 Mockito.when(orderRepositorio.existsById(1L)).thenReturn(true);
         Mockito.when(orderItemRepositorio.save(Mockito.any(OrderItemEntidade.class))).thenReturn(orderItemEntidadeNovo);

         OrderItemEntidade orderItemEntidadeCadastrado = orderItemServicoMock.salvarOrderItem(orderItemEntidadeNovo);

         testCase(orderItemEntidadeNovo, orderItemEntidadeCadastrado);
     }
     
     @Test(expected = NotFoundException.class)
     public void salvarOrderItemOrderInexistente(){
    	 
    	 OrderItemEntidade	orderItemEntidadeNovo		 = new OrderItemEntidade();
    	 
    	 orderItemEntidadeNovo.setDescricao("Nome Teste");
    	 orderItemEntidadeNovo.setPreco_unitario(new BigDecimal("10.00"));
    	 orderItemEntidadeNovo.setQuantidade(10L);
    	 orderItemEntidadeNovo.setId_order_sale(1L);
    	 	
    	 Mockito.when(orderRepositorio.existsById(1L)).thenReturn(false);
         Mockito.when(orderItemRepositorio.save(Mockito.any(OrderItemEntidade.class))).thenReturn(orderItemEntidadeNovo);

         orderItemServicoMock.salvarOrderItem(orderItemEntidadeNovo);
     }
     
    @Test
    public void atualizarOrderItem(){
    	 
    	 OrderItemEntidade	orderItemEntidadeNovo		 = new OrderItemEntidade();
    	 
    	 orderItemEntidadeNovo.setId(1L);
    	 orderItemEntidadeNovo.setDescricao("Nome Teste");
    	 orderItemEntidadeNovo.setPreco_unitario(new BigDecimal("10.00"));
    	 orderItemEntidadeNovo.setQuantidade(10L);
    	 orderItemEntidadeNovo.setId_order_sale(1L);
    	 	
    	 Mockito.when(orderItemRepositorio.existsById(1L)).thenReturn(true);
    	 Mockito.when(orderRepositorio.existsById(1L)).thenReturn(true);
         Mockito.when(orderItemRepositorio.save(Mockito.any(OrderItemEntidade.class))).thenReturn(orderItemEntidadeNovo);

         OrderItemEntidade orderItemEntidadeCadastrado = orderItemServicoMock.atualizarOrderItem(orderItemEntidadeNovo);

         testCase(orderItemEntidadeNovo, orderItemEntidadeCadastrado);
         TestCase.assertEquals(orderItemEntidadeNovo.getId(), orderItemEntidadeCadastrado.getId());
    }
    
    @Test(expected = NotFoundException.class)
    public void atualizarOrderItemNaoEncontrado(){
   	 
   	 	OrderItemEntidade	orderItemEntidadeNovo		 = new OrderItemEntidade();
	 
   	 	orderItemEntidadeNovo.setId(1L);
   	 	orderItemEntidadeNovo.setDescricao("Nome Teste");
   	 	orderItemEntidadeNovo.setPreco_unitario(new BigDecimal("10.00"));
   	 	orderItemEntidadeNovo.setQuantidade(10L);
   	 	orderItemEntidadeNovo.setId_order_sale(1L);
   	 	
   	 	Mockito.when(orderItemRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(orderRepositorio.existsById(1L)).thenReturn(true);
        Mockito.when(orderItemRepositorio.save(Mockito.any(OrderItemEntidade.class))).thenReturn(orderItemEntidadeNovo);

        orderItemServicoMock.atualizarOrderItem(orderItemEntidadeNovo);
    }
    
    @Test(expected = NotFoundException.class)
    public void atualizarOrderItemOrderNaoEncontrado(){
   	 
   	 	OrderItemEntidade	orderItemEntidadeNovo		 = new OrderItemEntidade();
	 
   	 	orderItemEntidadeNovo.setId(1L);
   	 	orderItemEntidadeNovo.setDescricao("Nome Teste");
   	 	orderItemEntidadeNovo.setPreco_unitario(new BigDecimal("10.00"));
   	 	orderItemEntidadeNovo.setQuantidade(10L);
   	 	orderItemEntidadeNovo.setId_order_sale(1L);
   	 	
   	 	Mockito.when(orderItemRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(orderRepositorio.existsById(1L)).thenReturn(false);
        Mockito.when(orderItemRepositorio.save(Mockito.any(OrderItemEntidade.class))).thenReturn(orderItemEntidadeNovo);

        orderItemServicoMock.atualizarOrderItem(orderItemEntidadeNovo);

    }
    
    @Test()
    public void deletarOrderItem(){
   	 
   	 	Mockito.when(orderItemRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(orderItemRepositorio.findById(1L)).thenReturn(orderItemEntidade);

   	 	orderItemServicoMock.deletarOrderItem(1L);
    }
    
    @Test(expected = NotFoundException.class)
    public void deletarOrderItemInexistente(){
   	 
   	 	Mockito.when(orderItemRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(orderItemRepositorio.findById(1L)).thenReturn(orderItemEntidade);

   	 orderItemServicoMock.deletarOrderItem(1L);
    }


	private static void testCase(OrderItemEntidade orderItemEntidade, OrderItemEntidade orderItemEntidadeCadastrado) {
         
         TestCase.assertNotNull(orderItemEntidadeCadastrado);
         TestCase.assertEquals(orderItemEntidade.getDescricao(), orderItemEntidadeCadastrado.getDescricao());
         TestCase.assertEquals(orderItemEntidade.getPreco_unitario(), orderItemEntidadeCadastrado.getPreco_unitario());
         TestCase.assertEquals(orderItemEntidade.getQuantidade(), orderItemEntidadeCadastrado.getQuantidade());
         TestCase.assertEquals(orderItemEntidade.getId_order_sale(), orderItemEntidadeCadastrado.getId_order_sale());
         
         
    }
     

}
