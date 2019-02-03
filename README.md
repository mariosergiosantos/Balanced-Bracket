# Balanced-Bracket

Para os passos a seguir é necessário o docker

Para a execução da aplicação é necessário seguir os seguintes passos: <br>
- Realizar o clone do projeto em `git clone https://github.com/mariosergiosantos/Balanced-Bracket.git`
- Ir na pasta do projeto com `cd Balanced_Brackets`

## Executar
- `docker build -t ambiente_java .`
- docker run --name java -d ambiente_java
- docker exec -it balancedBrackets bash
- java BalancedBrackets