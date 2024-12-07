
package fp_eva3_examen.practico;

import java.util.Scanner;

public class FP_EVA3_EXAMENPRACTICO {

    public static void main(String[] args) {
        //VARIABLES
        Scanner scanner = new Scanner(System.in);
        int Estudiantes;
        //CODE
        System.out.println("Saludos Usuario :D");
        System.out.println(" ");
        //DO WHILE PARA QUE EL NÚMERO DE ALUMNOS ES MAYOR A 0
        do {
            System.out.print("Ingrese el numero de estudiantes a evaluar(mayor a 0): ");
            Estudiantes = scanner.nextInt();
            if (Estudiantes <= 0) {
                System.out.println("El numero de estudiantes debe ser mayor a 0. Intente de nuevo.");
            }
        } while (Estudiantes <= 0);
        
        //FOR IR Y DO WHILE PARA LA CALIFICACIÓN DE 0 A 100
        double[] calificaciones = new double[Estudiantes];
        for (int i = 0; i < Estudiantes; i++) {
            double calificacion;
            do {
                System.out.print("Ingrese la calificacion del estudiante " + (i + 1) + " (entre 0 y 100): ");
                calificacion = scanner.nextDouble();
                if (calificacion < 0 || calificacion > 100) {
                    System.out.println("La calificacion debe estar entre 0 y 100. Intente de nuevo.");
                }
            } while (calificacion < 0 || calificacion > 100);
            calificaciones[i] = calificacion;
        }
        //IMPRESION DE RESULTADOS
        double promedio = calcularPromedio(calificaciones);
        int mayoresOIgualesAlPromedio = contarCalificacionesMayores(calificaciones, promedio);
        double calificacionMasAlta = obtenerCalificacionMasAlta(calificaciones);
        double calificacionMasBaja = obtenerCalificacionMasBaja(calificaciones);

        System.out.println("Resultados:");
        System.out.printf("Promedio de calificaciones:" + promedio);
        System.out.println(" ");
        System.out.println("Cantidad de calificaciones mayores o iguales al promedio: " + mayoresOIgualesAlPromedio);
        System.out.printf("Calificacion mas alta:" + calificacionMasAlta);
        System.out.println(" ");
        System.out.printf("Calificacion mas baja:" +  calificacionMasBaja);
        System.out.println(" ");

        scanner.close();
    }    
        
        //METODO calcularPromedio
        public static double calcularPromedio(double[] calificaciones) {
        double Suma = 0;
        for (double calificacion : calificaciones) {
            Suma += calificacion;
        }
        return Suma / calificaciones.length;
    }
        //METODO contarCalificacionesMayores
        public static int contarCalificacionesMayores(double[] calificaciones, double promedio) {
        int Contador = 0;
        for (double calificacion : calificaciones) {
            if (calificacion >= promedio) {
                Contador++;
            }
        }
        return Contador;
    }
        //METODO  obtenerCalificacionMasAlta
        public static double obtenerCalificacionMasAlta(double[] calificaciones) {
        double Alta = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion > Alta) {
                Alta = calificacion;
            }
        }
        return Alta;
    }
        //METODO obtenerCalificacionMasBaja
        public static double obtenerCalificacionMasBaja(double[] calificaciones) {
        double Baja = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion < Baja) {
                Baja = calificacion;
            }
        }
        return Baja;
    }
        
}        