/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.util.Scanner;

/**
 *
 * @author elmer
 */
public class Procesos {
    public static void venta (){
        //crear una variable que escanea consola para asignar datos a variables
        Scanner sc = new Scanner(System.in);
        //llamar opcion 
        int op;
        
        
        
        // cantidades de productos 
        int productos = 0;
        
        //	código,	nombre,	precio y cantidad del producto
        int [] codigo;
        String [] nombreProducto;
        double [] precioProducto;
        int [] cantidadProducto;
        
        //subtotal de un solo producto
        double subtotalProducto = 0;
        int unidades = 0;
       
        //descuentos y precio con descuento segun subtotal
       double descuento = 0;
       double subtotalDescuento;
       double iva;
       double total;
       
       
       
       //variable para regresar el cambio 
        double cambio = 0;
        double recibido = 0;
        
        //forma de pago
        int formaPago;
        
        //variables para    consultar caja 
        int cantidadVentas = 0;
        int cantidadProductosVendidos = 0;
        double totalVendido = 0;
        double ventasEfectivo = 0;
        double ventasTarjeta = 0;
        double ventasTranferencia = 0;
        
        //variable para sumar a estadistica
       double promedioVentas = 0;
        int cantidadEfectivo = 0;
        int cantidadTarjeta = 0;
        int cantidadTransferencia = 0;
        
        //variable venta mayor y menor
        double mayor= 0;
        double menor = 0;
        //variable para identificar tipo de pago
        String tipo = null;
        
        //listado de opciones y pedir seleccionar
        
        do {
            System.out.println("Seleccionar la operacion a realizar");
            System.out.println("1.Registrar una venta\n" +
            "2.Consultar caja\n" +
            "3.Mostrar estadisticas\n" +
            "4.Salir");
            op = sc.nextInt();
            switch(op){
                case 1:
                    
                    //variable subtotal
                    double subtotal = 0;
                     
                    //reiniciar 
                    unidades =0;
                    
                    System.out.println("Ingrese la cantidad de productos que desea comprar"); 
                    productos = sc.nextInt();
                    if (productos <=0 ) {
                        System.out.println("Debe de ingresar al menos 1 producto");
                    }else{
                    
                    //sumar la cantidad de productos vendidos
                        cantidadProductosVendidos = cantidadProductosVendidos + productos;
                    
                        codigo = new int [productos];
                        nombreProducto = new String [productos];
                        precioProducto = new double [productos];
                        cantidadProducto = new int [productos];
                    
                        for (int i = 0; i < productos; i++) {
                        
                            System.out.println("Ingrese el codigo del producto "+ (i +1) +":");
                            codigo [i] = sc.nextInt();
                        
                            System.out.println("Ingrese el nombre del producto "+ (i + 1) +":");
                            nombreProducto[i] = sc.next();
                        
                            System.out.println("Ingrese el precio del producto "+ (i + 1) +":");
                            precioProducto [i]=  sc.nextDouble();
                            
                            while (precioProducto[i] <= 0){
                                System.out.println("El precio ingresado no es valido, ingreselo nuevamente:");
                                precioProducto [i] = sc.nextDouble();
                            }
                        
                            System.out.println("Ingrese la cantidad del producto "+ (i + 1) +":");
                            cantidadProducto[i]= sc.nextInt();
                            while (cantidadProducto[i] <= 0){
                                System.out.println("la cantidad del producto no es valida, ingresarla nuevamente:");
                                cantidadProducto [i] = sc.nextInt();
                            }
                        
                        }
                        for (int i = 0; i < productos; i++) {
                            subtotalProducto = precioProducto [i] * cantidadProducto [i];
                        
                            subtotal = subtotal + subtotalProducto;
                        
                        //cantidad de productos
                            unidades = unidades  + cantidadProducto[i];
                        
                        
                        }
                        System.out.printf("El subtotal es: Q.%.2f%n", subtotal);
                    
                        if (subtotal < 200) {
                            descuento = 0;
                        }else if (subtotal < 500) {
                            descuento = subtotal * 0.05;
                        }else if (subtotal < 1000) {
                            descuento = subtotal * 0.08;
                        }else if (subtotal >= 1000) {
                            descuento = subtotal * 0.10;
                        }
                        subtotalDescuento = subtotal - descuento;   
                    
                        iva = subtotalDescuento * 0.12;
                    
                        total = subtotalDescuento + iva;
                    
                    //ingresar el total vendido a caja
                        totalVendido = totalVendido + total;
                    
                    //mostrar el total
                        System.out.printf("El total a pagar es: Q.%.2f%n", total);
                    
                        do{
                                System.out.println("ingrese su metodo de pago: \n"
                                    + "1 efectivo \n"
                                    + "2 tarjeta \n"
                                    + "3 tranferencia");
                            formaPago = sc.nextInt();
                    
                        switch(formaPago){
                        
                            //verificssr en efectivo
                                case 1:
                            
                                //sumar el total vendido en efectivo a caja
                                    ventasEfectivo = ventasEfectivo + total;
                            
                                    System.out.println("Ingrese el monto recibido: ");
                                    recibido = sc.nextDouble();
 //resolver para que si no es suficiento restar lo recibido hasta que se llegue a cubrir lo necesario para la venta: pendiente                           
                                //verificar si el efectivo cubre la compra total
                                    while(recibido < total){
                                    
                                        double faltante = 0;
                                
                                        System.out.println("El monto recibido no es suficiente\n"
                                                + "ingresa lo faltante: ");
                                                faltante = sc.nextDouble();
                                            
                                                recibido = faltante + recibido;
                                        
                                
                                    }
                                    //operacion para mostrar el metodo 
                                    tipo = "Efectivo";
                                    //operacion para calcular cambio
                                    cambio = recibido - total;
                                    //sumar 1 al metodo de efectivo
                                    cantidadEfectivo++;
                                    break;
                                case 2:
                            
                                // sumar el total vendido en tarjeta a caja 
                                    ventasTarjeta = ventasTarjeta + total;
                            
                                    System.out.println("Ingrese su tarjeta para pagar");
                                    System.out.printf("Su total a pagar es: Q.%.2f%n" ,total);
                                    cantidadTarjeta++;
                                    //operacion para mostrar el metodo 
                                    tipo = "Tarjeta";
                            
                                break;
                        
                                case 3:
                            
                                // sumar el total vendido en tranferencia a caja
                                    ventasTranferencia = ventasTranferencia + total;

                                    System.out.println("Haga su tranferencia para pagar");
                                    System.out.printf("Su total a pagar es: Q.%.2f%n", total); 
                                    cantidadTransferencia++;
                                    //operacion para mostrar el metodo 
                                    tipo = "Transferencia";
                                break;      

                                default:
                                    System.out.println("forma de pago no valida!!!");
                                    break;
                            }
                        }while(formaPago <1 || formaPago > 3);
                    //resumen de la venta final
                        System.out.println("RESUMEN DE LA COMPRA"
                                + "------------------------------");
                        System.out.println("la cantidad de productos vendidos es: "+ unidades);
                        System.out.printf("el subtotal es: Q.%.2f%n", subtotal);
                        System.out.printf("El descuento es igual a: Q.%.2f%n",  descuento);
                        System.out.printf("El IVA es igual a: Q.%.2f%n", iva);
                        System.out.printf("El total es igual a: Q.%.2f%n", total);
                        System.out.println("La forma de pago es: " +tipo);
                            if (formaPago == 1) {
                                System.out.println("------------------------------");
                            System.out.printf("El efectivo recibido fue: Q.%.2f%n", recibido);
                            System.out.printf("El cambio dado es: Q.%.2f%n", cambio);
                                System.out.println("------------------------------");                            
                            }
                            //sumar una venta
                                cantidadVentas++;
                                //verificar venta mayor y menor
                                if (total > mayor) {
                                    mayor = total;
                                }
                                if (total < menor) {
                                    menor = total;
                                }
                        }break;
                //consultar caja
                case 2:
                    System.out.println("ventas realizadas: "+cantidadVentas);
                    System.out.println("productos vendidos: "+ cantidadProductosVendidos);
                    System.out.printf("Total vendido: Q.%.2f%n", totalVendido);
                    System.out.printf("Ventas en efectivo: Q.%.2f%n",ventasEfectivo);
                    System.out.printf("Ventas por tarjeta: Q.%.2f%n", ventasTarjeta);
                    System.out.printf("Ventas por transferencia: Q.%.2f%n", ventasTranferencia);
                    
                    break;    
                //consultar estadisticas    
                case 3:

                    
                    //validar que existan ventas
                    if (cantidadVentas > 0) {
                        promedioVentas = totalVendido/cantidadVentas ;
                        System.out.println("ESTADISTICAS DE LAS VEMTAS REALIZADAS\n"
                                + "------------------------------");
                        System.out.println("Número total de ventas: "+ cantidadVentas);
                        System.out.println("Cantidad total de productos vendidos: "+ cantidadProductosVendidos);
                        System.out.printf("Total de dinero vendido: Q.%.2f%n", totalVendido );
                        System.out.printf("Promedio de dinero por venta: Q.%.2f%n", promedioVentas);
                        System.out.println(" Cantidad de ventas	por forma de pago \n"
                                + "                                     ");
                        System.out.println("Pagos en efectivo: "+ cantidadEfectivo);
                        System.out.println("Pagos con tarjeta: "+ cantidadTarjeta);
                        System.out.println("Pagos con tranferencia: " + cantidadTransferencia);
                        System.out.printf("Venta de mayor valor: Q.%.2f%n", mayor);
                        System.out.printf("Venta de menor valor: Q.%.2f%n", menor);
                        
                        System.out.println("------------------------------");
                    }else{
                        System.out.println("---------------------------------\n"
                                + "   No existen ventas registradas   \n"
                                + "---------------------------------");
                    }
                    
                    
                    break;
                    
                case 4:
                    System.out.println("------------------------------\n"
                            + "SALIENDO DEL SISTEMA \n"
                            + "------------------------------");
                    
                    break;   
                    default:
                System.out.println("------------------------------\n"
                    + "Ingresar una opcion valida\n"
                    + "------------------------------");  
                    break;
                    
                    
            }
            
        } while (op != 4);
        

    }

   

}
