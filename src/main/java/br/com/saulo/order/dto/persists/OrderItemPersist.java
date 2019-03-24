package br.com.saulo.order.dto.persists;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Persist Order")
public class OrderItemPersist implements Serializable {
	
	private static final long serialVersionUID = -7329881749188627883L;
	
    @ApiModelProperty(value = "Descrição do Item", position = 1)
    @NotNull(message = "Descrição do item não pode ser nulo")
	@Size(min = 1, max = 255, message= "Descrição deve ter entre 1 a 255 caracter")
    private String descricao;

    @ApiModelProperty(value = "Status Order", position = 2)
    @NotNull(message = "Preço unitario do item não pode ser nulo")
    private BigDecimal preco_unitario;
    
    @ApiModelProperty(value = "Quantidade de Itens", position = 3)
    @NotNull(message = "Quantidade de item não pode ser nulo")
    private Long quantidade;
    
    @ApiModelProperty(value = "Código identificacao Order", position = 4)
    @NotNull(message = "Código identificação não pode ser nulo")
    private Long id_order_sale;

}
