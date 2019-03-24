# **Descrição:** Deleta uma order payment a partir do seu código de identificação.

**Description (en-US):** Delete an order payment by the identifier code

## **Arquitetura**

**Nome da Tag:** order-payment

**Path:** DELETE /api/order-payment/{id}

**Nome do Resource:** br.com.saulo.order.web.OrderPaymentResource

**Nome do Serviço:** br.com.saulo.order.servicos.OrderPaymentServico

**Nome do Método:** deletarOrderPayment

## **Requisição**

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| id | Não | Código identificador Order Payment | Order Item identifier | Path | Long  | 1 |

### **Exemplo Request:**
```
/api/order-payment/1
```
## **Resposta**

**Código status da resposta HTTP: 204 - No Content**

## **Documentos e referência**

**Tabelas:** order_sale_payment

## **Detalhes de implementação**

**Pré-requisitos**
* Existir order payment para o id informado

**Fluxo de execução**

1. Consultar a order payment pelo id
2. Verificar se a order payment não é nulo  
2.1. Se for nulo, retornar exceção de registro não encontrado  
3. Remover o registro da store
4. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| --- | --- | :---: | --- |
| Service | Quando deleta order payment | 204 | Ok |
| Service | Quando a order payment não existe | 404 | Not Found |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|---|---|---|---|
| 404 | REGISTRO_NAO_ENCONTRADO | Nenhum registro encontrado para essa solicitação | No register found for this request |