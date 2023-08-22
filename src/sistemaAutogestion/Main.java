package sistemaAutogestion;




public class Main {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        juegoDePrueba(s, p);
        pruebasdefensa(s,  p);
    }
    
    public static void juegoDePrueba(Sistema s, Prueba p){
     
    }
         public static void pruebasdefensa(Sistema s, Prueba p) {
        p.ver(s.crearSistemaDeAutoservicio(5).resultado, Retorno.Resultado.OK, "Se crea el sistema con 5 unidades");
        System.out.println("***** REGISTRO DE CLIENTES *****");
        System.out.println();
        /*Registro de clientes*/
        p.ver(s.agregarCliente("Pedro Picapiedra", "1", 99368826).resultado, Retorno.Resultado.OK, "Se registra Pedro");
        p.ver(s.agregarCliente("Pablo Marmol", "2", 96008855).resultado, Retorno.Resultado.OK, "Se registra Pablo");
        p.ver(s.agregarCliente("Vilma Picapiedra", "3", 99368826).resultado, Retorno.Resultado.OK, "Se registra vilma");
        p.ver(s.agregarCliente("Betty Mármol", "4", 91368998).resultado, Retorno.Resultado.OK, "Se registra Betty.");
        p.ver(s.agregarCliente("Betty Mármol", "4", 91368998).resultado, Retorno.Resultado.ERROR_1, "No se registra Betty ya existe");
        p.ver(s.agregarCliente("Dino", "5", 99430021).resultado, Retorno.Resultado.OK, "Se registra el cliente: Ximena Sanchez");
        p.ver(s.agregarCliente("Bam Bam", "6", 99430021).resultado, Retorno.Resultado.OK, "Se registra el cliente: Ximena Sanchez");
        
        

        /*Listar Clientes*/
        System.out.println("Lista de Clientes:");
        System.out.println(s.lc.mostrar());

        /*Eliminar Clientes*/
        p.ver(s.eliminarCliente("4").resultado, Retorno.Resultado.OK, "Se elimina el cliente con cedula: 4 - Betty");
        p.ver(s.eliminarCliente("4").resultado, Retorno.Resultado.ERROR_1, "No se elimina  el cliente con cedula: 4. No existe.");

        /*Listar Clientes*/
        System.out.println("Lista de Clientes luego de borrar al cliente 4:");
        System.out.println(s.lc.mostrar());

        System.out.println("---------------------------------------------------------------------");
        System.out.println("***** REGISTRO DE PRODUCTOS *****");
        System.out.println("---------------------------------------------------------------------");
        System.out.println();

        /*Listar prductos*/
        System.out.println("Lista de Productos:");
        System.out.println(s.lp.mostrar());

       
        p.ver(s.agregarProducto("Hamburguesa Doble", "Hamburguesa doble cheddar con salsa dijon").resultado, Retorno.Resultado.OK, "Se registra el producto: Hamburguesa Doble.");
        p.ver(s.agregarProducto("Papas Champi", "Papas fritas con salsa de champiñones").resultado, Retorno.Resultado.OK, "Se registra el producto: Papas Champi.");
         p.ver(s.agregarProducto("Nuggets de pollo", "Nugegets de pollo con salsa").resultado, Retorno.Resultado.OK, "Se registra el producto: Nuggets de pollo.");
        p.ver(s.agregarProducto("Pizza a la Piedra", "Pizza con salsa de tomate, orégano, ajo, aceite de oliva y albahaca").resultado, Retorno.Resultado.OK, "Se registra el prodcuto: Pizza a la piedra");
        p.ver(s.agregarProducto("Papas Champi", "Papas fritas con salsa de champiñones y queso cheddar").resultado, Retorno.Resultado.ERROR_1, "No se registra el producto: Papas Champi. Ya existe un producto con el mismo nombre");

        /*Listar prductos*/
        System.out.println("Lista de Productos:");
        System.out.println(s.lp.mostrar());

        /*Eliminar Productos*/
        p.ver(s.eliminarProducto("Papas Champi").resultado, Retorno.Resultado.OK, "Se elimina el prodcuto: Papas Champi.");
        p.ver(s.eliminarProducto("Refresco").resultado, Retorno.Resultado.ERROR_1, "No se puede eliminar el prodcuto: Refresco. No Existe.");

        /*Listar prductos*/
        System.out.println("Lista de Productos:");
        System.out.println(s.lp.mostrar());
        
        /* Agregar Stock a un Producto */
        p.ver(s.altaStockProducto(1, 5).resultado, Retorno.Resultado.OK, "Se le agrega 5 unidades de Stock al producto 1");
        p.ver(s.altaStockProducto(3, 5).resultado, Retorno.Resultado.OK, "Se le agrega 5 unidades de Stock al producto 3");
        p.ver(s.altaStockProducto(4, 5).resultado, Retorno.Resultado.OK, "Se le agrega 5 unidades de Stock al producto 4");
        /* Este producto no existe*/
        p.ver(s.altaStockProducto(2, 5).resultado, Retorno.Resultado.ERROR_1, "El Producto 2 no existe");
        
        /*Listar prductos*/
        System.out.println("Lista de Productos:");
        System.out.println(s.lp.mostrar());
        
        /* Abrir Pedido*/
        p.ver(s.aperturaDePedido("1").resultado, Retorno.Resultado.OK, "El cliente 1 abre su pedido");
        p.ver(s.aperturaDePedido("2").resultado, Retorno.Resultado.OK, "El cliente 2 abre su pedido");
        p.ver(s.aperturaDePedido("3").resultado, Retorno.Resultado.OK, "El cliente 3 abre su pedido");
        p.ver(s.aperturaDePedido("7").resultado, Retorno.Resultado.ERROR_1, "El cliente 7 no existe");
        p.ver(s.aperturaDePedido("1").resultado, Retorno.Resultado.ERROR_2, "El cliente 1 ya abrio su pedido");

        /* Listar pedidos */
        System.out.println("Lista de Pedidos:");
        s.lc.mostrarPedidos();
        System.out.println("----------------------------------------------");
        /* Agregar productos */
        
        p.ver(s.agregarProductoAPedido("1", 1, 1).resultado, Retorno.Resultado.OK, "El cliente 1 agrego dos Hamburguesa Doble a su pedido");
        p.ver(s.agregarProductoAPedido("1", 4, 1).resultado, Retorno.Resultado.OK, "El cliente 1 agrego una Pizza a la Piedra a su pedido");
        p.ver(s.agregarProductoAPedido("2", 3, 2).resultado, Retorno.Resultado.OK, "El cliente 2 agrego dos Nuggets de pollo a su pedido");
        p.ver(s.agregarProductoAPedido("3", 4, 2).resultado, Retorno.Resultado.OK, "El cliente 2 agrego dos Nuggets de pollo a su pedido");
        p.ver(s.agregarProductoAPedido("3", 3, 2).resultado, Retorno.Resultado.OK, "El cliente 2 agrego dos Nuggets de pollo a su pedido");
        p.ver(s.agregarProductoAPedido("3", 1, 1).resultado, Retorno.Resultado.OK, "El cliente 2 agrego dos Nuggets de pollo a su pedido");

        System.out.println("Lista de Pedidos:");
        s.lc.mostrarPedidos();
        
        System.out.println("----------------------------------------------");
        System.out.println("Lista de Productos:");
        System.out.println(s.lp.mostrar());
        
        /* Datos con errores */
        p.ver(s.agregarProductoAPedido("8", 1, 2).resultado, Retorno.Resultado.ERROR_1, "Este cliente no Existe");
        p.ver(s.agregarProductoAPedido("1", 6, 2).resultado, Retorno.Resultado.ERROR_2, "Este Producto no Existe");
        p.ver(s.agregarProductoAPedido("2", 1, 8).resultado, Retorno.Resultado.ERROR_3, "Las unidades pedidas sobrepasa a las aceptadas");
        p.ver(s.agregarProductoAPedido("1", 1, 0).resultado, Retorno.Resultado.ERROR_4, "Las unidades tienen que ser mayor que 0");
        p.ver(s.agregarProductoAPedido("1", 1, 5).resultado, Retorno.Resultado.ERROR_5, "No hay tanto Stock de este producto");
        
        System.out.println("----------------------------------------------");
        System.out.println("Lista de Pedidos:");
        s.lc.mostrarPedidos();
        
        /* Deshacer agregado de productos  */
        
        p.ver(s.deshacerPedido("1", 1).resultado, Retorno.Resultado.OK, "Se elimino el ultimo pedido del cliente 1");
        p.ver(s.deshacerPedido("3", 2).resultado, Retorno.Resultado.OK, "Se eliminaron los dos ultimo pedido del cliente 3");

        System.out.println("Lista de Pedidos:");
        s.lc.mostrarPedidos();

        System.out.println("----------------------------------------------");
        System.out.println("Lista de Productos:");
        System.out.println(s.lp.mostrar());
        
        p.imprimirResultadosPrueba(); 
        
        
        
        
    }
    
}
