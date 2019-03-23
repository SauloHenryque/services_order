#**Descrição:** Cadastra order.

**Description (en-US):** Save order.

## **Arquitetura**

**Nome da Tag:** order

**Path:** POST /api/order

**Nome do Resource:** br.com.saulo.order.web.OrderResource

**Nome do Serviço:** br.com.saulo.order.servicos.AddressServico

**Nome do Método:** salvarOrder

## **Requisição**

### **Nome do Request:** br.com.saulo.order.dto.persists.OrderPersist

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| data_confirmacao | Não | Data Confirmação Order | Order Confirmation Date | Query | Date | "2019-03-23" | |
| status | Sim | Status Order |  Status Order | Query | String | "CRIADO" | MAX(50)|


### **Exemplo Request:**
```
/api/order
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

**Código status da resposta HTTP: 201 - Created**

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

**Fluxo de execução**

1. Converter o objeto de persist na entidade order
2. Salvar entidade
3. Converter a entidade no response
4. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| :---: | --- | :---: | --- |
| Service | Quando cadastra order | 201 | Ok |
| DTO | Quando a status não está na lista pre definido|  400 | Bad Request |
| DTO | Quando o atributo status não existir | 400 | Bad Request |

