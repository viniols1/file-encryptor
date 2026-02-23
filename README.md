# File Encryptor AES-128 🔒

Este é um projeto desenvolvido em **Java** focado em segurança cibernética. A aplicação realiza a criptografia e descriptografia de arquivos utilizando o algoritmo **AES (Advanced Encryption Standard)** com chaves de 128 bits.

## 🚀 Funcionalidades

* **Geração de Chave Segura:** Transforma senhas comuns em hashes SHA-1 de 16 bytes para compatibilidade com AES.
* **Criptografia de Arquivos:** Lê arquivos de texto plano (`.txt`) e gera arquivos cifrados (`.enc`).
* **Descriptografia de Arquivos:** Recupera o conteúdo original de arquivos cifrados utilizando a chave correta.
* **Tratamento de Exceções:** Sistema robusto de captura de erros para evitar vazamento de dados ou interrupções abruptas.

## 🛠️ Tecnologias e Conceitos Utilizados

* **Java 17/21+**
* **JCE (Java Cryptography Extension):** Utilização das classes `Cipher` e `SecretKeySpec`.
* **Segurança:** Implementação de Padding PKCS5 e modo de operação ECB.
* **Manipulação de IO:** Uso de `java.nio.file` para leitura e escrita eficiente de arquivos no disco.
* **Encoding:** Utilização de Base64 para representação de dados cifrados.

## 📋 Como o Projeto foi Desenvolvido

O desenvolvimento seguiu uma abordagem modular e progressiva para garantir a integridade de cada etapa da segurança:

1.  **Criação do Motor de Chave:** Implementação de um método que padroniza qualquer senha para o tamanho exigido pelo padrão AES.
2.  **Lógica de Cifra:** Desenvolvimento do método de criptografia transformando strings em bytes embaralhados.
3.  **Lógica de Decifra:** Implementação da reversão dos dados para garantir que a informação possa ser recuperada.
4.  **Persistência em Disco:** Integração com o sistema de arquivos para proteger documentos reais, não apenas dados na memória RAM.

## ⚙️ Como Executar

1.  Certifique-se de ter o **JDK 17** ou superior instalado.
2.  Clone este repositório.
3.  Abra o projeto no **IntelliJ IDEA**.
4.  Crie um arquivo chamado `teste.txt` na raiz do projeto com algum conteúdo.
5.  Execute a classe `EncryptorApp.java`.
6.  O arquivo `arquivo_secreto.enc` será gerado com seus dados protegidos.

---
**Desenvolvido por Vinicius Oliveira - Desenvolvedor de Sistemas**