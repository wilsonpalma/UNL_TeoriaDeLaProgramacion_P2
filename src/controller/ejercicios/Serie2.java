package controller.ejercicios;

import java.util.Scanner;

import controller.util.Utilidades;

public class Serie2 {
    //S = (1 / 1)^2 + (1 / 3)^4 - (2 / 5)^6 - (3 / 7)^8 + (5 / 9)^10 + (8 / 11)^12 ...
    //S = (F1 / I1)^P1 + (F2 / I2)^P2 - (F3 / I3)^P3 ...
    //impares
    private int generar_impar(int numero){
        int resultado = 1;
        if(numero > 1){
            resultado = 2 * numero - 1;
        }
        return resultado;
    }
    //par
    private int generar_par(int numero){
        return numero * 2;
    }
    //fibonacci
    public int generar_fibonacci(int numero){
        // 0 1 1 2 3 5 8
        int numeroAnterior = 0;
        int numeroSiguiente = 1;
        int resultado = 1;
        if(numero > 1){
            for (int i = 1; i < numero; i++) {
                resultado = numeroAnterior + numeroSiguiente;
                numeroAnterior = numeroSiguiente;
                numeroSiguiente = resultado;
            }
        }
        return resultado;
    }
    public void ejecutar(){
        Scanner sc = new Scanner(System.in);
        // Se pide la cantidad de términos que se desea al usuario
        System.out.println("Ingrese el numero de terminos de la serie");
        int num_serie = Utilidades.tranformStringInt(sc.nextLine());

        // Se verifica que el numero de términos deseados sea un valor positivo
        if(num_serie > 0){
            int interruptor = 1; // Para alternar de signos + -
            String signo = "";
            float suma = 0.0f;
            String serie = "";
            //Empezamos el bucle para construir la serie
            for (int i = 1; i <= num_serie; i++) {
                int fibo = generar_fibonacci(i);
                int impar = generar_impar(i);
                int mult2 = generar_par(i);
                // Se va contruyendo la serie
                serie += signo+"("+fibo+" / "+impar+")^"+mult2;
                // Se calcula la suma de n términos
                suma += Math.pow((double)fibo/(double)impar,(double)mult2)*Integer.parseInt(signo.trim()+"1");
                
                // En caso de que no haya una siguiente interacción se termina el bucle
                if(i+1 > num_serie){break;}

                // Caso contrario, se prepara el signo para el siguiente término
                if(i%2==0){interruptor = 1-interruptor;}
                // Se asigna el signo dependiendo del valor de interruptor
                if(interruptor==1){signo=" + ";}
                else{signo=" - ";}
            }
            System.out.println("La serie es:");
            System.out.println(serie);
            System.out.println("La suma es:");
            System.out.println(suma);
        }else {
            System.out.println("Ingrese un numero mayor a 0");
        }
    }
}
