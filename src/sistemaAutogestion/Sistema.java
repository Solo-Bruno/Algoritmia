package sistemaAutogestion;

import tads.ListaCliente;
import tads.ListaProducto;
import tads.ColaPedido;
import tads.nodoProducto;
import tads.nodoCliente;
import tads.nodoPedido;

public class Sistema implements IObligatorio {

    public ListaCliente lc = null;
    public ListaProducto lp = null;
    public ColaPedido PedidoProcesar = null;
            
 //        Pre Condiciones
//  El numero de maxUnidadesDePedido debe ser int.
//  El numero de unidades debe ser mayor a 3.
    
    //        Post Condiciones
//    Crear Sistema de Autoservicio:
//    Se creo la estructura, el pedido tiene cuantas unidades maximas permite.
    @Override
    public Retorno crearSistemaDeAutoservicio(int maxUnidadesDePedido) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(maxUnidadesDePedido >= 3){
            lc = new ListaCliente();
            lp = new ListaProducto();
            PedidoProcesar = new ColaPedido(20);
            lp.setCantidadAceptada(maxUnidadesDePedido);
        }else{
           ret.resultado = Retorno.Resultado.ERROR_1;
        }

        return ret;
    }
   
    
    
//        Pre Condiciones
//    El nombre debe ser string, ci string y el tel int.
//    No debe existir un cliente con el mismo ci.

//      Post Condiciones
//    Se creo el cliente con su debido Nombre, ci y tel.
    
    @Override
    public Retorno agregarCliente(String nombre, String ci, int tel) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(!lc.buscarelemento(Integer.parseInt(ci))){
            lc.agregarInicio(nombre, ci, tel);
        }else{ 
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        return ret;
    }
    
    
//    Pre condiciones 
//    El ci debe ser string.
//    Debe de existir el cliente.
//    No debe de tener pedidos registrados.
    
    //      Post Condiciones
//    Se elimino el cliente dado el ci recibido.
    
    @Override
    public Retorno eliminarCliente(String ci) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(!lc.buscarelemento(Integer.parseInt(ci))){
             ret.resultado = Retorno.Resultado.ERROR_1;
        }else{
            if(!lc.obtenerElemento(ci).getCop().esVacia()){
                ret.resultado = Retorno.Resultado.ERROR_2;
            }else{
                lc.borrarElemento(ci);
            }
        }
      
        return ret;
    }

//    Pre Condiciones
//    El nombre debe ser string y la descripcion tambien.
//    No debe de existir un producto con el mismo nombre.
    
    //      Post Condiciones
//   El producto fue agregado con su debido nombre y descripcion.
    @Override
    public Retorno agregarProducto(String nombre, String descripcion) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        int nro;
        if(!lp.buscarelemento(nombre)){
            if(lp.getPrimero() != null){
               nro = lp.getPrimero().getNro() + 1;
            }else{
                nro = 1;
            }
            lp.agregarInicio(nro, nombre, descripcion);
        }else{
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        
        return ret;
    }
    
    
    
    //    Pre Condiciones
//    El nombre debe ser string.
//    Debe de existir un producto con ese nombre.
//    No debe de tener un pedido.
    
    //      Post Condiciones
