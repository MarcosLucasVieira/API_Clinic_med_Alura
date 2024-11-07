# Clínica Médica API

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
Siga as etapas abaixo para instalar o projeto localmente:

```bash
# Clone este repositório
git clone https://github.com/MarcosLucasVieira/API_Clinic_med_Alura.git

# Entre no diretório do projeto
cd API_Clinic_med_Alura

# Instale as dependências (recomendo usar a IDE IntelliJ para gerenciar as dependências do Maven)
# No IntelliJ, ao abrir o arquivo pom.xml, você verá uma opção para instalar automaticamente as dependências.
