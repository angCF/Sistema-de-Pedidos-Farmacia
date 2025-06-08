package com.unir.pedidos_farmacia;

import controllers.PedidoController;
import views.FormPedido;

public class Pedidos_Farmacia {

    public static void main(String[] args) {
        FormPedido formulario = new FormPedido();
        PedidoController controlador = new PedidoController(formulario);
        controlador.getVista().setVisible(true);
    }
}
