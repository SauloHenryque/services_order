package br.com.saulo.order.dto.responses;


import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Response Order Payment")
public class OrderPaymentResponse implements Serializable{

	private static final long serialVersionUID = 4192610937139207457L;
	
    @ApiModelProperty(value = "Identificação da Order Payment", position = 1)
    private Long id;
    
    @ApiModelProperty(value = "Status payment", position = 2)
    private String status;

    @ApiModelProperty(value = "Número Cartão", position = 3)
    private String numero_cartao;
    
    @ApiModelProperty(value = "Data Payment", position = 2)
    private LocalDate data_pagamento;

    @ApiModelProperty(value = "Código identificação do Order", position = 5)
    private Long id_order_sale;
}
