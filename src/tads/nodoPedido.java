
package tads;

public class nodoPedido {
    String ci;
    int Id;
    nodoPedido siguiente;
    ListaProducto lp;
    String estado;
    //lita 
    //cantidad = 6
    public nodoPedido(String ci, int Id) {
        this.ci = ci;
        this.siguiente = null;
        this.lp = new ListaProducto();
        this.estado = "Abierto";
        this.Id = 0;
    }
    
    public nodoPedido getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoPedido siguiente) {
        this.siguiente = siguiente;
    }

    public ListaProducto getLp() {
        return lp;
    }

    public void setLp(ListaProducto lp) {
        this.lp = lp;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
    
}
