/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexao.Conexao;
import java.sql.*;
import model.Item;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {
    private Conexao conexao;
    private Connection conn;

    public CarrinhoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    // Criar um novo carrinho
    public int criarCarrinho() {
        String sql = "INSERT INTO Carrinho () VALUES ()";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Retorna o ID
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao criar carrinho: " + ex.getMessage());
        }
        return -1;
    }

    // Adicionar um item ao carrinho
    public void adicionarItemAoCarrinho(int idCarrinho, int idItem, int quantidade) {
        String sql = "INSERT INTO ItemCarrinho (itemCarrinhoId, idItem, idCarrinho, qtdItem) VALUES (NULL, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idItem);
            stmt.setInt(2, idCarrinho);
            stmt.setInt(3, quantidade);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar item ao carrinho: " + ex.getMessage());
        }
    }

    // Remover um item do carrinho
    public void removerItemDoCarrinho(int idCarrinho, int idItem) {
        String sql = "DELETE FROM ItemCarrinho WHERE idCarrinho = ? AND idItem = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCarrinho);
            stmt.setInt(2, idItem);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao remover item do carrinho: " + ex.getMessage());
        }
    }

    // Obter itens de um carrinho
    public List<Item> getItensDoCarrinho(int idCarrinho) {
        String sql = "SELECT i.id, i.nome, i.categoria, i.preco, i.status, i.qtdEstoque, i.imagem, ic.qtdItem "
                   + "FROM ItemCarrinho ic INNER JOIN Item i ON ic.idItem = i.id WHERE ic.idCarrinho = ?";
        List<Item> itens = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCarrinho);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setCategoria(rs.getString("categoria"));
                item.setPreco(rs.getDouble("preco"));
                item.setStatus(rs.getInt("status"));
                item.setQtdEstoque(rs.getInt("qtdEstoque"));
                item.setImagem(rs.getString("imagem"));
                itens.add(item);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao obter itens do carrinho: " + ex.getMessage());
        }
        return itens;
    }

    // Limpar o carrinho
    public void limparCarrinho(int idCarrinho) {
        String sql = "DELETE FROM ItemCarrinho WHERE idCarrinho = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCarrinho);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao limpar carrinho: " + ex.getMessage());
        }
    }
}
