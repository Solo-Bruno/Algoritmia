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
public class ListaCliente implements IListaCliente {
    nodoCliente primero;
    nodoCliente ultimo;
    int cantidad;

    public ListaCliente() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
    }

    public nodoCliente getPrimero() {
        return primero;
    }

    public void setPrimero(nodoCliente primero) {
        this.primero = primero;
    }

    public nodoCliente getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoCliente ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean esVacia() {
        return this.getPrimero() == null;
    }

    @Override
    public void agregarInicio( String nombre, String ci, int tel) {
        nodoCliente nuevo = new nodoCliente(nombre, ci, tel);
        if (this.esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.siguiente = primero;   //1
            primero = nuevo;             //2

        }
        cantidad = cantidad + 1;
    }

    @Override
    public void agregarFinal( String nombre, String ci, int tel) {
        
        nodoCliente nuevo = new nodoCliente( nombre, ci, tel);
        if (!this.esVacia()) {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        } else {
            primero = nuevo;
            ultimo = nuevo;
        }
        cantidad = cantidad + 1;
    }

    @Override
    public void agregarOrd(String nombre, String ci, int tel) {
  
        if (this.esVacia() ||Integer.parseInt(ci) < Integer.parseInt(this.primero.getCi())) {
            this.agregarInicio(nombre, ci, tel);
        } else {
            if (Integer.parseInt(ci) > Integer.parseInt(this.ultimo.getCi())) {
                this.agregarFinal(nombre, ci, tel);
            } else {
                nodoCliente aux = this.getPrimero();
                nodoCliente nuevo = new nodoCliente( nombre, ci, tel);
                while (aux.siguiente != null &&Integer.parseInt(ci) > Integer.parseInt(aux.getCi())) {
                    aux = aux.siguiente;
                }
                nuevo.siguiente = aux.siguiente;   //1
                aux.siguiente = nuevo;             //2
                this.cantidad = this.cantidad + 1;
            }
        }
    }

    @Override
    public void borrarInicio() {

        if (!this.esVacia()) {
            this.setPrimero(this.primero.getSiguiente());
            this.cantidad = this.cantidad - 1;
        }

    }

    @Override
    public void borrarFin() {

        nodoCliente aux = this.getPrimero();
        if (!this.esVacia()) {
            if (this.cantidad == 1) {
                this.primero = null;
                this.ultimo = null;
            } else {
                while (aux.siguiente.siguiente != null) {
                    aux = aux.siguiente;
                }
                aux.setSiguiente(null);
                ultimo = aux;
            }

            this.cantidad = this.cantidad - 1;
        }
    }

    @Override
    public void borrarElemento(String ci) {

        
        boolean borrado = false;
        if (this.buscarelemento(Integer.parseInt(ci))) {
            nodoCliente aux = this.getPrimero();
            if (this.primero.ci.compareTo(ci) == 0){
                this.borrarInicio();
                 borrado = true;
            } else {
                if (this.ultimo.ci.compareTo(ci) == 0) {
                    this.borrarFin();
                    borrado = true;
                } else {
                    while (aux.getSiguiente() != null && aux.getSiguiente() != this.getUltimo() && !borrado) {
                        if (aux.siguiente.ci.compareTo(ci) == 0) {
                            aux.siguiente = aux.siguiente.siguiente;
                            borrado = true;
                            this.cantidad = this.cantidad - 1;
                        }
                        aux = aux.getSiguiente();

                    }

                }

            }

        }

    }

    // lista no esta ordenada    


    @Override
    public nodoCliente obtenerElemento(String ci) {
        
        
        nodoCliente elemento = null;
        nodoCliente aux = this.getPrimero();
        while (aux != null && elemento == null) {
            if (aux.getCi().compareTo(ci) == 0) {
                elemento = aux;
            }
            aux = aux.siguiente;

        }
        return elemento;
    }


    @Override
    public String mostrar() {
   
        String valorString = " ";
        nodoCliente aux = this.getPrimero();

        while (aux != null) {
            valorString = valorString + aux.getCi() + " - " + aux.getNombre();
             valorString = valorString + "\n";
            aux = aux.getSiguiente();
        }

        return valorString;
    }

    @Override
    public int cantElementos() {
        return  this.cantidad;             
    }

    @Override
    public boolean buscarelemento(String nombre) {
        
        boolean encontrado = false;
        nodoCliente aux = this.getPrimero();

        while (aux != null && !encontrado) {
            if (aux.getNombre().compareTo(nombre) == 0) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }

        return encontrado;
    }

    @Override
    public boolean buscarelemento(int ci) {
        boolean encontrado = false;
        nodoCliente aux = this.getPrimero();

        while (aux != null && !encontrado) {
            if (Integer.parseInt(aux.getCi()) == ci) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }

        return encontrado;
    }

    @Override
    public void mostrarPedidos() {
        
        String valorString = " ";
        nodoCliente aux = this.getPrimero();

        while (aux != null) {
            System.out.println(aux.getCop().mostrar());
            aux = aux.getSiguiente();
        }

     
        
    }

  
}
