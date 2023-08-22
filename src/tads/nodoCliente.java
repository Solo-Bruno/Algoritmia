
package tads;

/**
 *
 * @author Rafael
 */
public class nodoCliente {
    String ci;
    int tel;
    String nombre;
    nodoCliente siguiente;
    ColaPedido Cop;

    public nodoCliente(String nombre, String ci, int tel) {
        this.ci = ci;
        this.tel = tel;
        this.nombre = nombre;
        this.siguiente = null;
        this.Cop = new ColaPedido(5);
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public nodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoCliente siguiente) {
        this.siguiente = siguiente;
    }

    public ColaPedido getCop() {
        return Cop;
    }

    public void setCop(ColaPedido Cop) {
        this.Cop = Cop;
    }
    
}
