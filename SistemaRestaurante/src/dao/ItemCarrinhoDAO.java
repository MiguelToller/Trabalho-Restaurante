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
import model.ItemCarrinho;
import model.Item;
import model.Carrinho;

public class ItemCarrinhoDAO {
    private Conexao conexao;
    private Connection conn;

    public ItemCarrinhoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(ItemCarrinho itemCarrinho) {
        String sql = "INSERT INTO ItemCarrinho (idItem, idCarrinho, qtdItem) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, itemCarrinho.getIdItem().getId()); // Supondo que Item tem um getId()
            stmt.setInt(2, itemCarrinho.getIdCarrinho().getId()); // Supondo que Carrinho tem um getId()
            stmt.setInt(3, itemCarrinho.getQtdItem());
            stmt.executeUpdate();

            // Obtendo o ID
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                itemCarrinho.setItemCarrinhoId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir item no carrinho: " + ex.getMessage());
        }
    }

    public ItemCarrinho getItemCarrinho(int id) {
        String sql = "SELECT * FROM ItemCarrinho WHERE itemCarrinhoId = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ItemCarrinho itemCarrinho = new ItemCarrinho();
                itemCarrinho.setItemCarrinhoId(id);
                itemCarrinho.setQtdItem(rs.getInt("qtdItem"));

                // Criando objetos Item e Carrinho vazios
                Item item = new Item();
                item.setId(rs.getInt("idItem"));
                itemCarrinho.setIdItem(item);

                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getInt("idCarrinho"));
                itemCarrinho.setIdCarrinho(carrinho);

                return itemCarrinho;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar item do carrinho: " + ex.getMessage());
            return null;
        }
    }

    public List<ItemCarrinho> getTodosItensCarrinho() {
        String sql = "SELECT * FROM ItemCarrinho";
        List<ItemCarrinho> listaItensCarrinho = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ItemCarrinho itemCarrinho = new ItemCarrinho();
                itemCarrinho.setItemCarrinhoId(rs.getInt("itemCarrinhoId"));
                itemCarrinho.setQtdItem(rs.getInt("qtdItem"));

                // Criando objetos Item e Carrinho vazios para representar a relação
                Item item = new Item();
                item.setId(rs.getInt("idItem"));
                itemCarrinho.setIdItem(item);

                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getInt("idCarrinho"));
                itemCarrinho.setIdCarrinho(carrinho);

                listaItensCarrinho.add(itemCarrinho);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar itens do carrinho: " + ex.getMessage());
        }
        return listaItensCarrinho;
    }

    public void editarItemCarrinho(ItemCarrinho itemCarrinho) {
        try {
            String sql = "UPDATE ItemCarrinho SET idItem = ?, idCarrinho = ?, qtdItem = ? WHERE itemCarrinhoId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, itemCarrinho.getIdItem().getId());
            stmt.setInt(2, itemCarrinho.getIdCarrinho().getId());
            stmt.setInt(3, itemCarrinho.getQtdItem());
            stmt.setInt(4, itemCarrinho.getItemCarrinhoId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar item do carrinho: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM ItemCarrinho WHERE itemCarrinhoId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir item do carrinho: " + ex.getMessage());
        }
    }
    
    public List<ItemCarrinho> listarPorPedido(int idPedido) {
        List<ItemCarrinho> lista = new ArrayList<>();
        String sql = "SELECT * FROM itemcarrinho WHERE idCarrinho = ?";

        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ItemCarrinho ic = new ItemCarrinho();
                ic.setItemCarrinhoId(rs.getInt("itemCarrinhoId"));
                ic.setQtdItem(rs.getInt("qtdItem"));

                // Criando o objeto Item
                Item item = new Item();
                item.setId(rs.getInt("idItem"));

                // Aqui você pode buscar o nome real do item usando ItemDAO, se quiser:
                // ItemDAO itemDAO = new ItemDAO();
                // Item itemCompleto = itemDAO.buscarPorId(item.getId());
                // item.setNome(itemCompleto.getNome());

                ic.setIdItem(item);

                // Criando o objeto Carrinho
                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getInt("idCarrinho"));
                ic.setIdCarrinho(carrinho);

                // Buscar nome do item
                ItemDAO itemDAO = new ItemDAO();
                Item itemCompleto = itemDAO.getItem(item.getId());
                item.setNome(itemCompleto.getNome());
                
                lista.add(ic);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar itens do pedido: " + e.getMessage());
        }

        return lista;
    }
}
