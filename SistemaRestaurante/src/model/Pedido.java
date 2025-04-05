/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class Pedido implements Serializable{
    private int id;
    private double valorTotal;
    private Carrinho carrinho;
    private String uuidCliente;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getUuidCliente() {
        return uuidCliente;
    }

    public void setUuidCliente(String uuidCliente) {
        this.uuidCliente = uuidCliente;
    }

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

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho idCarrinho) {
        this.carrinho = idCarrinho;
    }

    
}
