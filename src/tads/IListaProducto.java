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
public interface IListaProducto {
    public boolean esVacia();
    public void agregarInicio(int nro,String nombre, String descripcion);
    public void agregarFinal(int nro,String nombre,  String descripcion);
    public void agregarOrd(int nro, String nombre,  String descripcion);
    public void agregarInicioNodo(nodoProducto np);
    // eliminar elementos
    public void borrarInicio(); 
    public void borrarFin();
    public void borrarElemento(int nro);
    public void borrarElemento(String nombre);
    
//buscar elemento
    public boolean buscarelemento(int nro); 
    public boolean buscarelemento(String nombre); 
    public nodoProducto obtenerElemento(int nro); 

    public String mostrar(); 
    public int cantElementos();    
}
