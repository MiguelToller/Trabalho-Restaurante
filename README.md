
# Cadastro de Produto com Interface Gráfica (Java Swing + MySQL)

Este projeto é um exemplo didático desenvolvido na disciplina de **Projeto de Software**, com o objetivo de demonstrar a implementação de um sistema de pedidos para restaurante. O projeto enfatiza a utilização de **diagramas UML**, especialmente **Diagrama de Classes** e **Diagrama de Sequência**, integrados ao desenvolvimento com Java Swing e persistência em banco de dados MySQL.

---

## Funcionalidades Administrador

- Cadastrar Itens
- Editar Itens
- Excluir Itens
- Ver pedidos

---

## Funcionalidades Cliente

- Adicionar itens ao carrinho
- Realiza Pedidos
- Finaliza Pedidos
- Remove Itens do Carrinho
    
---

## Diagrama de Classes Administrador

O diagrama de classes representa a estrutura do sistema, onde a classe `Item` modela os produtos e a classe `Pedido` representa os pedidos realizados.  
As classes `ItemDAO` e `PedidoDAO` são responsáveis pela persistência desses dados no banco de dados.  
Já as interfaces gráficas `CadastrarItemForm`, `EditarItemForm`, `ExcluirItemForm` e `VerPedidosForm` possibilitam a interação do administrador com o sistema.

### Cadastrar Item

![C - Cadastrar Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Classe/CadastrarItem%20Diagram.png)

---
### Editar Item

![C - Editar Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Classe/EditarItem%20Diagram.png)

---
### Excluir Item

![C - Excluir Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Classe/ExcluirItem%20Diagram.png)

---
### Ver Pedidos

![C - Ver pedidos](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Classe/VerPedidos%20Diagram.png)

---

## Diagrama de Classes Cliente

Descricao:

### Cliente

![C - Cliente](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Classe/Cliente%20Diagram.png)


## Diagrama de Sequência Administrador

O diagrama de sequência descreve a interação entre os objetos ao longo do tempo, detalhando como as solicitações de cadastro, edição e exclusão de produtos fluem no sistema.

### Cadastrar Item

![DS - Cadastrar Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Admin/CadastrarItem%20Sequencia.png)

---
### Editar Item

![DS - Editar Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Admin/EditarItem%20Sequencia.png)

---
### Excluir Item

![DS - Excluir Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Admin/ExcluirItem%20Sequencia.png)

---

## Diagrama de Sequência Cliente

O diagrama de sequência descreve a interação entre os objetos ao longo do tempo, detalhando como é adicionado itens ao carrinho, realização de pedidos, finalização de pedidos e remoção de itens do carrinho.

### Adicionar Itens ao Carrinho

![DS - Adicionar Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Cliente/AdicionarItem.png)

---

### Fazer Pedido

![DS - Fazer Pedido](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Cliente/FazerPedido.png)

---

### Finalizar Pedidos

![DS - Finalizar Pedidos](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Cliente/FinalizarPedidos.png)

---

### Remover Item do Carrinho

![DCS - Remover Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Cliente/RemoverItem.png)

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
