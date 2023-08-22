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
public class ListaPedidoCerrado implements IListaPedidoCerrado {
     nodoPedidoCerrado primero;
    nodoPedidoCerrado ultimo;
    int cantidad;

    public ListaPedidoCerrado() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
    }

    public nodoPedidoCerrado getPrimero() {
        return primero;
    }

    public void setPrimero(nodoPedidoCerrado primero) {
        this.primero = primero;
    }

    public nodoPedidoCerrado getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoPedidoCerrado ultimo) {
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
    public void agregarInicio(int nro, String nombre) {
        nodoPedidoCerrado nuevo = new nodoPedidoCerrado(nro,nombre);
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
    public void agregarFinal(int nro, String nombre) {
        
        nodoPedidoCerrado nuevo = new nodoPedidoCerrado(nro, nombre);
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
    public void agregarOrd(int nro, String nombre) {
  
        nodoPedidoCerrado nuevo = new nodoPedidoCerrado(nro, nombre);
        if (this.esVacia() || nro < this.getPrimero().getNro()) {
            this.agregarInicio(nro,nombre);
        } else {
            if (nro > this.getUltimo().getNro()) {
                this.agregarFinal(nro,nombre);
            } else {
                nodoPedidoCerrado aux = this.getPrimero();
                while (aux.siguiente != null && nro > aux.siguiente.nro) {
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

        nodoPedidoCerrado aux = this.getPrimero();
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
    public void borrarElemento(int nro) {

        boolean valorbooleano = false;
        boolean borrado = false;
        if (this.buscarelemento(nro)) {
            nodoPedidoCerrado aux = this.getPrimero();
            if (nro == this.primero.getNro()) {
                this.borrarInicio();
                borrado = true;
            } else {
                if (nro == this.ultimo.getNro()) {
                    this.borrarFin();
                    borrado = true;
                } else {
                    while (aux.getSiguiente() != null && aux.getSiguiente() != this.getUltimo() && !borrado) {
                        if (aux.siguiente.getNro() == nro) {
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
    public boolean buscarelemento(int nro) {

        boolean encontrado = false;
        nodoPedidoCerrado aux = this.getPrimero();

        while (aux != null && !encontrado) {
            if (aux.nro == nro) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }

        return encontrado;
    }

    @Override
    public nodoPedidoCerrado obtenerElemento(int nro) {
        
        
        nodoPedidoCerrado elemento = null;
        nodoPedidoCerrado aux = this.getPrimero();
        while (aux != null && elemento == null) {
            if (aux.getNro() == nro) {
                elemento = aux;
            }
            aux = aux.siguiente;

        }
        return elemento;
    }


    @Override
    public String mostrar() {
   
        String valorString = " ";
        nodoPedidoCerrado aux = this.getPrimero();

        while (aux != null) {
            valorString = valorString + aux.getNro() + " - " + aux.getNombre()+" - ";
            aux = aux.getSiguiente();
        }

        return valorString;
    }

    @Override
    public int cantElementos() {
        return  this.cantidad;             
    }

  
}
