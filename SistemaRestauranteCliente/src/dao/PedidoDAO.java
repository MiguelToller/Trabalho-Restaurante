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

public class PedidoDAO {
    private Conexao conexao;
    private Connection conn;

    public PedidoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

       public boolean inserir(Pedido pedido) {
        String sql = "INSERT INTO Pedido (valorTotal, idCarrinho) VALUES (?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, pedido.getValorTotal());
            stmt.setInt(2, pedido.getCarrinho().getId());
            stmt.executeUpdate();

            // Obtendo o ID gerado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                pedido.setId(rs.getInt(1));
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir pedido: " + ex.getMessage());
            return false;
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
