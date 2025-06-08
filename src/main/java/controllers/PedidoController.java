package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import views.FormPedido;

public class PedidoController implements ActionListener, MouseListener {    
    
    private FormPedido vista;
    
    public PedidoController(FormPedido vista){
        this.vista = vista;
        vista.botonConfirmar.addActionListener(this);
    }
    
    public FormPedido getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.botonConfirmar){
            String nombre = vista.nombreMedicamento.getText().trim();
            String tipo = vista.tipoMedicamento.getSelectedItem() != null ? vista.tipoMedicamento.getSelectedItem().toString() : "";
            String cantidadMed = vista.cantidadMedicamento.getText().trim();
            String distribuidor = "";
            JCheckBox[] sucursales = {
                vista.sedePrincipal,
                vista.sedeSecundaria
            };
                     
            if (vista.cofarma.isSelected()) {
                distribuidor = vista.cofarma.getText();
            } else if (vista.cemefar.isSelected()) {
                distribuidor = vista.cemefar.getText();
            } else if (vista.empsephar.isSelected()) {
                distribuidor = vista.empsephar.getText();
            }
                    
            if (nombre.isEmpty() || !nombre.matches(".*[a-zA-Z0-9].*")) {
                JOptionPane.showMessageDialog(vista, "El nombre del medicamento debe contener caracteres alfanuméricos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            if (tipo.equals("Seleccione...") || tipo.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un tipo de medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Integer cantidad = Integer.valueOf(cantidadMed);
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (distribuidor.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un distribuidor.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            

            System.out.println("Di clic xd");
        }        
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
