/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sistema;

import java.awt.BorderLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ItemCarrinho;
import model.Pedido;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Eduardo
 */
public class TelaPedidos extends javax.swing.JDialog {
    private JTable tabelaPedidos;
    private DefaultTableModel tableModel;
    private String uuidCliente;
    
    /**
     * Creates new form TelaPedidos
     * @param parent
     * @param uuidCliente
     */
    public TelaPedidos(JFrame parent, String uuidCliente) {
        super(parent, "Meus Pedidos", true);
        this.uuidCliente = uuidCliente;

        setSize(500, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        String[] colunas = {"ID", "Valor Total", "Status"};
        tableModel = new DefaultTableModel(colunas, 0);
        tabelaPedidos = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tabelaPedidos);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnFinalizarTodos = new JButton("Finalizar Todos os Pedidos");
        add(btnFinalizarTodos, BorderLayout.SOUTH);

        btnFinalizarTodos.addActionListener(e -> finalizarTodosPedidos());

        carregarPedidos();

        setVisible(true);
        initComponents();
    }

    private void carregarPedidos() {
        try {
            Socket socket = new Socket("localhost", 1234);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            out.writeObject("LISTAR_PEDIDOS");
            out.writeObject(uuidCliente);
            out.flush();

            List<Pedido> pedidos = (List<Pedido>) in.readObject();

            tableModel.setRowCount(0);
            for (Pedido p : pedidos) {
                tableModel.addRow(new Object[]{p.getId(), p.getValorTotal(), p.getStatus()});
            }

            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar pedidos.");
        }
    }
    
    private void finalizarTodosPedidos() {
        try {
            Socket socket = new Socket("localhost", 1234);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Solicita os pedidos antes de finalizar
            out.writeObject("LISTAR_PEDIDOS");
            out.writeObject(uuidCliente);
            out.flush();

            List<Pedido> pedidos = (List<Pedido>) in.readObject();

            double total = 0.0;
            StringBuilder resumo = new StringBuilder("Resumo dos Pedidos:\n");

            for (Pedido pedido : pedidos) {
                total += pedido.getValorTotal();

                // Abre nova conexão para buscar os itens de cada pedido
                Socket s2 = new Socket("localhost", 1234);
                ObjectOutputStream out2 = new ObjectOutputStream(s2.getOutputStream());
                ObjectInputStream in2 = new ObjectInputStream(s2.getInputStream());

                out2.writeObject("LISTAR_ITENS_PEDIDO");
                out2.writeObject(pedido.getId());
                out2.flush();

                List<ItemCarrinho> itens = (List<ItemCarrinho>) in2.readObject();
                in2.close();
                out2.close();
                s2.close();

                resumo.append("Pedido ").append(pedido.getId()).append(":\n");
                for (ItemCarrinho ic : itens) {
                    resumo.append("- ").append(ic.getIdItem().getNome())
                          .append(" x").append(ic.getQtdItem()).append("\n");
                }
            }

            resumo.append("\nTotal: R$ ").append(String.format("%.2f com os 10%% do garcom", total+(total*0.1)));
            JOptionPane.showMessageDialog(this, resumo.toString());
            
            try {
                String desktopPath = System.getProperty("user.home") + "/Desktop";
                
                File conta = new File(desktopPath + "/conta.txt");
                
                FileWriter writer = new FileWriter(conta);
                writer.write(resumo.toString());
            
                writer.close();
            
                System.out.println("Arquivo criado com sucesso na área de trabalho!");
            
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
            }
            
            Socket s3 = new Socket("localhost", 1234);
            ObjectOutputStream out3 = new ObjectOutputStream(s3.getOutputStream());
            ObjectInputStream in3 = new ObjectInputStream(s3.getInputStream());

            out3.writeObject("FINALIZAR_TODOS_PEDIDOS");
            out3.writeObject(uuidCliente);
            out3.flush();

            String resposta = (String) in3.readObject();
            in3.close();
            out3.close();
            s3.close();

            JOptionPane.showMessageDialog(this, resposta);
            
            carregarPedidos(); // Atualiza a tabela após finalização

            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao finalizar os pedidos.");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
