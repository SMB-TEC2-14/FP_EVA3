/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_8_arreglos_multi;

/**
 *
 * @author santy
 */
public class EVA3_8_ARREGLOS_MULTI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CODE
        
        int[][][] cubo = new int [2][5][3];
        //CAPTURA DE DATOS
        for (int i = 0; i < 2; i++){//1er Dim
            
            for (int j = 0; j < 5; j++){//2do Dim
                
                for (int k = 0; k < 3; k++){//3er Dim
                    cubo [i][j][k] = (int)(Math.random() * 100);
                }
                
            }
            
        }
        
        //IMPRESIÓN DE DATOS
        for (int i = 0; i < 2; i++){//1er Dim
            
            for (int j = 0; j < 5; j++){//2do Dim
                
                for (int k = 0; k < 3; k++){//3er Dim
                    System.out.print("[" + cubo [i][j][k] + "]");
                }
                
            }
            
        }
    }
    
}
