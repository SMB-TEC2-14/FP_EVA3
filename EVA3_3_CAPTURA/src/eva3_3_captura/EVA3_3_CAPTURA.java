/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_3_captura;

import java.util.Scanner;

/**
 *
 * @author santy
 */
public class EVA3_3_CAPTURA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CODE
        System.out.println("Bienvenido Usuario, vamos a capturar tus datos personales");
        System.out.println(" ");
        String nombre = capturarTexto("Ingresa tu nombre");
        String apellido = capturarTexto("Ingresa tu apellido");
        int edad = capturarNumero("Ingresa tu edad: ");
        double salario = capturarDecimal("Ingresa tu Salario: ");
        
        System.out.println(" ");
        System.out.println("Nombre y Apellido del Usuario: ");
        System.out.println(" ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println(" ");
        System.out.println("Edad del Usuario: ");
        System.out.println("Edad: " + edad);
        System.out.println(" ");
        System.out.println("Salario del Usuario: ");
        System.out.println("Salario: " + salario);
        System.out.println(" ");
    }
    
    //Captura de Texto
    public static String capturarTexto(String mensaje){
        Scanner capt = new Scanner(System.in);
        System.out.println(mensaje);
        String texto = capt.nextLine();
        return texto;
    }
    public static int capturarNumero(String mensaje){
        Scanner capt = new Scanner(System.in);
        System.out.println(mensaje);
        int edad = capt.nextInt();
        capt.nextLine();
        return edad;
    }
    public static Double capturarDecimal(String mensaje){
        Scanner capt = new Scanner(System.in);
        System.out.println(mensaje);
        double salario = capt.nextDouble();
        capt.nextLine();
        return salario;
    }
    
}
