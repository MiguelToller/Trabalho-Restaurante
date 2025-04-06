/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Eduardo
 */
public class ItemCarrinho implements Serializable{
    private int itemCarrinhoId;
    private Item idItem;
    private Carrinho idCarrinho;
    private int qtdItem;

    public int getItemCarrinhoId() {
        return itemCarrinhoId;
    }

    public void setItemCarrinhoId(int itemCarrinhoId) {
        this.itemCarrinhoId = itemCarrinhoId;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public Carrinho getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Carrinho idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }
    
    
}
