package org.example.gui.controllers;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class ImageIconRenderer extends DefaultTableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column)
    {
        JLabel label = ((JLabel)super.getTableCellRendererComponent(table,value,
                isSelected,hasFocus,row,column));
        label.setIcon(new ImageIcon((String)value));
        return label;
    }
}