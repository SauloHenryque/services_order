package br.com.saulo.store.unitario;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import br.com.saulo.order.dto.requests.OrderRequest;
import br.com.saulo.order.entidades.OrderEntidade;
import br.com.saulo.order.exception.NotFoundException;
import br.com.saulo.order.repositorios.OrderRepositorio;
import br.com.saulo.order.repositorios.StoreConfigRepositorio;
import br.com.saulo.order.servicos.OrderServico;
import br.com.saulo.order.ultil.Utils;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
public class OrderServicoTest {
 
	 @InjectMocks
     private OrderServico orderServicoMock;
	
     @Mock
     private OrderRepositorio orderRepositorio;
     
     @Mock
     private StoreConfigRepositorio storeConfigRepositorio;
     
     @Mock
     private OrderEntidade orderEntidade;
     
     private OrderRequest orderRequest;
     
     @Mock
     private Utils uteis;

     @Before
     public void setup() {

          MockitoAnnotations.initMocks(this);
          orderRequest = new OrderRequest();
     }
     
     @Test
     public void salvarOrder(){
    	 
    	 OrderEntidade	orderEntidadeNovo		 = new OrderEntidade();
    	 
    	 orderEntidadeNovo.setData_confirmacao(LocalDate.now());
    	 orderEntidadeNovo.setStatus("CRIADO");
    	 orderEntidadeNovo.setId_store(1L);
     
         Mockito.when(orderRepositorio.save(Mockito.any(OrderEntidade.class))).thenReturn(orderEntidadeNovo);

         OrderEntidade orderEntidadeCadastrado = orderServicoMock.salvarOrder(orderEntidadeNovo);

         testCase(orderEntidadeNovo, orderEntidadeCadastrado);
     }
  
     
    @Test
    public void atualizarOrder(){
    	 
   	 	OrderEntidade	orderEntidadeNovo		 = new OrderEntidade();
    	 
   	 	orderEntidadeNovo.setId(1L);
    	orderEntidadeNovo.setData_confirmacao(LocalDate.now());
    	orderEntidadeNovo.setStatus("CRIADO");
    	orderEntidadeNovo.setId_store(1L);
     
    	Mockito.when(orderRepositorio.existsById(1L)).thenReturn(true);
        Mockito.when(orderRepositorio.save(Mockito.any(OrderEntidade.class))).thenReturn(orderEntidadeNovo);

        OrderEntidade orderEntidadeCadastrado = orderServicoMock.atualizarOrder(orderEntidadeNovo);

        testCase(orderEntidadeNovo, orderEntidadeCadastrado);
        TestCase.assertEquals(orderEntidadeNovo.getId(), orderEntidadeCadastrado.getId());
    }
    
    @Test(expected = NotFoundException.class)
    public void atualizarOrderNaoEncontrado(){
   	 
   	 	OrderEntidade	orderEntidadeNovo		 = new OrderEntidade();
   	 
   	 	orderEntidadeNovo.setId(1L);
    	orderEntidadeNovo.setData_confirmacao(LocalDate.now());
    	orderEntidadeNovo.setStatus("CRIADO");
    	orderEntidadeNovo.setId_store(1L);
     
    	Mockito.when(orderRepositorio.existsById(1L)).thenReturn(false);
        Mockito.when(orderRepositorio.save(Mockito.any(OrderEntidade.class))).thenReturn(orderEntidadeNovo);

        OrderEntidade orderEntidadeCadastrado = orderServicoMock.atualizarOrder(orderEntidadeNovo);

        testCase(orderEntidadeNovo, orderEntidadeCadastrado);
    }

	private static void testCase(OrderEntidade orderEntidade, OrderEntidade orderEntidadeCadastrado) {
         
         TestCase.assertNotNull(orderEntidade);
         TestCase.assertEquals(orderEntidade.getData_confirmacao(), orderEntidadeCadastrado.getData_confirmacao());
         TestCase.assertEquals(orderEntidade.getStatus(), orderEntidadeCadastrado.getStatus());
         TestCase.assertEquals(orderEntidade.getId_store(), orderEntidadeCadastrado.getId_store());
         
    }
     
    @Test
    public void testListar() {

    	OrderEntidade	orderEntidadeNovo		 = new OrderEntidade();
	 
    	orderEntidadeNovo.setStatus("CRIADO");
    	
        List<OrderEntidade> listaOrderEntidade  = Lists.newArrayList(orderEntidade);
    	 	
        Mockito.when(orderRepositorio.findAll(Example.of(orderEntidadeNovo))).thenReturn(listaOrderEntidade);
    	 
        List<OrderEntidade> listaOrderEntidade1 = orderServicoMock.listarOrder(orderEntidade);
       
    	assertNotNull(listaOrderEntidade1);
        

    }
    
    @Test(expected = NotFoundException.class)
    public void reembolsarOrderInvalido() {
    	
    	OrderEntidade	orderEntidadeNovo		 = new OrderEntidade();
    	
    	orderEntidadeNovo.setId(1L);
    	orderEntidadeNovo.setData_confirmacao(LocalDate.now());
    	orderEntidadeNovo.setStatus("REEMBOLSO");
    	orderEntidadeNovo.setId_store(1L);
    	
    	Mockito.when(orderRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(orderRepositorio.findById(1)).thenReturn(orderEntidadeNovo);
   	 	Mockito.when(storeConfigRepositorio.findByIdStoreAndChave(1L, "CHAVE")).thenReturn(null);
   	 	Mockito.when(orderRepositorio.findByIdAndDias(1L, 10L)).thenReturn(10L);
   	 	Mockito.when(orderRepositorio.save(Mockito.any(OrderEntidade.class))).thenReturn(orderEntidadeNovo);
   	 	
   	 	orderServicoMock.reembolsarOrder(1);

   	 
    }
    
    @Test
    public void reembolsarOrder() {
    	
    	OrderEntidade	orderEntidadeNovo		 = new OrderEntidade();
    	
    	orderEntidadeNovo.setId(1L);
    	orderEntidadeNovo.setData_confirmacao(LocalDate.now());
    	orderEntidadeNovo.setStatus("REEMBOLSO");
    	orderEntidadeNovo.setId_store(1L);
    	
    	Mockito.when(orderRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(orderRepositorio.findById(1)).thenReturn(orderEntidadeNovo);
   	 	Mockito.when(storeConfigRepositorio.findByIdStoreAndChave(1L, "CHAVE")).thenReturn("10");
   	 	Mockito.when(orderRepositorio.findByIdAndDias(1L, 10L)).thenReturn(10L);
   	 	Mockito.when(orderRepositorio.save(Mockito.any(OrderEntidade.class))).thenReturn(orderEntidadeNovo);
   	 	
   	 	OrderEntidade orderEntidadeCadastrado = orderServicoMock.reembolsarOrder(1);
        testCase(orderEntidadeNovo, orderEntidadeCadastrado);
        TestCase.assertEquals(orderEntidadeNovo.getId(), orderEntidadeCadastrado.getId());
   	 
    }

}
