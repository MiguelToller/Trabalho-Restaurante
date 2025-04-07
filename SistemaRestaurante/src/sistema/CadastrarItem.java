/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema;

import dao.ItemDAO;
import java.awt.Image;
import model.Item;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.NoSuchFileException;
import javax.swing.JFrame;

/**
 *
 * @author Eduardo
 */
public class CadastrarItem extends javax.swing.JFrame {
    private String imagePath;
    /**
     * Creates new form CadastrarItem
     */
    public CadastrarItem() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblQtdEstoque = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtQtdEstoque = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<String>();
        cmbStatus = new javax.swing.JComboBox<String>();
        btnSalvar = new javax.swing.JButton();
        btnEscolher = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        lblNomeImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Cadastrar Item");

        lblNome.setText("Nome:");

        lblCategoria.setText("Categoria");

        lblPreco.setText("Preco:");

        lblStatus.setText("Status");

        lblQtdEstoque.setText("Quantidade Estoque:");

        lblImagem.setText("Imagem:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "comida", "bebida", "sobremesa" }));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "disponível", "Indisponível" }));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEscolher.setText("Escolher");
        btnEscolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNome))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblCategoria)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblPreco)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPreco))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblStatus)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(lblTitulo))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblImagem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblNomeImagem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEscolher))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblQtdEstoque)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtQtdEstoque))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageLabel)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtdEstoque)
                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImagem)
                    .addComponent(btnEscolher)
                    .addComponent(imageLabel)
                    .addComponent(lblNomeImagem))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparFormulario(){
        txtNome.setText("");
        txtPreco.setText("");
        lblNomeImagem.setText("");
        txtQtdEstoque.setText("");
        cmbCategoria.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
        imageLabel.setIcon(null);
        imagePath = "";
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Item i = new Item();
        ItemDAO iDAO = new ItemDAO();
    

    if (txtNome.getText().isBlank() || txtPreco.getText().isBlank() || 
            txtQtdEstoque.getText().isBlank() || imagePath == null || imagePath.isBlank()) {
        JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos", "ERRO", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    if (iDAO.isItemCadastrado(txtNome.getText().strip())) {
        JOptionPane.showMessageDialog(null, "Item já cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    try {
        
        i.setNome(txtNome.getText().strip());
        i.setCategoria((String) cmbCategoria.getSelectedItem());
        i.setPreco(Double.parseDouble(txtPreco.getText().trim()));
        String statusSelecionado = (String) cmbStatus.getSelectedItem();
        int statusBanco = statusSelecionado.equalsIgnoreCase("disponível") ? 1 : 0;
        i.setStatus(statusBanco);
        i.setQtdEstoque(Integer.parseInt(txtQtdEstoque.getText().trim()));

        String desktopPath = System.getProperty("user.home") + "/Desktop";
        File destinoPasta = new File(desktopPath + "/imagensRestaurante");

        if (!destinoPasta.exists()) {
            destinoPasta.mkdirs();
        }

        File nomeArquivo = new File(imagePath);
        String apenasNomeArquivo = nomeArquivo.getName();
        File destinoArquivo = new File(destinoPasta, apenasNomeArquivo);
        java.nio.file.Files.copy(nomeArquivo.toPath(), destinoArquivo.toPath(), 
                                java.nio.file.StandardCopyOption.REPLACE_EXISTING);

        imagePath = destinoArquivo.getAbsolutePath();
        i.setImagem(imagePath);


        iDAO.inserir(i);
        JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!", 
                                      "Item Cadastrado", JOptionPane.INFORMATION_MESSAGE);
        limparFormulario();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Insira dados numéricos válidos!", 
                                      "ERRO", JOptionPane.ERROR_MESSAGE);
    } catch (java.nio.file.NoSuchFileException e) {
        JOptionPane.showMessageDialog(null, "Arquivo de imagem não encontrado!", 
                                      "ERRO", JOptionPane.ERROR_MESSAGE);
    } catch (java.io.IOException e) {
        JOptionPane.showMessageDialog(null, "Erro ao copiar o arquivo de imagem!", 
                                      "ERRO", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage(), 
                                      "ERRO", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEscolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Imagem", "jpg", "jpeg", "png", "gif");
    fileChooser.setFileFilter(filter);
    
    int result = fileChooser.showOpenDialog(this);
    
    if (result == JFileChooser.APPROVE_OPTION) {
        try {
            File selectedFile = fileChooser.getSelectedFile();
            
            String fileName = selectedFile.getName();
            
            BufferedImage img = ImageIO.read(selectedFile);
            
            int iconWidth = 24;
            int iconHeight = 24;
            
            Image scaledImage = img.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            
            imageLabel.setIcon(scaledIcon);
            imageLabel.setSize(iconWidth, iconHeight);
            
            imagePath = selectedFile.getAbsolutePath();
            
            lblNomeImagem.setText(fileName);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar ou copiar a imagem: " + ex.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnEscolherActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEscolher;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeImagem;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQtdEstoque;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtdEstoque;
    // End of variables declaration//GEN-END:variables
}
