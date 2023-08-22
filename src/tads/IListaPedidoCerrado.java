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
public interface IListaPedidoCerrado {
    public boolean esVacia();
    public void agregarInicio(int nro,String nombre);
    public void agregarFinal(int nro,String nombre);
    public void agregarOrd(int nro, String nombre);
    // eliminar elementos
    public void borrarInicio(); 
    public void borrarFin();
    public void borrarElemento(int nro);
    
//buscar elemento
    public boolean buscarelemento(int nro); 
    public nodoPedidoCerrado obtenerElemento(int nro); 

    public String mostrar(); 
    public int cantElementos();    
}
