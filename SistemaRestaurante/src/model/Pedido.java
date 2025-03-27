/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Eduardo
 */
public class Pedido {
    private int id;
    private double valorTotal;
    private Carrinho idCarrinho;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Carrinho getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Carrinho idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    
}
