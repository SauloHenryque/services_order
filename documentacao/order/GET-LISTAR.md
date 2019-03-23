#**Descrição:** Lista os order existentes.

**Description (en-US):** List the existent order.

## **Arquitetura**

**Nome da Tag:** order

**Path:** GET /api/order

**Nome do Resource:** br.com.saulo.order.web.OrderResource

**Nome do Serviço:** br.com.saulo.order.servicos.OrderServico

**Nome do Método:** listarOrder

## **Requisição**

### **Nome do Request:** br.com.saulo.order.dto.request.OrderRequest

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| data_confirmacao | Não | Data Confirmação Order | Order Confirmation Date | Query | Date | "2019-03-23" | |
| status | Não | Status Order |  Status Order | Query | String | "CRIADO" | MAX(50)|

### **Exemplo Request:**
```
/api/order
/api/order?status=CRIADO
```

## **Resposta**

### **Nome do Response:** br.com.saulo.order.responses.OrderResponse

|Parâmetro | Descrição | Description (en-US) | Tipo de dados | Exemplo | Ordenação |
|---|---|---|:---:|---|:---:|
| id | Código identificador do order | order identifier | Long | 1 | X |
| data_confirmacao | Data Confirmação Order | Order Confirmation Date | Date | "2019-03-23" | 
| status | Status Order | Status Order | String | "CRIADO" |
| order_itens | itens do order | itens do order | List```<OrderItemResponse>``` | List```<OrderItemResponse>``` |


**Código status da resposta HTTP: 200 -  OK**

### **Exemplo Response:**
```json
{
  "id": 1,
  "data_confirmacao": "2019-03-23",
  "status": "CRIADO",
  "order_itens" : [
    {
      "id" : 1,
      "descricao" : "Descrição Teste",
      "preco_unitario" : "10.00",
	  "quantidade" : 10,
	  "id_order_sale" : 1 
    }
  ]
}
```

## **Documentos e referência**

**Tabelas:** order_sale, order_sale_item

## **Detalhes de implementação**

**Pré-requisitos**
* Existir order para o id informado

**Fluxo de execução**

1. Converter o objeto de request na entidade Exemplo
2. Realizar a consulta
3. Converter o page em um PageResponse
4. Retorna o PageResponse

## **Casos de teste**
| Onde | Teste | HTTP Status | Resultado |
| :---: | --- | :---: | --- |
| Service | Quando retorna order | 200 | OK |
| Service | Quando não encontra order informado no parâmetro | 200 | Ok |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|:---:|---|---|---|