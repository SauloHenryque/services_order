
package br.com.saulo.order.exception;

import org.springframework.stereotype.Component;


@Component
public class ExceptionOrder {

	public void checkThrow(boolean expression, String msg){

		throw new ExceptionOrderImp(msg);
          
     }


}
