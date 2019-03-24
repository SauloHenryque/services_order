package br.com.saulo.order.dto.persists;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Persist Order")
public class OrderPersist implements Serializable {
	
	private static final long serialVersionUID = -7329881749188627883L;
	
	public enum TipoStatus { CRIADO, CONFIRMADO, CANCELADO};
	
    @ApiModelProperty(value = "Data confirmação Order", position = 1)
    private LocalDate data_confirmacao;

    @ApiModelProperty(value = "Status Order", position = 2)
    @NotNull(message = "Status não pode ser nulo")
    private TipoStatus status;
    
    @ApiModelProperty(value = "Id_store", position = 3)
    @NotNull(message = "Id_store não pode ser nulo")
    private Long id_store;


}
