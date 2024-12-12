package views;

import java.util.Scanner;

import controller.ejercicios.SueldoDeEmpleados;
import controller.ejercicios.CostosLlamadas;
import controller.ejercicios.FacturacionAgua;
import controller.ejercicios.Serie2;
import controller.util.Utilidades;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1-Sueldo de empleados");
        System.out.println("2-Costos de llamadas");
        System.out.println("3-Facturación del agua");
        System.out.println("4-Serie2");
        System.out.println();
        System.out.print("Opción: ");
        int opt=Utilidades.tranformStringInt(sc.nextLine());
        System.out.println();
        switch (opt) {
            case 1:
                SueldoDeEmpleados cse = new SueldoDeEmpleados();
                cse.ejecutar();
            break;
            case 2:
                CostosLlamadas cll = new CostosLlamadas();
                cll.ejecutar();
            break;
            case 3:
                FacturacionAgua fa = new FacturacionAgua();
                fa.ejecutar();
            break;
            case 4:
                Serie2 s2 = new Serie2();
                s2.ejecutar();
            break;
            default:
                System.out.println("Opción no válida");
            break;
        }
    }
}
