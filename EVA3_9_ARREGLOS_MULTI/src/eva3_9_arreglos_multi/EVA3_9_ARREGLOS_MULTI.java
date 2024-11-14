/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_9_arreglos_multi;

/**
 *
 * @author santy
 */
public class EVA3_9_ARREGLOS_MULTI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CODE
        int[] billetes = {20,50,100,200,500,1000};
        System.out.println(billetes.length);
        String[][] ciudades = {{"Aguascalientes","Calvillo","Jesus Maria"},
                                {"Ensenada","Mexicali","Tecate","Tijuana"},
                                {"La Paz","Cabo San Lucas","San Jose del Cabo"}};
        System.out.println(ciudades.length);
        System.out.println(ciudades[1].length);
        
        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < ciudades[i].length; j++) {
                System.out.println(ciudades[i][j]);
            }
        }
    }
    
}
