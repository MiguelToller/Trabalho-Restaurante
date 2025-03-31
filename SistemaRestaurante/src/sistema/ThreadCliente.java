/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import model.Item;
import dao.ItemDAO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author laboratorio
 */
public class ThreadCliente extends Thread{
    private Socket clienteSocket;
    
    public ThreadCliente(Socket socket) {
        this.clienteSocket = socket;
    }
    
    @Override
    public void run() {
        try {
            // Cria streams para comunicação com o cliente
            ObjectOutputStream out = new ObjectOutputStream(clienteSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clienteSocket.getInputStream());
            
            // Lê o comando enviado pelo cliente
            String comando = (String) in.readObject();
            System.out.println("Comando recebido: " + comando);
            
            // Processa o comando - neste caso só temos um comando: "CARDAPIO"
            if (comando.equals("CARDAPIO")) {
                // Busca os dados no banco
                ItemDAO itemDAO = new ItemDAO();
                List<Item> itens = itemDAO.listarCardapioDisponivel();
                
                // Envia a lista de itens para o cliente
                out.writeObject(itens);
                out.flush();
                System.out.println("Enviados " + itens.size() + " itens para o cliente");
            }
            
            // Fecha recursos
            out.close();
            in.close();
            clienteSocket.close();
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro na comunicação com o cliente: " + e.getMessage());
        }
    }
}
