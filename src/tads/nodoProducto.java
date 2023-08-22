
package tads;

public class nodoProducto {
    int nro;
    String nombre;
    String descripcion;
    nodoProducto siguiente;
    int stock;

    public nodoProducto(int nro, String nombre, String descripcion) {
        this.nro = nro;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.siguiente = null;
        this.stock = 0;
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

    public nodoProducto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoProducto siguiente) {
        this.siguiente = siguiente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock += stock;
    }  
    
    public void setStockMenos(int stock) {
        this.stock = stock;
    } 
}
