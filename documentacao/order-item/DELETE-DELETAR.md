# **Descrição:** Deleta uma order item a partir do seu código de identificação.

**Description (en-US):** Delete an order item by the identifier code

## **Arquitetura**

**Nome da Tag:** order-item

**Path:** DELETE /api/order-item/{id}

**Nome do Resource:** br.com.saulo.order.web.OrderItemResource

**Nome do Serviço:** br.com.saulo.order.servicos.OrderItemServico

**Nome do Método:** deletarOrderItem

## **Requisição**

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| id | Não | Código identificador Order Item | Order Item identifier | Path | Long  | 1 |

### **Exemplo Request:**
```
/api/order-item/1
```
## **Resposta**

**Código status da resposta HTTP: 204 - No Content**

## **Documentos e referência**

**Tabelas:** order_sale_item

## **Detalhes de implementação**

**Pré-requisitos**
* Existir order item para o id informado

**Fluxo de execução**

1. Consultar a order item pelo id
2. Verificar se a store não é nulo  
2.1. Se for nulo, retornar exceção de registro não encontrado  
3. Remover o registro da store
4. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| --- | --- | :---: | --- |
| Service | Quando deleta order item | 204 | Ok |
| Service | Quando a order item não existe | 404 | Not Found |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|---|---|---|---|
| 404 | REGISTRO_NAO_ENCONTRADO | Nenhum registro encontrado para essa solicitação | No register found for this request |