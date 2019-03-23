# **Descrição:** Atualiza uma order a partir do seu código de identificação.

**Description (en-US):** Update an order by the identifier code

## **Arquitetura**

**Nome da Tag:** order

**Path:** PUT /api/order/{id}

**Nome do Resource:** br.com.saulo.order.web.OrderResource

**Nome do Serviço:** br.com.saulo.order.servicos.OrderServico

**Nome do Método:** atualizarOrder

## **Requisição**

### **Nome do Request:** br.com.saulo.order.dto.persists.OrderPersist

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| id | Sim | Código identificador do order | store identifier | Path | Long  | 1 |
| data_confirmacao | Não | Data Confirmação Order | Order Confirmation Date | Query | Date | "2019-03-23" | |
| status | Sim | Status Order |  Status Order | Query | String | "CRIADO" | MAX(50)|


### **Exemplo Request:**
```
/api/order/1
```
```json
{
	"data_confirmacao": "2019-03-23",
    "status": "CRIADO"
}
```

## **Resposta**

### **Nome do Response:** br.com.saulo.order.dto.responses.OrderResponse

|Parâmetro | Descrição | Description (en-US) | Tipo de dados | Exemplo |
|---|---|---|:---:|---|
| id | Código identificador do order | order identifier | Long | 1 | 
| data_confirmacao | Data Confirmação Order | Order Confirmation Date | Date | "2019-03-23" | 
| status | Status Order | Status Order | String | "CRIADO" |

**Código status da resposta HTTP: 200 - Ok**

### **Exemplo Response:**
```json
{
    "id": 1,
	"data_confirmacao": "2019-03-23",
    "status": "CRIADO"
}
```

## **Documentos e referência**

**Tabelas:** order

## **Detalhes de implementação**

**Pré-requisitos**
* Existir order para o id informado
* Cumprir as validações de entrada

**Fluxo de execução**

1. Consultar a order pelo id
2. Verificar se a order não é nulo  
2.1. Se for nulo, retornar exceção de registro não encontrado  
3. Converter o objeto persist na entidade order
4. Salvar entidade
5. Converter a entidade no response
6. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| --- | --- | :---: | --- |
| Service | Quando atualiza a order | 200 | Ok |
| Service | Quando a order não existe | 404 | Not Found |
| DTO | Quando a status não está na lista pre definido|  400 | Bad Request |
| DTO | Quando o atributo status não existir | 400 | Bad Request |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|---|---|---|---|
| 404 | REGISTRO_NAO_ENCONTRADO | Nenhum registro encontrado para essa solicitação | No register found for this request |
