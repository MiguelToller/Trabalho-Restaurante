/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema;

import dao.ItemDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.Item;

/**
 *
 * @author Eduardo
 */
public class EditarItem extends javax.swing.JFrame {
    String nomeSelecionado;
    int id;
    
    /**
     * Creates new form EditarItem
     */
    public EditarItem() {
        initComponents();
        preencherComboItens();
    
        // Adiciona um ActionListener ao combo box para detectar mudanças de seleção
        cmbItem.addActionListener(e -> carregarDadosItemSelecionado());
    
        // Carrega os dados do primeiro item selecionado inicialmente
        carregarDadosItemSelecionado();    
    }
    
    private void preencherComboItens() {
        ItemDAO iDAO = new ItemDAO();
        List<Item> ListaItens = iDAO.getTodosItensPorCategoria();
        
        for (Item i : ListaItens) {
            cmbItem.addItem(i.getNome()); 
        }
    }
    
    private void carregarDadosItemSelecionado() {
        nomeSelecionado = (String) cmbItem.getSelectedItem();
        if (nomeSelecionado != null) {
            ItemDAO iDAO = new ItemDAO();
            Item i = iDAO.getItemPorNome(nomeSelecionado);

            if (i != null) {
                id = i.getId();
                txtNome.setText(i.getNome());
                txtPreco.setText(String.valueOf(i.getPreco()));
                txtQtdEstoque.setText(String.valueOf(i.getQtdEstoque()));
                txtImagem.setText(i.getImagem());

                // Seleciona a categoria correta na cmbCategoria
                cmbCategoria.setSelectedItem(i.getCategoria());

                // Converte status (0 ou 1) para "disponivel" ou "indisponivel"
                if (i.getStatus() == 1) {
                    cmbStatus.setSelectedItem("disponivel");
                } else {
                    cmbStatus.setSelectedItem("indisponivel");
                }
            } else {
                System.out.println("Item não encontrado no banco de dados.");
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblItem = new javax.swing.JLabel();
        cmbItem = new javax.swing.JComboBox<>();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        lblQtdEstoque = new javax.swing.JLabel();
        txtQtdEstoque = new javax.swing.JTextField();
        lblImagem = new javax.swing.JLabel();
        txtImagem = new javax.swing.JTextField();
        btnEditarItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Editar Item");

        lblItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblItem.setText("Item:");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        lblPreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPreco.setText("Preco:");

        lblCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCategoria.setText("Categoria:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "comida", "bebida", "sobremesa" }));

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStatus.setText("Status:");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "disponivel", "indisponivel" }));

        lblQtdEstoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQtdEstoque.setText("Quantidade Estoque:");

        lblImagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblImagem.setText("URL Imagem:");

        btnEditarItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarItem.setText("Alterar Dados");
        btnEditarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbItem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(lblTitulo))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblImagem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtImagem))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblQtdEstoque)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblStatus)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblPreco)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPreco))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCategoria)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNome))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnEditarItem)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItem)
                    .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarItem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtdEstoque)
                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImagem)
                    .addComponent(txtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarItemActionPerformed
        if (id == 0) {
            System.out.println("Erro: Nenhum item foi selecionado.");
            return;
        }

        ItemDAO iDAO = new ItemDAO();
        if (txtNome.getText().isBlank()|| txtPreco.getText().isBlank()|| 
                txtQtdEstoque.getText().isBlank()|| txtImagem.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            //if (iDAO.isItemCadastrado(txtNome.getText()) == true) {
                //JOptionPane.showMessageDialog(null, "Item ja cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            //} else {
                try {
                    Item i = new Item();
                    i.setId(id);
                    i.setNome(txtNome.getText().strip());
                    i.setCategoria((String) cmbCategoria.getSelectedItem());
                    String statusSelecionado = (String) cmbStatus.getSelectedItem();
                    int statusBanco = statusSelecionado.equals("disponivel") ? 1 : 0;
                    i.setStatus(statusBanco);
                    i.setQtdEstoque(Integer.parseInt(txtQtdEstoque.getText()));
                    i.setImagem(txtImagem.getText());
                    i.setPreco(Double.parseDouble(txtPreco.getText()));

                    iDAO.editarItem(i);
        
                    cmbItem.removeAllItems();
                    preencherComboItens();
                    cmbItem.setSelectedItem(i.getNome());

                    JOptionPane.showMessageDialog(null, "Item editado com sucesso!", "Item Editado", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Insira dados numéricos válidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        //}
    }//GEN-LAST:event_btnEditarItemActionPerformed

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
            java.util.logging.Logger.getLogger(EditarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarItem;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbItem;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQtdEstoque;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtImagem;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtdEstoque;
    // End of variables declaration//GEN-END:variables
}
