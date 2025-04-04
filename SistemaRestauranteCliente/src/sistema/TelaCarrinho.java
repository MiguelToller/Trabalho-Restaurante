/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sistema;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author Eduardo
 */
public class TelaCarrinho extends javax.swing.JDialog {
    private DefaultTableModel tableModel;
    private JTable tabelaCarrinho;
    private JLabel lblTotal;
    private Carrinho carrinho;
    private Cardapio telaCardapio;
    
    /**
     * Creates new form TelaCarrinho
     * @param parent
     * @param carrinho
     */
    public TelaCarrinho(Cardapio parent, Carrinho carrinho) {
        super(parent, "Carrinho de Compras", true);
        this.carrinho = carrinho;
        this.telaCardapio = parent;
        
        // Configuração da janela
        setSize(500, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        
        // Criar a tabela
        String[] colunas = { "ID", "Nome", "Quantidade", "Subtotal" };
        tableModel = new DefaultTableModel(colunas, 0);
        tabelaCarrinho = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaCarrinho);
        
        tabelaCarrinho.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaCarrinho.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaCarrinho.getColumnModel().getColumn(0).setWidth(0);
        
        // Painel de botões
        JPanel painelBotoes = new JPanel();
        JButton btnRemover = new JButton("Remover Item");
        JButton btnFinalizar = new JButton("Finalizar Pedido");
        JButton btnVoltar = new JButton("Voltar ao Cardápio");
        
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnFinalizar);
        painelBotoes.add(btnVoltar);
        
        // Painel de total
        JPanel painelTotal = new JPanel();
        lblTotal = new JLabel("Total: R$ 0,00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 18));
        painelTotal.add(lblTotal);
        
        // Adicionar componentes à janela
        add(scrollPane, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
        add(painelTotal, BorderLayout.NORTH);
        
        // Carregar itens do carrinho na tabela
        atualizarTabela();
        
        // Ações dos botões
        btnRemover.addActionListener(e -> removerItem());
        btnFinalizar.addActionListener(e -> finalizarPedido());
        btnVoltar.addActionListener(e -> dispose());
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarTabela() {
        tableModel.setRowCount(0);

        // Agrupar itens por ID
        List<Item> itens = carrinho.getItens();
        // Usar um HashMap para agrupar os itens por ID
        Map<Integer, Integer> quantidadePorItem = new HashMap<>();
        Map<Integer, Double> subtotalPorItem = new HashMap<>();
        Map<Integer, String> nomePorItem = new HashMap<>();

        // Contar quantidades e calcular subtotais
        for (Item item : itens) {
            int id = item.getId();
            quantidadePorItem.put(id, quantidadePorItem.getOrDefault(id, 0) + 1);
            subtotalPorItem.put(id, subtotalPorItem.getOrDefault(id, 0.0) + item.getPreco());
            nomePorItem.put(id, item.getNome());
        }

        // Adicionar linhas na tabela
        for (Integer id : quantidadePorItem.keySet()) {
            Object[] linha = {
                id,                           // ID (oculto)
                nomePorItem.get(id),          // Nome
                quantidadePorItem.get(id),    // Quantidade
                subtotalPorItem.get(id)       // Subtotal
            };
            tableModel.addRow(linha);
        }

        atualizarTotal();
    }
    
    private void atualizarTotal() {
        double total = carrinho.calcularTotal();
        lblTotal.setText(String.format("Total: R$ %.2f", total));
    }
    
    private void removerItem() {
        int linhaSelecionada = tabelaCarrinho.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idSelecionado = (int) tableModel.getValueAt(linhaSelecionada, 0); // ID está na coluna 0
            int quantidadeAtual = (int) tableModel.getValueAt(linhaSelecionada, 2); // Qtd na coluna 2

            // Encontrar o item no carrinho para remover
            Item itemParaRemover = null;
            for (Item item : carrinho.getItens()) {
                if (item.getId() == idSelecionado) {
                    itemParaRemover = item;
                    break;
                }
            }

            if (itemParaRemover != null) {
                // Remove um item com esse ID do carrinho
                carrinho.removerItem(itemParaRemover);

                // Atualiza a tabela com os novos dados
                atualizarTabela();
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                    "Selecione um item para remover!", 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void finalizarPedido() {
        if (carrinho.carrinhoVazio()) {
            JOptionPane.showMessageDialog(this, 
                    "Carrinho vazio! Adicione itens antes de finalizar.", 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Perguntar confirmação
        int resposta = JOptionPane.showConfirmDialog(this, 
                "Deseja finalizar o pedido no valor de " + 
                String.format("R$ %.2f", carrinho.calcularTotal()) + "?", 
                "Confirmar Pedido", JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            // Enviar pedido para o servidor
            enviarPedido();
            
            // Limpar carrinho
            while (!carrinho.carrinhoVazio()) {
                carrinho.removerItem(carrinho.getItens().get(0));
            }
            
            // Fechar janela
            JOptionPane.showMessageDialog(this, 
                    "Pedido enviado com sucesso!", 
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
    
    private void enviarPedido() {
        try {
            // Conecta ao servidor
            Socket socket = new Socket("localhost", 1234);
            
            // Cria streams para comunicação
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            // Cria um objeto de pedido
            model.Pedido pedido = new model.Pedido();
            pedido.setCarrinho(carrinho);
            pedido.setValorTotal(carrinho.calcularTotal());
            
            // Envia comando para fazer pedido
            out.writeObject("PEDIDO");
            out.flush();
            
            // Envia o pedido
            out.writeObject(pedido);
            out.flush();
            
            // Recebe confirmação
            String resposta = (String) in.readObject();
            
            // Fecha recursos
            in.close();
            out.close();
            socket.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                    "Erro ao enviar pedido: " + e.getMessage(), 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
