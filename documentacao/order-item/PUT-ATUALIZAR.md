# **Descrição:** Atualiza uma order item a partir do seu código de identificação.

**Description (en-US):** Update an order item by the identifier code

## **Arquitetura**

**Nome da Tag:** order-item

**Path:** PUT /api/order-item/{id}

**Nome do Resource:** br.com.saulo.order.web.OrderItemResource

**Nome do Serviço:** br.com.saulo.order.servicos.OrderItemServico

**Nome do Método:** atualizarOrderItem

## **Requisição**

### **Nome do Request:** br.com.saulo.order.dto.persists.OrderItemPersist

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| id | Sim | Código identificador do order item | store item identifier | Path | Long  | 1 |
| descricao | Sim | Descrição do Item | Item Description | Query | String | "Descrição Teste" | |
| preco_unitario | Sim | Preço do Item |  Item Price | Query | Decimal | "10.00" | |
| quantidade | Sim | Quantidade do Item | Item Quantity | Query | Long | 10 |
| id_order_sale | Sim | Código Identificação do Order | order identifier | Query | Long | 1 |


### **Exemplo Request:**
```
/api/order-item/1
```
```json
{
	"descricao": "Descrição Teste",
    "preco_unitario": 10.00,
	"quantidade": 10,
	"id_order_sale": 1
}
```

## **Resposta**

### **Nome do Response:** br.com.saulo.order.dto.responses.OrderItemResponse

|Parâmetro | Descrição | Description (en-US) | Tipo de dados | Exemplo |
|---|---|---|:---:|---|
| id | Código identificador do order item| order item identifier | Long | 1 | 
| descricao | Descrição do Item | Item Description | String | "Descrição Teste" | 
| preco_unitario | Preço do Item | Item Price | Decimal | "10.00" |
| quantidade | Quantidade do Item | Item Quantity | Long | 10 |
| id_order_sale | Código Identificação do Order | order identifier | Long | 1 |

**Código status da resposta HTTP: 200 - Ok**

### **Exemplo Response:**
```json
{
    "id": 1,
	"descricao": "Descrição Teste",
    "preco_unitario": 10.00,
	"quantidade": 10,
	"id_order_sale": 1
}
```

## **Documentos e referência**

**Tabelas:** order_sale_item

## **Detalhes de implementação**

**Pré-requisitos**
* Existir order item para o id informado
* Cumprir as validações de entrada

**Fluxo de execução**

1. Consultar a order item pelo id
2. Verificar se a order item não é nulo  
2.1. Se for nulo, retornar exceção de registro não encontrado  
3. Converter o objeto persist na entidade order item
4. Salvar entidade
5. Converter a entidade no response
6. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| --- | --- | :---: | --- |
| Service | Quando atualiza a order item | 200 | Ok |
| Service | Quando a order item não existe | 404 | Not Found |
| Service | Quando a order não existe | 404 | Not Found |
| DTO | Quando a quantidade de caracteres do atributo descricao for maior que 255 |  400 | Bad Request |
| DTO | Quando o atributo descricao não existir | 400 | Bad Request |
| DTO | Quando o atributo cep não existir | 400 | Bad Request |
| DTO | Quando o atributo preco_unitario não existir | 400 | Bad Request |
| DTO | Quando o atributo quantidade não existir | 400 | Bad Request |
| DTO | Quando o atributo id_order_sale não existir | 400 | Bad Request |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|---|---|---|---|
| 404 | REGISTRO_NAO_ENCONTRADO | Nenhum registro encontrado para essa solicitação | No register found for this request |
