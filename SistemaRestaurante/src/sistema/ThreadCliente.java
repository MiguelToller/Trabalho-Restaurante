/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import model.*;
import dao.*;
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
            
            // Processa o comando
            switch (comando) {
                case "CARDAPIO":
                    processarComandoCardapio(out);
                    break;
                case "PEDIDO":
                    processarComandoPedido(in, out);
                    break;
                default:
                    System.out.println("Comando desconhecido: " + comando);
                    out.writeObject("ERRO: Comando desconhecido");
                    break;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro na comunicação com o cliente: " + e.getMessage());
        }
    }
    
    private void processarComandoCardapio(ObjectOutputStream out) throws IOException {
        try {
            // Busca os dados no banco
            ItemDAO itemDAO = new ItemDAO();
            List<Item> itens = itemDAO.listarCardapioDisponivel();
            
            // Envia a lista de itens para o cliente
            out.writeObject(itens);
            out.flush();
            System.out.println("Enviados " + itens.size() + " itens para o cliente");
        } catch (Exception e) {
            System.out.println("Erro ao processar comando CARDAPIO: " + e.getMessage());
            out.writeObject("ERRO: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void processarComandoPedido(ObjectInputStream in, ObjectOutputStream out) throws IOException, ClassNotFoundException {
        try {
            // Recebe o objeto Pedido do cliente
            Pedido pedido = (Pedido) in.readObject();
            System.out.println("Pedido recebido com " + pedido.getCarrinho().getItens().size() + " itens");
            System.out.println("Valor total: R$ " + pedido.getValorTotal());
            
            // Salvar o pedido no banco de dados
            PedidoDAO pedidoDAO = new PedidoDAO();
            boolean salvou = pedidoDAO.inserir(pedido);
            
            // Enviar resposta ao cliente
            if (salvou) {
                out.writeObject("SUCESSO: Pedido registrado com sucesso!");
                System.out.println("Pedido registrado com sucesso no banco de dados");
            } else {
                out.writeObject("ERRO: Não foi possível registrar o pedido");
                System.out.println("Falha ao registrar o pedido no banco de dados");
            }
            out.flush();
            
        } catch (Exception e) {
            System.out.println("Erro ao processar comando PEDIDO: " + e.getMessage());
            out.writeObject("ERRO: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
