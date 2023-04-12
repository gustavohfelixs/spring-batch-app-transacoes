App Transacoes - Java Batch
===========================

**Pré-requisitos**
- JAVA 8
- Maven 3.3+
- IDE de sua preferência

### Introdução
**Spring Batch** é um framework desenhado para trabalhar
com batchs ou seja em lotes, trabalhar com grandes e repetitivos
volumes de dado. 

"_O processamento
em lote é o método que os computadores usam para concluir 
periodicamente trabalhos de dados repetitivos de alto volume_" [¹](https://aws.amazon.com/pt/what-is/batch-processing/#:~:text=Batch%20processing%20is%20the%20method,run%20on%20individual%20data%20transactions.) - Aws site

Neste caso iremos ler um arquivo em CSV e inputar esses dados a
uma base de dados (H2 neste caso)

**Este é um projeto Básico de Spring Batch - Bons estudos!**

## Hands on

#### Como utilizar o projeto?
1. Baixe o arquivo para seu computador como zip
2. extraia o arquivo zip
3. Import para sua IDE como projeto Maven

### Instale as dependências
`mvn clean install`

### Clean and Build
`mvn clean package`

### Executar projeto
`mvn spring-boot:run` <br>Ou<br> `java -jar ./target/App-0.0.1-SNAPSHOT.jar` <br><br> Você também pode rodar de a classe **AppApplication** em sua IDE que está no caminho `com.br.gfelix.App.AppApplication`