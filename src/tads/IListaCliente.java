/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tads;


public interface IListaCliente {
    public boolean esVacia();
    public void agregarInicio(String nombre, String ci, int tel);
    public void agregarFinal( String nombre, String ci, int tel);
    public void agregarOrd( String nombre, String ci, int tel);
    // eliminar elementos
    public void borrarInicio(); 
    public void borrarFin();
    public void borrarElemento(String ci);
    
    //Mostrar elementos
    public void mostrarPedidos();
//buscar elemento
    public boolean buscarelemento(String nombre); 
     public boolean buscarelemento(int ci); 
    public nodoCliente obtenerElemento(String ci); 

    public String mostrar(); 
    public int cantElementos();    
}
