/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_6_examen_2da;

import java.util.Scanner;

/**
 *
 * @author santy
 */
public class EVA3_6_EXAMEN_2DA {
    
    public static final int PIEDRA = 1;//Los metodos de aqui con el valor final son comodos cuando se tienen que evaluar valores con numeros para una facil lectura
    public static final int PAPEL = 2;//Son constantes y por ende su valor nunca se va a modificar
    public static final int TIJERA = 3;
    
    public static final int EMPATE = 0;
    public static final int GANAR = 1;
    public static final int PIERDE = 2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CODE
    //CICLO
        int jugadaUsu;
        int jugadaComp;
        int resuJugada;
        do{
            jugadaUsu = capturarJugada("Introduce tu Jugada (1 - PIEDRA, 2 PAPEL, 3 - TIJERA, 0 - FIN DE JUEGO): ");
            jugadaComp = generarJugadaComp();
            resuJugada = evaluarJugada(jugadaUsu, jugadaComp);
        }while(jugadaUsu != 0);
        
    }
    //CAPTURA DE DATOS
    public static int capturarJugada(String mensaje){
        Scanner captu = new Scanner(System.in);
        System.out.println(mensaje);
        int resu = captu.nextInt();
        return resu;
        }
    //JUGADA DE COMPUTADORA
    public static int generarJugadaComp(){
        int resu;
        double valor = Math.random();
        if((valor >= 0) && (valor < 0.3))
            resu = 1; //PIEDRA
        else if((valor >= 0.3) && (valor < 0.6))
            resu = 2; //PAPEL
        else
            resu = 3; //TIJERA
        return resu;
    }
    //EVALUAR GANARDOR: 0 = empate, 1 = ganar, 2 = perder
    public static int evaluarJugada(int jugadaU, int jugadaC){
        //POSIBLES COMBINACIONES
        int resu;
        //EL JUGADOR SELECCIONA PIEDRA = 1
        if((jugadaU == PIEDRA) && (jugadaC == PIEDRA))
            resu = EMPATE;
        else if((jugadaU == PIEDRA) && (jugadaC == PAPEL))
            resu = PIERDE;
        else if((jugadaU == PIEDRA) && (jugadaC == TIJERA))
            resu = GANAR;
        //EL JUGADOR SELECCIONA PAPEL = 2
        else if((jugadaU == PAPEL) && (jugadaC == PIEDRA))
            resu = GANAR;
        else if((jugadaU == PAPEL) && (jugadaC == PAPEL))
            resu = EMPATE;
        else if((jugadaU == PAPEL) && (jugadaC == TIJERA))
            resu = PIERDE;
        //EL JUGADOR SELECCIONA TIJERA = 3
        else if((jugadaU == TIJERA) && (jugadaC == PIEDRA))
            resu = PIERDE;
        else if((jugadaU == TIJERA) && (jugadaC == PAPEL))
            resu = GANAR;
        else
            resu = EMPATE;
        return resu;
    }
}
