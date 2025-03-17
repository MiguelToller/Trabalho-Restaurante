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

### **Branch-sequence**  
- O cliente pode continuar adicionando itens antes de confirmar o pedido.  

### **Exception-sequence**  
- Se não houver itens ativos no menu, o sistema exibe uma mensagem de erro.  

---

## **2. Alterar Carrinho**  

### **Ator**  
Cliente  

### **Pré-condição**  
O cliente deve ter um carrinho ativo com pelo menos um item.  

### **Pós-condição**  
O carrinho do cliente é atualizado no sistema.  

### **Base-sequence**  
1. O cliente acessa o carrinho.  
2. O cliente escolhe modificar o carrinho.  
3. O cliente adiciona ou remove itens.  
4. O sistema registra a alteração no carrinho.  

### **Branch-sequence**  
- Se o cliente quiser desfazer a alteração, ele pode cancelar antes de salvar.  

### **Exception-sequence**  
- Se o item removido não estiver no carrinho, o sistema exibe uma mensagem de erro.  

### **Nota**  
O carrinho pode ser modificado até que o cliente confirme o pedido.  

---

## **3. Confirmar Pedido**  

### **Ator**  
Cliente  

### **Pré-condição**  
O cliente deve ter um carrinho ativo com pelo menos um item.  

### **Pós-condição**  
O pedido é registrado no sistema e não pode mais ser alterado.  

### **Base-sequence**  
1. O cliente acessa a opção de "Confirmar Pedido".  
2. O sistema exibe um resumo do carrinho.  
3. O cliente confirma o pedido.  
4. O sistema registra o pedido como definitivo.  

### **Branch-sequence**  
- Se o cliente quiser voltar atrás antes de confirmar, ele pode cancelar a ação.  

### **Exception-sequence**  
- Se o carrinho estiver vazio, o sistema impede a confirmação e exibe uma mensagem de erro.  

### **Nota**  
Após a confirmação, o pedido não pode mais ser alterado, apenas cancelado ou finalizado.  

---

## **4. Solicitar Conta (Encerrar Pedido)**  

### **Ator**  
Cliente  

### **Pré-condição**  
O cliente deve ter um pedido confirmado.  

### **Pós-condição**  
O pedido é finalizado e o pagamento pode ser processado.  

### **Base-sequence**  
1. O cliente solicita a conta.  
2. O sistema calcula o valor total do pedido.  
3. O sistema exibe o valor. 
4. O cliente realiza o pagamento.  
5. O sistema registra o encerramento do pedido.  

### **Branch-sequence**  
- Se o cliente desejar revisar o valor antes do pagamento, ele pode visualizar o resumo da conta antes de prosseguir.

### **Exception-sequence**  
- Se o pagamento não for concluído, o sistema mantém o pedido pendente até a quitação.  

---

## **5. Adicionar Itens ao Menu**  

### **Ator**  
Administrador/Gerente  

### **Pré-condição**  
O sistema deve estar disponível para edição do menu.  

### **Pós-condição**  
O novo item é adicionado ao menu e fica disponível para os clientes.  

### **Base-sequence**  
1. O administrador acessa a opção de gerenciar o menu.  
2. O administrador seleciona "Adicionar Item".  
3. O sistema solicita informações do novo item (nome, descrição, preço, etc.).  
4. O administrador insere os dados e confirma.  
5. O sistema adiciona o novo item ao menu.  

### **Exception-sequence**  
- Se os dados inseridos forem inválidos ou estiverem incompletos, o sistema exibe um erro.  

---

## **6. Ajustar Itens do Menu**  

### **Ator**  
Administrador/Gerente  

### **Pré-condição**  
O sistema deve ter pelo menos um item cadastrado no menu.  

### **Pós-condição**  
As informações do item são atualizadas no menu.  

### **Base-sequence**  
1. O administrador acessa a opção de gerenciar o menu.  
2. O administrador escolhe um item existente.  
3. O sistema exibe as informações do item.  
4. O administrador altera os dados conforme necessário.  
5. O administrador confirma a alteração.  
6. O sistema salva as modificações no menu.  

### **Exception-sequence**  
- Se o item não existir ou não puder ser editado, o sistema exibe um erro.  

---

## **7. Ativar/Desativar Itens do Menu**  

### **Ator**  
Administrador/Gerente  

### **Pré-condição**  
O sistema deve ter pelo menos um item cadastrado no menu.  

### **Pós-condição**  
O item é ativado ou desativado, alterando sua disponibilidade para os clientes.  

### **Base-sequence**  
1. O administrador acessa a opção de gerenciar o menu.  
2. O administrador seleciona um item existente.  
3. O sistema exibe o status atual do item (ativo/inativo).  
4. O administrador altera o status do item (ativar/desativar).  
5. O sistema salva a alteração.  

### **Branch-sequence**  
- Se um item for desativado, ele não poderá mais ser adicionado ao carrinho dos clientes.  

### **Exception-sequence**  
- Se o item não existir, o sistema exibe um erro.  

---
