package controller.ejercicios;
import java.util.Scanner;

import controller.util.Utilidades;

public class SueldoDeEmpleados {

    public void ejecutar(){
        Scanner sc = new Scanner(System.in);

        int totalAutos = 0;
        double totalVentas = 0.0, comision = 0.0, sueldoFijo = 2500.0, utilidad, sueldoTotal;
        char continuar = "s".charAt(0);

        System.out.println("Calculadora de sueldo de empleados\n");

        //Ingresar precios de los autos hasta que el usuario desee
        while (continuar == 's') {
            System.out.print("Ingrese el precio del auto vendido: ");
            double precioAuto = Utilidades.tranformStringDouble(sc.nextLine());

            totalAutos++;
            totalVentas += precioAuto;

            if (precioAuto > 10000.0) {
                comision += 250.0;
            }

            System.out.print("¿Desea ingresar otro auto? (S/n): ");
            String aux = sc.nextLine();
            if(!aux.equals("")){
                continuar = aux.toLowerCase().charAt(0);
            }
        }

        utilidad = totalVentas * 0.05;
        sueldoTotal = sueldoFijo + comision + utilidad;

        System.out.println("\n--- Informe ---");
        System.out.println("Total de autos vendidos: " + totalAutos);
        System.out.println("Valor total de ventas: " + Utilidades.redondear((float)totalVentas));
        System.out.println("Sueldo fijo: " + Utilidades.redondear((float)sueldoFijo));
        System.out.println("Comisiones: " + Utilidades.redondear((float)comision));
        System.out.println("Utilidad: " + Utilidades.redondear((float)utilidad));
        System.out.println("Sueldo total: " + Utilidades.redondear((float)sueldoTotal));
    }
}
