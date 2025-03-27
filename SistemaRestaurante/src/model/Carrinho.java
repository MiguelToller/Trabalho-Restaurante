/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class Carrinho {
    private int id;
    private List<Item> itens;
    
    public Carrinho(){
        this.itens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Adiciona um item no carrinho
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }
    
    // Remove um item no carrinho
    public void removerItem(Item item) {
        this.itens.remove(item);
    }
    
    // Calcula total do carrinho
    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();  // preco do item
        }
        return total;
    }
    
    // Retorna a lista de itens do carrinho
    public List<Item> getItens() {
        return this.itens;
    }
    
    // Verifica se o carrinho esta vazio
    public boolean carrinhoVazio() {
        return this.itens.isEmpty();
    }
}
