package br.com.saulo.order.ultil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.saulo.order.repositorios.StoreConfigRepositorio;
import br.com.twsoftware.alfred.object.Objeto;

@Component
public class Utils {
	
	@Autowired
 	private StoreConfigRepositorio storeConfigRepositorio;


    public Long recuperarParametroEmissor(Long idStore, String chave) {
    	
        String valor = storeConfigRepositorio.findByIdStoreAndChave(idStore, chave);
        
        return Objeto.notBlank(valor) ? Long.parseLong(valor)  : 0;
   }
	
}
