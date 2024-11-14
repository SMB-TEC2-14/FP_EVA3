/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_10_arreglos_multi;

/**
 *
 * @author santy
 */
public class EVA3_10_ARREGLOS_MULTI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CODE
        int[][][][][] figura = new int [1][1][1][1][5];
        //CAPTURA DE DATOS
        System.out.println(figura.length);
        System.out.println(figura[0].length);
        System.out.println(figura[0][0].length);
        System.out.println(figura[0][0][0].length);
        System.out.println(figura[0][0][0][0].length);
        for (int a = 0; a < figura.length; a++){//1er Dim
            
            for (int b = 0; b < figura[a].length; b++){//2do Dim
                
                for (int c = 0; c < figura[a][b].length; c++){//3er Dim
                    
                    for (int d = 0; d < figura[a][b][c].length; d++) {//4ta Dim
                        
                        for (int e = 0; e < figura[a][b][c][d].length; e++) {//5ta Dim
                            
                            figura [a][b][c][d][e] = (int)(Math.random() * 100);
                        }
                    }
    
                }
                
            }
            
        }
        
        //IMPRESIÓN DE DATOS
        for (int a = 0; a < figura.length; a++){//1er Dim
            
            for (int b = 0; b < figura[a].length; b++){//2do Dim
                
                for (int c = 0; c < figura[a][b].length; c++){//3er Dim
                    
                    for (int d = 0; d < figura[a][b][c].length; d++) {//4ta Dim
                        
                        for (int e = 0; e < figura[a][b][c][d].length; e++) {//5ta Dim
                            
                            System.out.print("[" + figura [a][b][c][d][e] + "]");
                        }
                    }
    
                }
                
            }
            
        }
    }
    
}
 