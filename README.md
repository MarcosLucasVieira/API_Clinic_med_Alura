# Clinica Médica

## Descrição
Este projeto foi desenvolvido como parte do meu portfólio de back-end em Java utilizando Spring Boot. A API permite o gerenciamento de uma clínica médica, incluindo o cadastro de médicos, pacientes, enfermeiros e o agendamento de consultas. Foi implementada com diversas tecnologias e bibliotecas:

- **Spring Security**: Para segurança da API com autenticação JWT.
- **Lombok**: Facilita a injeção de dados e minimiza o código boilerplate.
- **Spring JPA**: Para a persistência de dados.
- **Flyway**: Para gerenciar migrations e versionamento do banco de dados.
- **Banco de dados**: MySQL, com validações e consultas gerenciadas pelo Spring JPA.
- **Ferramentas de requisição**: Postman e Insomnia foram utilizados para testar a API.

Cada funcionário da clínica (médicos, pacientes, enfermeiros) possui um endereço, gerenciado pela classe `Address`. O projeto foi desenvolvido na IDE IntelliJ.



## Índice
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
- [Funcionalidades](#funcionalidades)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Contato](#contato)

  ## Instalação
Instruções para instalar e configurar o projeto localmente.

```
# Clone este repositório
https://github.com/MarcosLucasVieira/API_Clinic_med_Alura.git

# Entre no diretório do projeto
cd projeto

# Instale as dependências (recomendo usar a ide InteliJ para instalar as depedências)
as dependências são instalar atráves do arquivo pom.xml, caso use o intelij no canto superior direito ao abri o arquivo pom.xml tera um indicativo para fazer
a instalação das depedências.
```

## Configuração
Antes de usar a API, configure o ambiente MySQL para criar o banco de dados:

Crie um banco de dados no MySQL com o nome clinic_api.
No arquivo application.properties, configure suas credenciais e outras propriedades da aplicação conforme abaixo:
```
spring.datasource.url=jdbc:mysql://localhost/clinic_api
Spring.datasource.username=<seu_usuário>
Spring.datasource.password=<sua_senha>


spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


server.error.include-stacktrace=never

api.security.token.secret=${JWT_SECRET:<sua_senha_jwt>}
 ```

## Uso
Uso
Após configurar o MySQL e as variáveis de ambiente, você pode executar a API e realizar requisições utilizando Postman ou Insomnia.

Funcionalidades Principais

1 - CRUD Completo:

Criação, Listagem, Atualização e Exclusão lógica de usuários (User), médicos (Medicals), enfermeiros (Nurses), pacientes (Patients) e consultas (Querys).

2 - Agendamento de Consultas:

Agendar uma consulta com um médico específico através do ID usando o método POST na URL "/query".

3 - Redirecionamento Automático:

Se o médico escolhido já estiver ocupado, o sistema selecionará automaticamente outro médico com a mesma especialização.

## funcionalidades

* Funcionalidade 1:  Criar, Listar, Atualizar, Deletar(exclusão lógica) das entidades(user, Medicals, Nurses, Patients, Querys). 
* Funcionalidade 2: Podemos Marca uma consulta com determinado médico, atráves do ID, e atráves do metodo Post na url ("/query")

* Funcionalidade 3: Quando marcamos uma consulta com um médico que já esta com hora marcada outro médico é escolhido aleatóriamente através da Especialização
passada no metodo

## Contribuição
Para contribuir com este projeto:

1 Faça um fork do repositório.
2 Crie uma branch para suas modificações (git checkout -b feature/nova-funcionalidade).
3 Faça commit das suas alterações (git commit -m 'Adiciona nova funcionalidade').
4 Envie para o repositório (git push origin feature/nova-funcionalidade).
5 Abra um Pull Request.

## Licença
Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.

## Contato
Desenvolvedor: Marcos Lucas Vieira
Email: marcosvieiradev23@gmail.com
GitHub: github.com/MarcosLucasVieira


