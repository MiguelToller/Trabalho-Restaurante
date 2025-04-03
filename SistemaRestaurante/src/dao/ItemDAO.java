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
import model.Item;
/**
 *
 * @author Desktop
 */
public class ItemDAO {
    private Conexao conexao;
    private Connection conn;

    public ItemDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Item item) {
        String sql = "INSERT INTO Item (nome, categoria, preco, status, qtdEstoque, imagem) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getCategoria());
            stmt.setDouble(3, item.getPreco());
            stmt.setInt(4, item.getStatus());
            stmt.setInt(5, item.getQtdEstoque());
            stmt.setString(6, item.getImagem());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir item: " + ex.getMessage());
        }
    }

    public Item getItem(int id) {
        String sql = "SELECT * FROM Item WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setCategoria(rs.getString("categoria"));
                item.setPreco(rs.getDouble("preco"));
                item.setStatus(rs.getInt("status"));
                item.setQtdEstoque(rs.getInt("qtdEstoque"));
                item.setImagem(rs.getString("imagem"));
                
                return item;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar item: " + ex.getMessage());
            return null;
        }
    }
    
    public Item getItemPorNome(String nome) {
        String sql = "SELECT * FROM Item WHERE nome = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setCategoria(rs.getString("categoria"));
                item.setPreco(rs.getDouble("preco"));
                item.setStatus(rs.getInt("status"));
                item.setQtdEstoque(rs.getInt("qtdEstoque"));
                item.setImagem(rs.getString("imagem"));
                
                return item;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar item por nome: " + ex.getMessage());
        }
        return null;
    }

    public List<Item> getTodosItens() {
        String sql = "SELECT * FROM Item";
        List<Item> listaItens = new ArrayList<>();
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setCategoria(rs.getString("categoria"));
                item.setStatus(rs.getInt("status"));
                item.setPreco(rs.getDouble("preco"));
                item.setQtdEstoque(rs.getInt("qtdEstoque"));
                item.setImagem(rs.getString("imagem"));
                listaItens.add(item);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar itens: " + ex.getMessage());
        }
        return listaItens;
    }
    
    public void editarItem(Item item) {
        try {
            String sql = "UPDATE Item SET nome = ?, categoria = ?, preco = ?, status = ?, qtdEstoque = ?, "
                    + "imagem = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getCategoria());
            stmt.setDouble(3, item.getPreco());
            stmt.setInt(4, item.getStatus());
            stmt.setInt(5, item.getQtdEstoque());
            stmt.setString(6, item.getImagem());
            stmt.setInt(7, item.getId());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar item: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Item WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir item: " + ex.getMessage());
        }
    }
    
    public boolean isItemCadastrado(String nome) {
        String sql = "SELECT 1 FROM Item WHERE nome = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Erro ao verificar nome: " + ex.getMessage());
            return false;
        }
    }
    
    public List<Item> listarCardapioDisponivel() {
        List<Item> itens = new ArrayList<>();
        String sql = "SELECT nome, preco, imagem FROM item WHERE status = 1 ORDER BY categoria";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Item item = new Item();
                item.setNome(rs.getString("nome"));
                item.setPreco(rs.getDouble("preco"));
                
                itens.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar cardapio: " + e.getMessage());
        }
        return itens;
    }
}