//El producto fue eliminado dado el nombre recibido.  
    @Override
    public Retorno eliminarProducto(String nombre) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(!lp.buscarelemento(nombre)){
            ret.resultado = Retorno.Resultado.ERROR_1;
        }else{
            if(PedidoProcesar.estaProducto(nombre)){
              ret.resultado = Retorno.Resultado.ERROR_2;
            }else{
                lp.borrarElemento(nombre);
            }
        }
        
        return ret;
    }

    /////////////////////////////////////////////////////////////
    //Pre condiciones:
    //El numero de producto y numero de unidades deben ser int. 
    //No debe de existir un producto con el numero indicado. 
    //El numero de unidades debe ser mayor a 0
    
    //Post condiciones:
    //Se añadió la cantida de stock deseada al producto deseado 

    
    @Override
    public Retorno altaStockProducto(int nroProducto, int unidades) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        nodoProducto aux = lp.obtenerElemento(nroProducto);
        
        if(aux == null){
           ret.resultado = Retorno.Resultado.ERROR_1;
           return ret;
        }else if(unidades <= 0){
           ret.resultado = Retorno.Resultado.ERROR_2;
           return ret;
        }
        
        aux.setStock(unidades);
        
        return ret;
    }

    @Override
    public Retorno aperturaDePedido(String ciCliente) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        nodoCliente auxCliente = lc.obtenerElemento(ciCliente);
        if(auxCliente == null){
            ret.resultado = Retorno.Resultado.ERROR_1;
            return ret;
        }
        if(!auxCliente.getCop().estado()){
            auxCliente.getCop().encolar(ciCliente);
        }else{
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }
        
        return ret;
    }

    @Override
    public Retorno agregarProductoAPedido(String ciCliente, int nroProducto, int unidades) {
         Retorno ret = new Retorno(Retorno.Resultado.OK);
        //nodo CLiente aux = LC.Buscar();
        //aux.ColaPed.Agregar()
        nodoCliente auxCliente = lc.obtenerElemento(ciCliente);
        nodoProducto auxProducto = lp.obtenerElemento(nroProducto);
        
        
        
       if(auxCliente == null){
           
           ret.resultado = Retorno.Resultado.ERROR_1;
           return ret;
       }
       
       nodoPedido auxPedido = auxCliente.getCop().frente();
       if(auxProducto == null){
           ret.resultado = Retorno.Resultado.ERROR_2;
       
           return ret;
       }
       
       if(unidades > lp.getCantidadAceptada()){
           
           ret.resultado = Retorno.Resultado.ERROR_3;
       
           return ret;
       }
       
       if(unidades <= 0){
           
           ret.resultado = Retorno.Resultado.ERROR_4;
           return ret;
       }
       
       
       if(auxProducto.getStock() < unidades){
           ret.resultado = Retorno.Resultado.ERROR_5;
           return ret;
       }else{
       
        for(int i =0; i < unidades; i++){
            if(auxProducto.getStock() > unidades){
                auxPedido.getLp().agregarInicio(auxProducto.getNro(), auxProducto.getNombre(), auxProducto.getDescripcion());  
            }
        }
        
        auxProducto.setStockMenos(auxProducto.getStock() - unidades);
       
       }
        return ret;
    }

    @Override
    public Retorno deshacerPedido(String ciCliente, int cantAccionesDeshacer) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        nodoCliente auxCliente = lc.obtenerElemento(ciCliente);
        nodoPedido auxPedido = auxCliente.getCop().frente();
        
        
        
        if(auxCliente == null){
           
           ret.resultado = Retorno.Resultado.ERROR_1;
           return ret;
        }
        
        nodoProducto aux = auxPedido.getLp().getPrimero();
        
        if(cantAccionesDeshacer <= 0){
           
           ret.resultado = Retorno.Resultado.ERROR_2;
           return ret;
        }
        
        if(auxPedido.getLp().getCantidad() < cantAccionesDeshacer){
           ret.resultado = Retorno.Resultado.ERROR_3;
           return ret;
        }
        
        for(int i = 0; i < cantAccionesDeshacer; i++){
            
            
            int cont = 0;
            String nomPrimero = aux.getNombre();
            nodoProducto auxProducto = lp.obtenerElemento(aux.getNro());
            
            while(aux.getNombre() == nomPrimero && aux != null ){
                cont++;
                aux = aux.getSiguiente();
            }
        
            for(int j = 0; j < cont; j++){
                auxPedido.getLp().borrarInicio();
            }
            
           auxProducto.setStock(cont);
        }
        
        
        return ret;
    }
    

    @Override
    public Retorno cerrarPedido(String ciCliente) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        nodoCliente auxCliente = lc.obtenerElemento(ciCliente);
        nodoPedido auxPedido = auxCliente.getCop().frente();
        if(auxCliente == null){
            ret.resultado = Retorno.Resultado.ERROR_1;
            return ret;
        }
        if(auxPedido.getEstado().compareTo("Cerrado") == 0){
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }
        auxPedido.setEstado("Cerrado");
        PedidoProcesar.encolarNodo(auxPedido);
        
        return ret;
    }

    @Override
    public Retorno procesarPedido(int cantPedidos) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        nodoPedido aux =  null;
        if(cantPedidos <= 0){
            ret.resultado = Retorno.Resultado.ERROR_1;
            return ret;
        }
        
        if(PedidoProcesar.PedidosCerrados() < cantPedidos){
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }
        for(int i = 0; i < cantPedidos; i++){
           aux =  PedidoProcesar.IrAlUltimo();
           aux.setEstado("Prontos para entregar");
        }
        return ret;
    }

    @Override
    public Retorno listarClientes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ListaCliente lcaux = lc;
        String ciaux;
        int telaux;
        String nombreaux;
        ColaPedido CoPaux;
        
        int cantidad = lcaux.cantElementos();
        
        if(cantidad > 1){
            
            nodoCliente p1 = lcaux.getPrimero();
            nodoCliente p2 = p1.getSiguiente();
            
            for(int i = 0; i < cantidad -1; i++){
                
                while(p2 != null){
                    if(p1.getNombre().compareTo(p2.getNombre()) > 0){
                        
                        ciaux = p1.getCi();
                        telaux = p1.getTel();
                        nombreaux = p1.getNombre();
                        CoPaux = p1.getCop();
                        
                        p1.setCi(p2.getCi());
                        p1.setTel(p2.getTel());
                        p1.setNombre(p2.getNombre());
                        p1.setCop(p2.getCop());
                        
                        p2.setCi(ciaux);
                        p2.setTel(telaux);
                        p2.setNombre(nombreaux);
                        p2.setCop(CoPaux); 
                    }
                    
                    p1 = p1.getSiguiente();
                    p2 = p1.getSiguiente();
                }
                
                p1 = lcaux.getPrimero();
                p2 = p1.getSiguiente();
            
            }
        }
        
        
         System.out.println(lcaux.mostrar());
        
        return ret;
    }

    @Override
    public Retorno listarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno listarPedidosAbiertos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno pedidosCerradosDeClientes(int ci) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno productosParaEntregar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Retorno reporteDePedidosSolicitadosXCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
