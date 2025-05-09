/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema;

/**
 *
 * @author gabri
 */
public class menuADM extends javax.swing.JFrame {

    /**
     * Creates new form menuADM
     */
    public menuADM() {
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

        lblMenuRestaurante = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastrarADM = new javax.swing.JMenu();
        itemCadastrarADM = new javax.swing.JMenuItem();
        menuEditarADM = new javax.swing.JMenu();
        itemEditarADM = new javax.swing.JMenuItem();
        itemExcluirADM = new javax.swing.JMenuItem();
        menuVerPedidosADM = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRADOR");

        lblMenuRestaurante.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        lblMenuRestaurante.setText("MENU RESTAURANTE");

        menuCadastrarADM.setText("Cadastrar");

        itemCadastrarADM.setText("Cadastrar Itens");
        itemCadastrarADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarADMActionPerformed(evt);
            }
        });
        menuCadastrarADM.add(itemCadastrarADM);

        jMenuBar1.add(menuCadastrarADM);

        menuEditarADM.setText("Editar/Excluir");

        itemEditarADM.setText("Editar Itens");
        itemEditarADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarADMActionPerformed(evt);
            }
        });
        menuEditarADM.add(itemEditarADM);

        itemExcluirADM.setText("Excluir Itens");
        itemExcluirADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExcluirADMActionPerformed(evt);
            }
        });
        menuEditarADM.add(itemExcluirADM);

        jMenuBar1.add(menuEditarADM);

        menuVerPedidosADM.setText("Ver Pedidos");

        jMenuItem1.setText("Visualizar Pedidos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuVerPedidosADM.add(jMenuItem1);

        jMenuBar1.add(menuVerPedidosADM);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(lblMenuRestaurante)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenuRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCadastrarADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarADMActionPerformed
        CadastrarItem cadastroADM = new CadastrarItem();
        cadastroADM.setVisible(true);
    }//GEN-LAST:event_itemCadastrarADMActionPerformed

    private void itemEditarADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarADMActionPerformed
        EditarItem editarADM = new EditarItem();
        editarADM.setVisible(true);
    }//GEN-LAST:event_itemEditarADMActionPerformed

    private void itemExcluirADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExcluirADMActionPerformed
        ExcluirItem excluirADM = new ExcluirItem();
        excluirADM.setVisible(true);
    }//GEN-LAST:event_itemExcluirADMActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        VerPedidos verPedidosADM = new VerPedidos();
        verPedidosADM.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(menuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCadastrarADM;
    private javax.swing.JMenuItem itemEditarADM;
    private javax.swing.JMenuItem itemExcluirADM;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblMenuRestaurante;
    private javax.swing.JMenu menuCadastrarADM;
    private javax.swing.JMenu menuEditarADM;
    private javax.swing.JMenu menuVerPedidosADM;
    // End of variables declaration//GEN-END:variables
}
