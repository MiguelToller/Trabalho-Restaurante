
# Cadastro de Produto com Interface Gráfica (Java Swing + MySQL)

Este projeto é um exemplo didático utilizado na disciplina de **Projeto de Software**, com o objetivo de demonstrar um Sistema de Pedidos de um restaurante, destacando a interação entre o **Diagrama de Classes** e o **Diagrama de Sequência**.

---

## Funcionalidades Administrador

- Cadastrar Itens
- Editar Itens
- Excluir Itens
- Ver pedidos

---

## Funcionalidade Cliente

- Ver cardápio
  
  - Adicionar itens ao carrinho
    
  - Ver Pedidos
    - Finalizar Todos os Pedidos
    
  - Ver carrinho
    - Remover Item
    - Finalizar Pedido
    - Voltar ao Cardapio
    
---

## Diagrama de Classes

O diagrama de classes ilustra a estrutura do sistema, com a classe `Item` representando os produtos, e a classe `ItemDAO` sendo responsável pela persistência dos dados no banco. 
As classes `CadastrarItemForm`, `EditarItemForm` e `ExcluirItemForm` representam as interfaces gráficas que interagem com o usuário.

### Astah

![C - Cadastro de Produto](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Classe/CadastrarItem%20Diagram.png)

---

![C - Cadastro de Produto](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Classe/EditarItem%20Diagram.png)

---

![C - Cadastro de Produto](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Classe/ExcluirItem%20Diagram.png)

---

Ver pedidos

---

## Diagrama de Sequência Administrador

O diagrama de sequência descreve a interação entre os objetos ao longo do tempo, detalhando como as solicitações de cadastro, edição e exclusão de produtos fluem no sistema.

### CadastrarItem

![DS - Cadastrar Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/CadastrarItem%20Sequencia.png)

---
### EditarItem

![DS - Editar Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/EditarItem%20Sequencia.png)

---
### ExcluirItem

![DS - Excluir Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/ExcluirItem%20Sequencia.png)

---

## Diagrama de Sequência Cliente

Adicionar ao Carrinho

Ver Carrinho
- Remover item
  - BRANCH: NAO TEM ITEM
- Finalizar pedido
  - BRANCH: NAO TEM PEDIDO
- Voltar ao cardápio

Ver Pedidos

---

## Casos de Uso


![DCS - Casos de Uso](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Extra/Diagrama%20UseCase.png)

---

## Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/cadastro-produto-java.git
   ```
2. Compile os arquivos `.java`:
   ```bash
   javac *.java
   ```
3. Execute a interface gráfica:
   ```bash
   java ProdutoForm
   ```

---

## Objetivos Didáticos

- Compreender o uso prático de diagramas UML (classes e sequência)
- Aplicar a arquitetura orientada a objetos
- Trabalhar com persistência de dados
- Desenvolver interfaces gráficas com Swing

---

## Organização dos Arquivos

```
├───Descrições
├───Diagramas
│   ├───Diagramas Classe
│   ├───Diagramas Extra
│   └───Diagramas Sequencia
├───SistemaRestaurante
│   ├───build
│   │   └───classes
│   │       ├───Conexao
│   │       ├───dao
│   │       ├───model
│   │       └───sistema
│   ├───drivers
│   ├───nbproject
│   │   └───private
│   └───src
│       ├───Conexao
│       ├───dao
│       ├───model
│       └───sistema
└───SistemaRestauranteCliente
    ├───nbproject
    │   └───private
    └───src
        └───sistemarestaurantecliente
```

---

### Descrição dos Diretórios e Arquivos

**Modelos de Dados**  
Contêm as classes responsáveis pela representação dos dados no sistema.
- **`Item.java`**
- **`Carrinho.java`**
- **`ItemCarrinho.java`**
- **`Pedido.java`**

**Interfaces Gráficas (Administrador)**  
Interfaces gráficas responsáveis pela interação com o usuário para entrada, alteração, exclusão de dados e visualização de pedidos.
- **`CadastrarItem.form`**
- **`EditarItem.form`**
- **`ExcluirItem.form`**
- **`VerPedidos.form`**

**Interfaces Gráficas (Cliente)**  
Interfaces gráficas responsáveis por exibir o cardápio, o menu principal e a tela do carrinho.
- **`Cardapio.form`**
- **`TelaCarrinho.form`**
- **`TelaPedidos.form`**

**Acesso ao Banco de Dados**  
Classes responsáveis por interagir com o banco de dados.
- **`CarrinhoDAO.java`**
- **`ItemCarrinhoDAO.java`**
- **`ItemDAO.java`**
- **`PedidoDAO.java`**

**Arquivos de Configuração e Licença**  
- **`Banco.txt`** – Arquivo onde os dados são persistidos.
- **`LICENSE`** – Arquivo que contém a licença MIT do projeto.
- **`README.md`** – Este arquivo, que contém instruções e explicações sobre o projeto.

---


## Licença

Este projeto está licenciado sob os termos da licença MIT.  
Consulte o arquivo [LICENSE](LICENSE) para mais informações.

---

## Autores

**Luiz Miguel Toller Marconatto**  
Curso de Ciência da Computação – Universidade Franciscana (UFN)  

E-mail: luizmigueltoller@gmail.com  
GitHub: [@MiguelToller](https://github.com/MiguelToller)

---

**Eduardo Carvalho Ceretta**  
Curso de Ciência da Computação – Universidade Franciscana (UFN)  

E-mail: Duduceretta@gmail.com  
GitHub: [@Duduceretta](https://github.com/Duduceretta)

---

**Gabriel Machado Orling de Oliveira**  
Curso de Ciência da Computação – Universidade Franciscana (UFN)  

E-mail: gabrielorling1515@gmail.com  
GitHub: [@Gorling](https://github.com/Gorling)
