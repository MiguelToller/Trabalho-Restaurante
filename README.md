
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

## Diagrama de Domínio

O Diagrama de Domínio é uma representação conceitual que descreve as principais entidades do sistema e seus relacionamentos.

![C - Dominio](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Extra/Diagrama%20Classe.png)

---

## Diagrama de Caso de Uso

![C - Caso de Uso](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Extra/Diagrama%20UseCase.png)

---

# **Use Case Description**  

## **1. Adicionar itens ao Carrinho**  

### **Ator**  
Cliente  

### **Pré-condição**  
O menu deve estar disponível com itens ativos.  

### **Pós-condição**  
Os itens selecionados são adicionados ao carrinho do cliente.  

### **Base-sequence**  
1. O cliente acessa o menu.  
2. O cliente seleciona um ou mais itens.  
3. O cliente adiciona os itens ao carrinho.  
4. O sistema registra os itens no carrinho.  

### **Nota**  
- O cliente pode continuar adicionando itens antes de confirmar o pedido.  

---

## **2. Remover Itens do Carrinho**  

### **Ator**  
Cliente  

### **Pré-condição**  
O cliente deve ter um carrinho ativo com pelo menos um item.  

### **Pós-condição**  
O carrinho do cliente é atualizado no sistema.  

### **Base-sequence**  
1. O cliente acessa o carrinho.  
2. O cliente escolhe remover item.  
3. O cliente remove itens.  
4. O sistema registra a alteração no carrinho.

### **Branch-sequence**  
Se o item para remover for null ele exibe uma mensagem de erro.

### **Nota**  
O carrinho pode ser modificado até que o cliente confirme o pedido.  

---

## **3. Fazer Pedido**  

### **Ator**  
Cliente  

### **Pré-condição**  
O cliente deve ter um carrinho ativo com pelo menos um item.  

### **Pós-condição**  
O pedido é registrado no sistema e não pode mais ser alterado.  

### **Base-sequence**  
1. O cliente acessa a opção de "Fazer Pedido".  
2. O sistema exibe um resumo do carrinho.  
3. O cliente confirma o pedido.  

### **Branch-sequence**  
- Se o carrinho estiver vazio, o sistema impede a confirmação e exibe uma mensagem de erro.  

### **Nota**  
Após a confirmação, o pedido não pode mais ser alterado, apenas finalizado.  

---

## **4. Finalizar Pedidos**  

### **Ator**  
Cliente  

### **Pré-condição**  
O cliente deve ter um pedido confirmado.  

### **Pós-condição**  
O pedido é finalizado e o pagamento pode ser processado.  

### **Base-sequence**  
1. O cliente finaliza o pedido.  
2. O sistema calcula o valor total do pedido.  
3. O sistema exibe o valor. 
4. O cliente realiza o pagamento.  
5. O sistema registra o encerramento do pedido.
6. [Include] Emitir Ticket: O sistema emite o ticket com todos os itens no pedido e o valor total a pagar.

### **Branch-sequence**  
Se o cliente não tiver feito nenhum pedido, o sistema exibe uma mensagem de erro.

### **Nota**  
Após a confirmação, Adicionar 10% ao valor total para o garçom.

---

## **5. Cadastrar Itens**  

### **Ator**  
Administrador/Gerente  

### **Pré-condição**  
O sistema deve estar disponível para edição do menu.  

### **Pós-condição**  
O novo item é adicionado ao menu e fica disponível para os clientes.  

### **Base-sequence**  
1. O administrador acessa o menu do administrador.
2. O administrador seleciona "Cadastrar Item".  
3. O sistema solicita informações do novo item (nome, descrição, preço, etc.).  
4. O administrador insere os dados e confirma.  
5. O sistema adiciona o novo item ao menu.  

### **Exception-sequence**  
- Se os dados inseridos forem inválidos ou estiverem incompletos, o sistema exibe um erro.  

---

## **6. Alterar Itens**  

### **Ator**  
Administrador/Gerente  

### **Pré-condição**  
O sistema deve ter pelo menos um item cadastrado no menu.  

### **Pós-condição**  
As informações do item são atualizadas no menu.  

### **Base-sequence**  
1. O administrador acessa o menu do administrador.
2. O administrador escolhe um item existente.  
3. O sistema exibe as informações do item.  
4. O administrador altera os dados conforme necessário.  
5. O administrador confirma a alteração.  
6. O sistema salva as modificações no menu.  

---

## **7. Excluir Itens**

### **Ator**  
Administrador/Gerente 

### **Pré-condição**  
O sistema deve ter pelo menos um item cadastrado no menu.  

### **Pós-condição**  
O item é excluído.

### **Base-sequence**  
1. O administrador acessa o menu do administrador.  
2. O administrador seleciona um item existente.  
3. O administrador clica em excluir item.
4. O sistema salva a alteração.  

---

## Diagrama de Classes Administrador

Este diagrama representa a estrutura das funcionalidades voltadas ao Administrador, onde a classe `Item` modela os produtos e a classe `Pedido` representa os pedidos realizados. 
As classes `ItemDAO` e `PedidoDAO` são responsáveis pela persistência desses dados no banco de dados.  Já as interfaces gráficas `CadastrarItemForm`, `EditarItemForm`, `ExcluirItemForm` e `VerPedidosForm` possibilitam a interação do administrador com o sistema.

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

Este diagrama representa a estrutura das funcionalidades voltadas ao cliente, como visualização do cardápio, carrinho de compras e realização de pedidos.

### Cliente

![C - Cliente](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Classe/Cliente%20Diagram.png)


## Diagrama de Sequência Administrador

Estes diagramas mostram a interação entre os objetos para as ações do Administrador, nas funcionalidades de cadastro, edição, exclusão e visualização de pedidos.

### Cadastrar Item

![DS - Cadastrar Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Admin/CadastrarItem%20Sequencia.png)

---
### Editar Item

![DS - Editar Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Admin/EditarItem%20Sequencia.png)

---
### Excluir Item

![DS - Excluir Item](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Admin/ExcluirItem%20Sequencia.png)

---

### Ver Pedidos

![DS - Ver Pedidos](https://github.com/MiguelToller/Trabalho-Restaurante/blob/main/Diagramas/Diagramas%20Sequencia/Admin/VerPedidos%20Sequencia.png)

---

## Diagrama de Sequência Cliente

Estes diagramas mostram a interação entre os objetos para as ações do cliente, como adicionar e remover itens do carrinho, realizar e finalizar pedidos.

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

## Como Executar (Administrador)

1. Clone este repositório:
   ```bash
   git clone https://github.com/MiguelToller/Trabalho-Restaurante.git
   ```
2. Crie o Banco MySQL e adicione o ``Banco.txt``.

3. Altere (se necessário) a versão do JDK de acordo com sua máquina

4. Adicione o mysql-connector em Libraries

5. Execute o Servidor:
    ```bash
   Server.java
   ```
6. Execute a interface gráfica:
   ```bash
   menuADM.form (Administrador)
   ```
   
---

## Como Executar (Cliente)

1. Clone este repositório:
   ```bash
   git clone https://github.com/MiguelToller/Trabalho-Restaurante.git
   ```
2. Altere (se necessário) a versão do JDK de acordo com sua máquina

3. Adicione o mysql-connector em Libraries

4. Mudar o ip para conectar ao servidor

5. Adicionar pasta de imagens

6. Execute a interface gráfica:
   ```bash
   Cardapio.form (Cliente)
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
│       ├───Admin
│       └───Cliente
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
        ├───Conexao
        ├───dao
        ├───model
        └───sistema
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
