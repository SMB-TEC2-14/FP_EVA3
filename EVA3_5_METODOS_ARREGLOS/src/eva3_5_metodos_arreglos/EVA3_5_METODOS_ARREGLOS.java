/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_5_metodos_arreglos;

/**
 *
 * @author santy
 */
public class EVA3_5_METODOS_ARREGLOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CODE
        String diasSemana[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"," "};
        imprimirArreglo(diasSemana);
        String mesesAño[] = {"Enero", "Febrero","Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"," "};
        imprimirArreglo(mesesAño);
        int billetes[] = {20,50,100,200,500,100};
        imprimirEntero(billetes);
    }
    public static void imprimirArreglo(String[] arreglo) {
        for(int i = 0; i < arreglo.length; i++)
            System.out.println(arreglo[i]);
}
    public static void imprimirEntero(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++)
            System.out.println(arreglo[i]);
    }
    
}
