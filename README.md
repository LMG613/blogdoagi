# 🚀 Automação de Testes QA - Blog do Agi

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.18-green.svg)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.15-brightgreen.svg)](https://cucumber.io/)
[![Allure](https://img.shields.io/badge/Allure_Report-2.25-yellow.svg)](https://qameta.io/)

Este repositório contém a solução do teste técnico para a vaga de QA. O projeto automatiza a validação da funcionalidade de pesquisa do [Blog do Agi](https://blogdoagi.com.br/).

## 🎯 Escopo dos Testes (BDD)
Os cenários foram escritos em Gherkin visando uma documentação viva e compreensível por todas as áreas do negócio:
1. Pesquisa com resultados exatos (Caminho Feliz).
2. Pesquisa sem resultados encontrados (Exceção).
3. Acionar pesquisa sem preencher termo (Busca Vazia).
4. Pesquisa com caracteres especiais (Validação de Input).

---

## 🛠️ Stack Tecnológica

* **Linguagem:** Java 17
* **Framework Web:** Selenium WebDriver com Native Selenium Manager
* **BDD & Test Engine:** Cucumber 7 + JUnit 5
* **Design Pattern:** Page Object Model (POM)
* **Gestão de Dependências:** Maven
* **Relatórios de Teste:** Allure Report
* **CI/CD:** GitHub Actions

---

## 🏗️ Arquitetura e Padrões Aplicados

Para garantir escalabilidade, manutenibilidade e segurança de execução, a arquitetura foi dividida logicamente:

* **Separação entre `src/main` e `src/test`:** O framework base (Driver, Actions, Pages) fica em `main`, isolado das regras de negócio e execução de testes que ficam em `test`.
* **Thread-Safe WebDriver:** Gerenciamento do browser utilizando `ThreadLocal` no `DriverFactory`, preparando o projeto para futuras execuções paralelas.
* **Configuração Externalizada:** Uso do `junit-platform.properties` e *System Properties* (`-Dheadless=true`) para evitar parametrização engessada no código-fonte.

---

## 🚀 Como Configurar e Executar

### Pré-requisitos
* **JDK 17** ou superior instalado e configurado nas variáveis de ambiente.
* **Maven** instalado e configurado.
* Navegador **Google Chrome** instalado.

### 1. Clonar o repositório e baixar dependências
```bash
git clone https://github.com/LMG613/blogdoagi.git
cd blogdoagi
mvn clean test