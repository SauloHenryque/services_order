package br.com.saulo.order.dto.persists;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Persist Order Payment")
public class OrderPaymentPersist implements Serializable {
	
	private static final long serialVersionUID = -7329881749188627883L;
	
	public enum TipoStatusPagamento { ABERTO, FECHADO, ATRASADO};
	
    @ApiModelProperty(value = "Status Order Payment", position = 2)
    @NotNull(message = "Status não pode ser nulo")
    private TipoStatusPagamento status;
    
    @ApiModelProperty(value = "Número cartão", position = 1)
    @NotNull(message = "Cartão não pode ser nulo")
    private String numero_cartao;

    @ApiModelProperty(value = "Data pagamento", position = 1)
    private LocalDate data_pagamento;
    
    @ApiModelProperty(value = "Código identificacao Order", position = 4)
    @NotNull(message = "Código identificação não pode ser nulo")
    private Long id_order_sale;

}
