package controller.ejercicios;

import java.util.Scanner;

import controller.util.Utilidades;

public class FacturacionAgua {
    public void ejecutar(){
        Scanner sc = new Scanner(System.in);
        
        // Entrada de datos
        System.out.print("Ingrese consumo en m³: ");
        double consumo = Utilidades.tranformStringDouble(sc.nextLine());
        System.out.print("Tipo de contribuyente (1-General, 2-Tercera Edad, 3-Discapacitado): ");
        int tipoContribuyente = Utilidades.tranformStringInt(sc.nextLine());
        
        double porcentajeDiscapacidad = 0;
        if (tipoContribuyente == 3) {
            System.out.print("Ingrese porcentaje de discapacidad: ");
            porcentajeDiscapacidad = Utilidades.tranformStringDouble(sc.nextLine());
        }
        if(tipoContribuyente==1 || tipoContribuyente==2 || tipoContribuyente==3 && consumo>=0){
            // Cálculo del servicio de agua potable
            double valorAguaPotable;
            
            if (consumo <= 15) {
                valorAguaPotable = 3.00;
            } else if (consumo <= 25) {
                valorAguaPotable = 3.00 + (consumo - 15) * 0.10;
            } else if (consumo <= 40) {
                valorAguaPotable = 3.00 + (10 * 0.10) + (consumo - 25) * 0.20;
            } else if (consumo <= 60) {
                valorAguaPotable = 3.00 + (10 * 0.10) + (15 * 0.20) + (consumo - 40) * 0.30;
            } else {
                valorAguaPotable = 3.00 + (10 * 0.10) + (15 * 0.20) + (20 * 0.30) + (consumo - 60) * 0.35;
            }
            
            // Aplicar descuentos
            if (tipoContribuyente == 2) { // Tercera edad
                if (consumo <= 15) {
                    valorAguaPotable -= valorAguaPotable * 0.50;
                } else {
                    valorAguaPotable -= 3.00 * 0.30;
                }
            } else if (tipoContribuyente == 3) { // Discapacitado
                valorAguaPotable -= 3.00 * (porcentajeDiscapacidad / 100);
            }
            
            // Cálculo de otros rubros
            double impuestoAlcantarillado = valorAguaPotable * 0.35;
            double tasaBasura = 0.75;
            double tasaProcesamiento = 0.50;
            double total = valorAguaPotable + impuestoAlcantarillado + tasaBasura + tasaProcesamiento;
            
            // Mostrar resultados
            System.out.println("Valor Agua Potable: $" + valorAguaPotable);
            System.out.println("Impuesto Alcantarillado: $" + Utilidades.redondear((float)impuestoAlcantarillado));
            System.out.println("Tasa Recolección Basura: $" + tasaBasura);
            System.out.println("Tasa Procesamiento Datos: $" + tasaProcesamiento);
            System.out.println("Total a Pagar: $" + total);
        }
        else{System.out.println("Contribuyente no válido o consumo no válido (ingrese consumo positivo)");}
    }
}