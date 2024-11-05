/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_2_valor_retorno;

/**
 *
 * @author santy
 */
public class EVA3_2_VALOR_RETORNO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CODE
        int result;
        result = sumarDosNumeros(5 , 10);
        //El orden tenermina el valor de cada variable
        System.out.println("El Resultado es: " + result);
        //Tambien se puede poner la función directo en el sout
        System.out.println("Resultado = " + sumarDosNumeros(10 , 10));
        
        //Cuando el resultado no interesa
        sumarDosNumeros(5 , 125);//En este caso el resultado se pierde
    }
    
    public static int sumarDosNumeros(int num1, int num2){
        return num1 + num2;//Se necesita recuperar el valor para emplearlo o el resultado no tiene interés
        
    }
}
