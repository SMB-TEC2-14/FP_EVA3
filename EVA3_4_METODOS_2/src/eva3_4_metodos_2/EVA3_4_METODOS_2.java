/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_4_metodos_2;

import java.util.Scanner;

/**
 *
 * @author santy
 */
public class EVA3_4_METODOS_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CODE
        System.out.println(encontrarMayorEntero(8,7));
        System.out.println(diaSemana(5));
    }
    
    //Valor más grande entre 2 enteros
    public static int encontrarMayorEntero(int num1, int num2){
        
        //Esta es una opción valida
        
        /*int resu;
        if(num1 > num2)
            resu = num1;
        else
            resu = num2;
            
        return resu;*/
        
        if(num1 > num2){
            return num1;
            
        }else{
            return num2;
            
        }
        
    }
    
    //Metodo que regrese el dia de la semana en texto, pidiendo un numero (1 - 7)
    public static String diaSemana(int dia){
        switch (dia){
            case 1:
                return "Domingo";
            case 2:
                return "Lunes";
            case 3:
                return "Martes";
            case 4:
                return "Miercoles";
            case 5:
                return "Jueves";
            case 6:
                return "Viernes";
            case 7:
                return "Sabado";
            default:
                return "El Numero es invalido (1 - 7)";
        }
        
    }
}
