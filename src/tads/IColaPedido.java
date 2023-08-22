/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tads;

/**
 *
 * @author Rafael
 */
// en una cola se agrega en un extremo y se quita en el otro
public interface IColaPedido {
    boolean esVacia();
    boolean esllena();
    boolean estaProducto(String nombre);
    void encolar(String ci);    // agregar inicio o agregar fin
    void encolarNodo(nodoPedido np);
    void desencolar(); // agregar inicio o agregar fin
    nodoPedido frente();
    nodoPedido fondo();
    boolean estado(); // Busca si tiene pedidos abiertos
    int PedidosCerrados(); // Devuelbe la cantidad de pedidos con estados cerrado
}
