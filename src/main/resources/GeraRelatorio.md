# GeraRelatorio.java - Explicação

## Visão Geral Básica

Este código Java (`GeraRelatorio.java`) é responsável por gerar um arquivo CSV contendo informações de vendas. Ele recebe um objeto `Venda` e grava seus dados em um arquivo no formato CSV.

### Estrutura Esperada do Objeto Venda:
```java
private String nomeComprador;
private List<Produto> produtos = new ArrayList<>();
private LocalDate dataCompra;
```
### Saída Gerada (Exemplo):

```text
nome;data;valorTotal;
João Silva;15/05/2023;45.50;
pastel;2;5.00
coxinha;3;4.50
refri;1;6.00
```

### Explicação Detalhada

#### Funcionamento Principal

1. #### Localização do Arquivo:

   * O arquivo CSV é gerado em `C:\Temp\venda.csv`
   * Se o arquivo não existir, ele será criado
   * Se existir, novos dados serão adicionados ao final (modo append)

2. #### Estrutura do CSV:

    * **Cabeçalho:** `nome;data;valorTotal;` (escrito apenas se o arquivo estiver vazio)
    * **Dados da Venda:** linha com nome do comprador, data formatada e valor total
    * **Produtos:** linhas subsequentes listando cada produto com nome, quantidade e valor unitário
    * **Separador:** ponto-e-vírgula (`;`)
   
3. #### Formatação:
    * Data formatada como `dd/MM/yyyy`
    * Valores monetários com 2 casas decimais

### Fluxo de Execução

1. Verifica se o arquivo está vazio para escrever o cabeçalho

2. Formata a data da venda

3. Escreve os dados principais da venda:

    * Nome do comprador

    * Data formatada

    * Valor total (com 2 casas decimais)

4. Para cada produto na lista de produtos:

    * Escreve nome, quantidade e valor unitário

5. Adiciona uma linha em branco para separar vendas

6. Trata possíveis erros de IO

### Observações

* O arquivo é sempre aberto em modo append (`true`) no FileWrite)

* Cada venda é separada por linha em branco no arquivo

* O código não verifica se o diretório `C:\Temp` existe









