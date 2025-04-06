/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema;

import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
 import java.util.UUID;

/**
 *
 * @author laboratorio
 */
public class Cardapio extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private Carrinho carrinho;
    private List<Item> listaItens;
    private String uuidCliente;
    
    /**
     * Creates new form Cardapio
     */
    public Cardapio() {
        this.uuidCliente = UUID.randomUUID().toString();
        System.out.println("UUID da sessão do cliente: " + uuidCliente);
        
        initComponents();
        tableModel = (DefaultTableModel) tblCardapio.getModel();
        carrinho = new Carrinho();
        this.listaItens = new ArrayList<>();
        //Carrega o cardapio ao inicializar
        carregarCardapio();
        
        // Adicionar painel de controles
        //JPanel painelControles = new JPanel();
        
        //spinnerQuantidade = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        //painelControles.add(new JLabel("Quantidade:"));
        //painelControles.add(spinnerQuantidade);
        
        //JButton btnAdicionar = new JButton("Adicionar ao Carrinho");
        btnAdicionar.addActionListener(e -> adicionarAoCarrinho());
        //painelControles.add(btnAdicionar);

        //JButton btnVerCarrinho = new JButton("Ver Carrinho");
        btnVerCarrinho.addActionListener(e -> abrirTelaCarrinho());
        //painelControles.add(btnVerCarrinho);

        btnMeusPedidos.addActionListener(e -> {
            new TelaPedidos(this, uuidCliente);
        });
        
        // Adicionar painel ao layout
        //getContentPane().add(painelControles, BorderLayout.SOUTH);

        
        
        // Centralizar a janela
        //setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCardapio = new javax.swing.JTable();
        lblCardapio = new javax.swing.JLabel();
        painelControles = new javax.swing.JPanel();
        lblQuantidade = new javax.swing.JLabel();
        spinnerQuantidade = new javax.swing.JSpinner();
        btnAdicionar = new javax.swing.JButton();
        btnVerCarrinho = new javax.swing.JButton();
        btnMeusPedidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cardapio");
        setLocation(new java.awt.Point(0, 0));

        tblCardapio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tblCardapio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Preco", "Imagem"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCardapio);

        lblCardapio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCardapio.setText("Cardápio");

        painelControles.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblQuantidade.setText("Quantidade:");

        spinnerQuantidade.setName(""); // NOI18N

        btnAdicionar.setText("Adicionar ao Carrinho");

        btnVerCarrinho.setText("Ver Carrinho");

        btnMeusPedidos.setText("Meus Pedidos");
        btnMeusPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeusPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelControlesLayout = new javax.swing.GroupLayout(painelControles);
        painelControles.setLayout(painelControlesLayout);
        painelControlesLayout.setHorizontalGroup(
            painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelControlesLayout.createSequentialGroup()
                        .addComponent(lblQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMeusPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        painelControlesLayout.setVerticalGroup(
            painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(spinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdicionar)
                .addGap(18, 18, 18)
                .addComponent(btnVerCarrinho)
                .addGap(18, 18, 18)
                .addComponent(btnMeusPedidos)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(lblCardapio)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCardapio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMeusPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeusPedidosActionPerformed
        List<Item> itens = null;
        
        try {
            // OBS: Mudar localhost Para o ip do pc (Servidor)
            // Conecta ao servidor
            Socket socket = new Socket("localhost", 1234);
            
            // Cria streams para comunicação
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            // Envia comando para solicitar o cardápio
            out.writeObject("LISTAR_PEDIDOS");
            out.flush();
            
            // Recebe a lista de itens
            itens = (List<Item>) in.readObject();
            
            // Fecha os recursos
            in.close();
            out.close();
            socket.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                    "Erro ao conectar com o servidor: " + e.getMessage(), 
                    "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMeusPedidosActionPerformed

    // Método para buscar os itens do cardápio no servidor
    private List<Item> buscarCardapio() {
        List<Item> itens = null;
        
        try {
            // OBS: Mudar localhost Para o ip do pc (Servidor)
            // Conecta ao servidor
            Socket socket = new Socket("localhost", 1234);
            
            // Cria streams para comunicação
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            // Envia comando para solicitar o cardápio
            out.writeObject("CARDAPIO");
            out.flush();
            
            // Recebe a lista de itens
            itens = (List<Item>) in.readObject();
            
            // Fecha os recursos
            in.close();
            out.close();
            socket.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                    "Erro ao conectar com o servidor: " + e.getMessage(), 
                    "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
        }
        
        return itens;
    }

    // Exibe os itens do cardápio na tabela
    private void exibirItensNaTabela(List<Item> itens) {
        // Limpa a tabela
        tableModel.setRowCount(0);
        
        if (itens != null) {
            for (Item item : itens) {
                Object[] linha = {
                    item.getId(),
                    item.getNome(),
                    String.format("R$ %.2f", item.getPreco())
                };
                tableModel.addRow(linha);
            }
            
            tblCardapio.getColumnModel().getColumn(0).setMinWidth(0);
            tblCardapio.getColumnModel().getColumn(0).setMaxWidth(0);
            tblCardapio.getColumnModel().getColumn(0).setWidth(0);
            
            // Seleciona o primeiro item, se houver
            if (tableModel.getRowCount() > 0) {
                tblCardapio.setRowSelectionInterval(0, 0);
            }
        }
    }

    // Carregar dados do cardápio ao abrir a janela
    private void carregarCardapio() {
        SwingWorker<List<Item>, Void> worker = new SwingWorker<List<Item>, Void>() {
            @Override
            protected List<Item> doInBackground() throws Exception {
                return buscarCardapio();
            }

            @Override
            protected void done() {
                try {
                    List<Item> itens = get();
                    
                    if (itens != null) {
                        listaItens = itens;
                        exibirItensNaTabela(listaItens);
                    } else {
                        listaItens = new ArrayList<>(); // Evita que seja nula
                    }
                    //exibirItensNaTabela(itens);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Cardapio.this, 
                            "Erro ao carregar cardápio: " + e.getMessage(), 
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        
        worker.execute();
    }
    
    // Método para adicionar item ao carrinho
    private void adicionarAoCarrinho() {
        int linhaSelecionada = tblCardapio.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um item do cardápio!");
            return;
        }
        
        // Pegar os dados do item selecionado
        int id = (int) tableModel.getValueAt(linhaSelecionada, 0); // <- PEGA O ID CERTO
        String nome = (String) tableModel.getValueAt(linhaSelecionada, 1);
        String precoStr = (String) tableModel.getValueAt(linhaSelecionada, 2);
        precoStr = precoStr.replace("R$ ", "").replace(",", ".");
        double preco = Double.parseDouble(precoStr);
        
        // Obter a quantidade selecionada
        int quantidade = (int) spinnerQuantidade.getValue();
        
        // Buscar o item na lista de itens
        Item itemSelecionado = null;
        for (Item item : listaItens) {
            if (item.getId() == id) {
                itemSelecionado = item;
                break;
            }
        }
        
        if (itemSelecionado != null) {
            // Adicionar o item ao carrinho conforme a quantidade
            for (int i = 0; i < quantidade; i++) {
                carrinho.adicionarItem(itemSelecionado);
            }
            
            JOptionPane.showMessageDialog(this, quantidade + " x " + nome + " adicionado ao carrinho!");
        }
    }

    // Método para abrir a tela do carrinho
    private void abrirTelaCarrinho() {
        TelaCarrinho telaCarrinho = new TelaCarrinho(this, carrinho, this.uuidCliente);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cardapio form = new Cardapio();
                form.setVisible(true);
                form.carregarCardapio();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnMeusPedidos;
    private javax.swing.JButton btnVerCarrinho;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCardapio;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JPanel painelControles;
    private javax.swing.JSpinner spinnerQuantidade;
    private javax.swing.JTable tblCardapio;
    // End of variables declaration//GEN-END:variables
}
