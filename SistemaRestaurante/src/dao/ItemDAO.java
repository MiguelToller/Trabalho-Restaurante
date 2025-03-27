/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
        String sql = "SELECT * FROM Item WHERE idItem = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Item i = new Item();
                i.setId(id);
                i.setNome(rs.getString("nome"));
                i.setCategoria(rs.getString("categoria"));
                i.setEstado(rs.getString("estado"));
                return i;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar item: " + ex.getMessage());
            return null;
        }
    }

    public List<Item> getTodosItens() {
        String sql = "SELECT * FROM Item";
        List<Item> listaItens = new ArrayList<>();
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Item i = new Item();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setCategoria(rs.getString("categoria"));
                i.setStatus(rs.getInt("status"));
                i.setPreco(rs.getDouble("preco"));
                i.setQtdEstoque(rs.getInt("qtdEstoque"));
                i.setImagem(rs.getString("imagem"));
                listaItens.add(i);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar itens: " + ex.getMessage());
        }
        return listaItens;
    }
    
    
    public void editarItem(Item item) {
        try {
            String sql = "UPDATE Item SET nome=?, categoria = ?, estado = ? WHERE idItem = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getCategoria());
            stmt.setString(3, item.getEstado());
            stmt.setInt(4, item.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar item: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Item WHERE idItem = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir item: " + ex.getMessage());
        }
    }
}