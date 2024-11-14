/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_7_matrices;

/**
 *
 * @author santy
 */
public class EVA3_7_MATRICES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CODE
        int [] arreglo = new int[5];//Arreglo unidimencional
        int [][] matriz = new int[3][3];//Hoja de EXCEL
        matriz[0][0] = 100;//Primer Posición
        matriz[0][1] = 200;
        matriz[0][2] = 300;
        matriz[1][0] = 400;
        matriz[1][1] = 500;
        matriz[1][2] = 600;
        matriz[2][0] = 700;
        matriz[2][1] = 800;
        matriz[2][2] = 900;//Ultima Posición
        
        for (int i = 0; i < 3; i++){//Filas en 1er Dimensión
            for(int j = 0; j < 3; j++){//Columnas en 2da Dimensión
                System.out.print("[" + matriz[i][j] + "]");
            
            }
            System.out.println("");
        }
    }
    
}
