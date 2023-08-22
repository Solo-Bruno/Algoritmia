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
public class ListaProducto implements IListaProducto {
    nodoProducto primero;
    nodoProducto ultimo;
    int cantidad;
    int cantidadAceptada;

    public ListaProducto() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
        this.cantidadAceptada = 0;
    }

    public nodoProducto getPrimero() {
        return primero;
    }

    public void setPrimero(nodoProducto primero) {
        this.primero = primero;
    }

    public nodoProducto getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoProducto ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadAceptada() {
        return cantidadAceptada;
    }

    public void setCantidadAceptada(int cantidadAceptada) {
        this.cantidadAceptada = cantidadAceptada;
    }
    
    

    @Override
    public boolean esVacia() {
        return this.getPrimero() == null;
    }

    @Override
    public void agregarInicio(int nro, String nombre,  String descripcion) {
        nodoProducto nuevo = new nodoProducto(nro,nombre, descripcion);
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
    public void agregarFinal(int nro, String nombre,  String descripcion) {
        
        nodoProducto nuevo = new nodoProducto(nro, nombre, descripcion);
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
    public void agregarOrd(int nro, String nombre,  String descripcion) {
  
        nodoProducto nuevo = new nodoProducto(nro, nombre, descripcion);
        if (this.esVacia() || nro < this.getPrimero().getNro()) {
            this.agregarInicio(nro,nombre,  descripcion);
        } else {
            if (nro > this.getUltimo().getNro()) {
                this.agregarFinal(nro,nombre,  descripcion);
            } else {
                nodoProducto aux = this.getPrimero();
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

        nodoProducto aux = this.getPrimero();
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

       
        boolean borrado = false;
        if (this.buscarelemento(nro)) {
            nodoProducto aux = this.getPrimero();
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
        nodoProducto aux = this.getPrimero();

        while (aux != null && !encontrado) {
            if (aux.nro == nro) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }

        return encontrado;
    }

    @Override
    public nodoProducto obtenerElemento(int nro) {
        
        
        nodoProducto elemento = null;
        nodoProducto aux = this.getPrimero();
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
        nodoProducto aux = this.getPrimero();

        while (aux != null) {
            valorString = valorString + aux.getNro() + " - " + aux.getNombre() + " - " + "Stock: " + aux.getStock();
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
    public void borrarElemento(String nombre) {
          boolean borrado = false;
        if (this.buscarelemento(nombre)) {
            nodoProducto aux = this.getPrimero();
            if (this.primero.nombre.compareTo(nombre) == 0) {
                this.borrarInicio();
                borrado = true;
            } else {
                if (this.ultimo.nombre.compareTo(nombre)==0) {
                    this.borrarFin();
                    borrado = true;
                } else {
                    while (aux.getSiguiente() != null && aux.getSiguiente() != this.getUltimo() && !borrado) {
                        if (aux.siguiente.nombre.compareTo(nombre) == 0) {
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

    @Override
    public boolean buscarelemento(String nombre) {
        boolean encontrado = false;
        nodoProducto aux = this.getPrimero();

        while (aux != null && !encontrado) {
            if (aux.nombre.compareTo(nombre) == 0) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }

        return encontrado;
    }

    @Override
    public void agregarInicioNodo(nodoProducto np) {
            if (this.esVacia()) {
            primero = np;
            ultimo = np;
        } else {
            np.siguiente = primero;   //1
            primero = np;             //2

        }
        cantidad = cantidad + 1;
    }

  
}
