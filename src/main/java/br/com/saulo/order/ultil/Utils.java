package br.com.saulo.order.ultil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.thiagonego.alfred.object.Objeto;

import br.com.saulo.order.repositorios.StoreConfigRepositorio;


@Component
public class Utils {
	
	@Autowired
 	private StoreConfigRepositorio storeConfigRepositorio;


    public Long recuperarParametroEmissor(Long idStore, String chave) {
    	
        String valor = storeConfigRepositorio.findByIdStoreAndChave(idStore, chave);
        
        return Objeto.notBlank(valor) ? Long.parseLong(valor)  : 0;
   }
	
}
