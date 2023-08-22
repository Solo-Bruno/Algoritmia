
package tads;

/**
 *
 * @author Rafael
 */
public class nodoPedidoCerrado {
    int nro;
    String nombre;
    nodoPedidoCerrado siguiente;

    public nodoPedidoCerrado(int nro, String nombre) {
        this.nro = nro;
        this.nombre = nombre;
        this.siguiente = null;


    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public nodoPedidoCerrado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoPedidoCerrado siguiente) {
        this.siguiente = siguiente;
    }
    
}
