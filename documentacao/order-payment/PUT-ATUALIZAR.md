# **Descrição:** Atualiza uma order payment a partir do seu código de identificação.

**Description (en-US):** Update an order payment by the identifier code

## **Arquitetura**

**Nome da Tag:** order-payment

**Path:** PUT /api/order-payment/{id}

**Nome do Resource:** br.com.saulo.order.web.OrderPaymentResource

**Nome do Serviço:** br.com.saulo.order.servicos.OrderPaymentServico

**Nome do Método:** atualizarOrderPayment

## **Requisição**

### **Nome do Request:** br.com.saulo.order.dto.persists.OrderPaymentPersist

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| id | Sim | Código identificador do order payment | order payment identifier | Path | Long  | 1 |
| status | Sim | Status Order Payment |  Status Order Payment| Query | String | "ABERTO" | MAX(50)|
| numero_cartao | Sim | Número Cartão | Number Card | Query | String | "123456789" | |
| data_pagamento | Sim | Data Pagamento Order Payment | Order Payment Date | Query | Date | "2019-03-23" | |
| id_order_sale | Sim | Código Identificação do Order | order identifier | Query | Long | 1 |


### **Exemplo Request:**
```
/api/order-payment/1
```
```json
{
	"status": "ABERTO",
    "numero_cartao": "123456789",
	"data_pagamento": "2019-03-23",
	"id_order_sale": 1
}
```

## **Resposta**

### **Nome do Response:** br.com.saulo.order.dto.responses.OrderPaymentResponse

|Parâmetro | Descrição | Description (en-US) | Tipo de dados | Exemplo |
|---|---|---|:---:|---|
| id | Código identificador do order payment| order payment identifier | Long | 1 | 
| status | Status Payment | Status Payment | String | "ABERTO" | 
| numero_cartao | Número Cartão | Number Card | String | "123456789" |
| data_pagamento | Data Pagamento Order Payment | Order Payment Date | Date | "2019-03-23" |
| id_order_sale | Código Identificação do Order | order identifier | Long | 1 |

**Código status da resposta HTTP: 200 - Ok**

### **Exemplo Response:**
```json
{
    "id": 1,
	"status": "ABERTO",
    "numero_cartao": "123456789",
	"data_pagamento": "2019-03-23",
	"id_order_sale": 1
}
```

## **Documentos e referência**

**Tabelas:** order_sale_payment

## **Detalhes de implementação**

**Pré-requisitos**
* Existir order payment para o id informado
* Cumprir as validações de entrada

**Fluxo de execução**

1. Consultar a order payment pelo id
2. Verificar se a order payment não é nulo  
2.1. Se for nulo, retornar exceção de registro não encontrado  
3. Converter o objeto persist na entidade order payment
4. Salvar entidade
5. Converter a entidade no response
6. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| --- | --- | :---: | --- |
| Service | Quando atualiza a order item | 200 | Ok |
| Service | Quando a order payment não existe | 404 | Not Found |
| DTO | Quando a status não está na lista pre definido|  400 | Bad Request |
| DTO | Quando o atributo status não existir | 400 | Bad Request |
| DTO | Quando o atributo numero_cartao não existir | 400 | Bad Request |
| DTO | Quando o atributo data_pagamento não existir | 400 | Bad Request |
| DTO | Quando o atributo id_order_sale não existir | 400 | Bad Request |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|---|---|---|---|
| 404 | REGISTRO_NAO_ENCONTRADO | Nenhum registro encontrado para essa solicitação | No register found for this request |
