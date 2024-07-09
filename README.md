# Alura HUB

Projeto desenvolvido em Spring Boot, onde simulamos o back-end de um fórum com funcionalidades relacionadas a tópicos, possuindo também um controle de usuários utilizando TokenJWT.

### 📋 Pré-requisitos

- Java JDK Versão 17.
- intelliJ IDEA -> (https://www.jetbrains.com/pt-br/idea/)
- Mysql instalado. -> https://www.mysql.com/downloads/
- Insomnia -> https://insomnia.rest/download

## 🚀 Começando(Configurações do Projeto)
1. Mysql (sem variáveis de ambiente)
   - Acesse o arquivo application.properties e informe a url do banco de dados, usuário e senha.
   - Certifique-se de que a database já foi criada no seu mysql.
1.2 Mysql(com variáveis de ambiente)
   - Apenas defina quais as variáveis de ambiente serão usadas no projeto
   - Certifique-se de que a database já foi criada no seu mysql.
2. IntelliJ IDEA
   - Execute o projeto pela IDEA.
3. Mysql
   - Insira na tabela o comando abaixo para preencher os campo id, login, senha:
     insert into usuarios values(1, "usuario@teste", "123456")
     ps. Os valores podem ser alterados
4. Insomnia
 - Dispare uma requisição com "/login" para gerar o tokenJWT
 Importante -> Esse token será usado em todas as outras operações
5. Para começar, insira um usuário no formato:
   {
  "titulo": "",
  "mensagem": "",
  "curso": "",
  "autor": {
    "nome": "",
    "email": ""
  }
}

Pronto, tudo configurado, agora só é necessário manipular os tópicos restantes.

## ⚙️ Executando os testes

A api possui urls mapeadas para as seguintes operações.
- Autenticação usuário
- Cadastrar tópico
- Listar todos os tópicos
- Listar tópico específico pelo id
- Atualizar informações do tópico
- Deletar tópico

Powered by Luna, Arthur
