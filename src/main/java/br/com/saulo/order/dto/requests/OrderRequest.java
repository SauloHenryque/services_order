package br.com.saulo.order.dto.requests;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "Request Order")
public class OrderRequest implements Serializable{
	
	 private static final long serialVersionUID = 3589073168426445707L;

	 @ApiModelProperty(value = "Identificação Order", position = 1)
	 private Long id;
	 
	 @ApiModelProperty(value = "Data confirmação Order", position = 2)
	 private LocalDate data_confirmacao;

	 @ApiModelProperty(value = "Status Order", position = 3)
	 private String status;

}
