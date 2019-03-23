package br.com.saulo.order.dto.responses;


import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Response Order Item")
public class OrderItemResponse implements Serializable{

	private static final long serialVersionUID = 4192610937139207457L;
	
	/**
     * Código de Identificação.
     */
    @ApiModelProperty(value = "Identificação da Order Item", position = 1)
    private Long id;

    /**
     * Descrição do item.
     */
    @ApiModelProperty(value = "Descrição do Item", position = 2)
    private String descricao;
    
    /**
     * Preço unitario
     */
    @ApiModelProperty(value = "Preço Unitario", position = 3)
    private BigDecimal preco_unitario;
    
    /**
     * Quantidade Item
     */
    @ApiModelProperty(value = "Preço Quantidade Item", position = 4)
    private Long quantidade;
    
    /**
     * Código identificação do Order
     */
    @ApiModelProperty(value = "Código identificação do Order", position = 5)
    private Long id_order_sale;
}
