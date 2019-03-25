
package br.com.saulo.order.exception;

public class NotFoundException extends ExceptionOrder{

     private static final long serialVersionUID = 2157340495673911671L;

     public NotFoundException(String key, String msg){

          super(key, msg);
     }

     public NotFoundException(ExceptionsMessagesEnum globalRegistroNaoEncontrado){

          super(globalRegistroNaoEncontrado);

     }
}
