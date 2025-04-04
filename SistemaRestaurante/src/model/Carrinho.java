/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class Carrinho implements Serializable{
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
    
     public void adicionarItem(Item item) {
        if (item != null) {
            itens.add(item);
        }
    }
    
    public void removerItem(Item item) {
        if (item != null) {
            itens.remove(item);
        }
    }
    
    public boolean carrinhoVazio() {
        return itens.isEmpty();
    }
    
    public double calcularTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }
    
    public List<Item> getItens() {
        return itens;
    }
    
    public int quantidadeDeItens() {
        return itens.size();
    }
}
