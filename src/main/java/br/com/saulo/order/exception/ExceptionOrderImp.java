
package br.com.saulo.order.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ExceptionOrderImp extends WebApplicationException {

	
	private static final long serialVersionUID = 1L;

	public ExceptionOrderImp(String message) {
        super(Response.status(Response.Status.BAD_REQUEST)
            .entity(message).type(MediaType.TEXT_PLAIN).build());
    }
}
