/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Miguel
 */

import Conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.Carrinho;
import model.Item;

public class PedidoDAO {
    private Conexao conexao;
    private Connection conn;

    public PedidoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public boolean inserir(Pedido pedido) {
        try {
            conn.setAutoCommit(false); // Inicia uma transação

            // 1. Primeiro insere o carrinho
            String sqlCarrinho = "INSERT INTO Carrinho (id) VALUES (NULL)"; // Ajuste conforme necessário
            PreparedStatement stmtCarrinho = conn.prepareStatement(sqlCarrinho, Statement.RETURN_GENERATED_KEYS);
            stmtCarrinho.executeUpdate();

            // Obtém o ID gerado para o carrinho
            ResultSet rsCarrinho = stmtCarrinho.getGeneratedKeys();
            if (rsCarrinho.next()) {
                int idCarrinho = rsCarrinho.getInt(1);
                pedido.getCarrinho().setId(idCarrinho);

                // 2. Insere os itens no carrinho usando a tabela de relacionamento
                for (Item item : pedido.getCarrinho().getItens()) {
                    // Verifica se o item já existe na tabela Item e insere se necessário
                    // (Isso vai depender de como você está gerenciando os itens)
                    int idItem = item.getId(); // Se o item já tem ID
                    

                    // Insere na tabela de relacionamento ItemCarrinho
                    String sqlItemCarrinho = "INSERT INTO ItemCarrinho (idItem, idCarrinho, qtdItem) VALUES (?, ?, ?)";
                    PreparedStatement stmtItemCarrinho = conn.prepareStatement(sqlItemCarrinho);
                    stmtItemCarrinho.setInt(1, idItem);
                    stmtItemCarrinho.setInt(2, idCarrinho);
                    stmtItemCarrinho.setInt(3, 1); 
                    stmtItemCarrinho.executeUpdate();
                    stmtItemCarrinho.close();
                }

                // 3. Agora insere o pedido com o ID do carrinho
                String sqlPedido = "INSERT INTO Pedido (valorTotal, idCarrinho) VALUES (?, ?)";
                PreparedStatement stmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
                stmtPedido.setDouble(1, pedido.getValorTotal());
                stmtPedido.setInt(2, idCarrinho);
                stmtPedido.executeUpdate();

                // Obtém o ID gerado para o pedido
                ResultSet rsPedido = stmtPedido.getGeneratedKeys();
                if (rsPedido.next()) {
                    pedido.setId(rsPedido.getInt(1));
                }

                // Confirma a transação
                conn.commit();
                return true;
            }

            return false;
        } catch (SQLException ex) {
            try {
                // Em caso de erro, desfaz a transação
                conn.rollback();
            } catch (SQLException e) {
                System.out.println("Erro ao realizar rollback: " + e.getMessage());
            }
            System.out.println("Erro ao inserir pedido: " + ex.getMessage());
            ex.printStackTrace(); // Adicione isso para ver a pilha de erro completa
            return false;
        } finally {
            try {
                // Restaura o modo de autocommit
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Erro ao restaurar autocommit: " + e.getMessage());
            }
        }
    }
    
    public Pedido getPedido(int id) {
        String sql = "SELECT * FROM Pedido WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(id);
                pedido.setValorTotal(rs.getDouble("valorTotal"));

                // Criando um carrinho vazio
                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getInt("idCarrinho"));
                pedido.setCarrinho(carrinho);

                return pedido;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar pedido: " + ex.getMessage());
            return null;
        }
    }

    public List<Pedido> getTodosPedidos() {
        String sql = "SELECT * FROM Pedido";
        List<Pedido> listaPedidos = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setValorTotal(rs.getDouble("valorTotal"));

                // Criando um carrinho vazio
                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getInt("idCarrinho"));
                pedido.setCarrinho(carrinho);

                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar pedidos: " + ex.getMessage());
        }
        return listaPedidos;
    }

    public void editarPedido(Pedido pedido) {
        try {
            String sql = "UPDATE Pedido SET valorTotal = ?, idCarrinho = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, pedido.getValorTotal());
            stmt.setInt(2, pedido.getCarrinho().getId());
            stmt.setInt(3, pedido.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar pedido: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Pedido WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir pedido: " + ex.getMessage());
        }
    }
}
