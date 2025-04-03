/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.*;
import java.awt.Component;
import java.awt.Image;

/**
 *
 * @author laboratorio
 */
public class ImageRenderer extends DefaultTableCellRenderer{
    @Override
        public Component getTableCellRendererComponent(JTable table, Object value, 
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                setIcon((ImageIcon) value);
                setText(null); // Remove o texto, exibe apenas a imagem
            } else {
                setIcon(null);
                setText("Imagem não encontrada");
            }
            setHorizontalAlignment(CENTER); // Centraliza a imagem
            return this;
        }
}
