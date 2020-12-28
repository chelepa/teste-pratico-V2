
### Prerequisites

1. Lombok => https://projectlombok.org/download

2. Spring Tools => https://spring.io/tools

3. Ter MySql instalado na máquina ou um Container Docker com a imagem do MySql rodando

### Installation

1. Installation Lombok => https://dicasdejava.com.br/como-configurar-o-lombok-no-eclipse/

2. Clonar este repositorio

3. Criar um banco de dados no MySql

4. Configurar o banco de dados criado no passo anterior na aplicação Spring Boot

  * Abrir o aquivo o arquivo application.yml
  * Alterar as variaveis "MYSQL_DB", "MYSQL_USERNAME", "MYSQL_PASSWORD", conforme os dados do banco de dados criado anteriormente

5. Para ter acesso ao Swagger basta acessar: http://localhost:8080/swagger-ui.html#/

### Example

*Localhost:8080/v1/AdditionAndFines "POST"*
```json
{
    "daysOfDelay":"até 3 dias",
    "addition": 2,
    "additionTheDay": 0.1
}
```
