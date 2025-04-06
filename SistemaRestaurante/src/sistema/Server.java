/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author laboratorio
 */
public class Server {
    private static final int PORTA = 1234;
    
    public static void main(String[] args) {
        try (ServerSocket servidorSocket = new ServerSocket(PORTA)) {
            System.out.println("Servidor iniciado na porta " + PORTA);
            System.out.println("Aguardando conexões...");
            
            while (true) {
                try {
                    // Aceita nova conexão
                    Socket clienteSocket = servidorSocket.accept();
                    System.out.println("Nova conexão: " + clienteSocket.getInetAddress());
                    
                    // Cria uma thread para atender este cliente
                    ThreadCliente handler = new ThreadCliente(clienteSocket);
                    handler.start();
                } catch (IOException ex) {
                    System.out.println("Erro ao aceitar conexão: " + ex.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
