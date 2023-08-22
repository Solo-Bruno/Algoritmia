
package tads;


public class ColaPedido implements IColaPedido {

    nodoPedido frente;
    nodoPedido fondo;
    int cantnodosaceptado;
    int cantnodos;

    public ColaPedido(int cantnodosaceptado) {
        this.frente = null;
        this.fondo = null;
        this.cantnodosaceptado = cantnodosaceptado;
        this.cantnodos = 0;
    }

    public nodoPedido getFrente() {
        return frente;
    }

    public void setFrente(nodoPedido primero) {
        this.frente = primero;
    }

    public nodoPedido getFondo() {
        return fondo;
    }

    public void setFondo(nodoPedido ultimo) {
        this.fondo = ultimo;
    }

    public int getCantnodosaceptado() {
        return cantnodosaceptado;
    }

    public void setCantnodosaceptado(int cantnodosaceptado) {
        this.cantnodosaceptado = cantnodosaceptado;
    }

    public int getCantnodos() {
        return cantnodos;
    }

    public void setCantnodos(int cantnodos) {
        this.cantnodos = cantnodos;
    }
    // implementacion de los metodos abstractos.

    @Override
    public boolean esVacia() {
        return this.cantnodos == 0;
    }

    @Override
    public boolean esllena() {
        return this.cantnodos == this.cantnodosaceptado;
    }

    @Override
    public void encolar(String ci) {
        int cant = this.cantnodos + 1;
        nodoPedido nuevo = new nodoPedido( ci, cant);
        
        if (!this.esllena()) {
            if (this.esVacia()) {
                this.setFrente(nuevo);
                this.setFondo(nuevo);
            } else {
                nuevo.setSiguiente(this.getFrente());
                this.setFrente(nuevo);
            }
            this.cantnodos = this.cantnodos + 1;
        } else {
            System.out.println("La Cola esta llena no se puede agregar ...");
        }
    }

    @Override
    public void desencolar() {
        if (!this.esVacia()) {
            if (this.cantnodos == 1) {
                this.setFrente(null);
                this.setFondo(null);
            } else {
                nodoPedido aux = this.getFrente();
                while (aux.siguiente != this.getFondo()) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(null);
                this.setFondo(aux);
             }    
                this.cantnodos = this.cantnodos - 1;
           
        } else {
            System.out.println("Cola vacia, no hay elementos para borrar");
        }
    }

    @Override
    public nodoPedido frente() {
        if (!this.esVacia()){
        return this.frente;
        }else{
            System.out.println("La cola esta vacia, retorno valor -1");
          return null;
        }
    }

    @Override
    public nodoPedido fondo() {
        if (!this.esVacia()){
            return this.fondo;
            
        }else{
             System.out.println("La cola esta vacia, retorno valor -1");
             return null;
        }
    }

    @Override
    public boolean estaProducto(String nombre) {
        nodoPedido aux = this.frente;
        boolean ret = false;
        while(aux != null && !ret){
            if(aux.getLp().buscarelemento(nombre)){
                ret = true;
            }
            aux = aux.getSiguiente();
        }
        
        return ret;
    }

    @Override
    public boolean estado() {
        boolean ret = false;
        nodoPedido aux = this.frente;
        while(aux != null && !ret){
            
            if(aux.getEstado().compareTo("Abierto")== 0){
                ret = true;
            }
            aux = aux.getSiguiente();
        }   
        
        return ret;
    }

    @Override
    public void encolarNodo(nodoPedido np) {
        if (!this.esllena()) {
            if (this.esVacia()) {
                this.setFrente(np);
                this.setFondo(np);
            } else {
                np.setSiguiente(this.getFrente());
                this.setFrente(np);
            }
            this.cantnodos = this.cantnodos + 1;
        } else {
            System.out.println("La Cola esta llena no se puede agregar ...");
        }
    }
    
    public nodoPedido IrAlUltimo(){
    
       nodoPedido aux = this.frente;
       nodoPedido ret = null;
       
       while(aux != null || aux.siguiente.getEstado().compareTo("Prontos para entregar") == 0){
           
           ret = aux;
           aux = aux.getSiguiente();
       }
       
       return ret;
    }
    
    public String mostrar(){
        String valorString = " ";
        nodoPedido aux = this.getFrente();

        while (aux != null) {
            valorString = valorString + "Cliente CI: "+ aux.getCi() + " - " + aux.getEstado() +" "+ "Cantidad de Productos: " + aux.getLp().getCantidad();
            valorString = valorString + "\n";
            aux = aux.getSiguiente();
        }

        return valorString;
    }

    @Override
    public int PedidosCerrados() {
        int cont = 0;
        
        nodoPedido aux = this.frente;
        
        while(aux != null){
            if(aux.getEstado() == "Cerrado"){
                cont++;
            }
            
            aux = aux.getSiguiente();
        }
        
        return cont;
    }

}
