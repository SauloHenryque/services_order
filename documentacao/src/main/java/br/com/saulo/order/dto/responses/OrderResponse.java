package br.com.saulo.order.dto.responses;


import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Response Order")
public class OrderResponse implements Serializable{

	private static final long serialVersionUID = 4192610937139207457L;
	
	/**
     * Código de Identificação.
     */
    @ApiModelProperty(value = "Identificação da Order", position = 1)
    private Long id;

    /**
     * Data Confirmação Order.
     */
    @ApiModelProperty(value = "Data confirmação order", position = 2)
    private LocalDate data_confirmacao;
    
    /**
     * Status Order
     */
    @ApiModelProperty(value = "Status order", position = 3)
    private String status;
}
