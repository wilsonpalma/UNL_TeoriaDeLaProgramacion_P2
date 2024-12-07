package controller.ejercicios;

import java.util.Scanner;

import controller.util.Utilidades;

public class CostosLlamadas {

    // Definimos las zonas como un ENUM
    enum Zona {
        NORTE(12, 2.75, "AMÉRICA DEL NORTE"),
        CENTRO(15, 1.89, "AMÉRICA CENTRAL"),
        SUR(18, 1.60, "AMÉRICA DEL SUR"),
        EUROPA(19, 3.5, "EUROPA"),
        ASIA(23, 4.5, "ASIA"),
        AFRICA(25, 3.1, "ÁFRICA"),
        OCEANIA(29, 3.0, "OCEANÍA"),
        RESTO(31, 6.0, "RESTO DEL MUNDO");

        int clave;
        double precioMinuto;
        String nombre;

        Zona(int clave, double precioMinuto, String nombre) {
            this.clave = clave;
            this.precioMinuto = precioMinuto;
            this.nombre = nombre;
        }
    }

    // Método para obtener la zona según la clave
    public static Zona getZona(int opt) {
        switch (opt) {
            case 12:
                return Zona.NORTE;
            case 15:
                return Zona.CENTRO;
            case 18:
                return Zona.SUR;
            case 19:
                return Zona.EUROPA;
            case 23:
                return Zona.ASIA;
            case 25:
                return Zona.AFRICA;
            case 29:
                return Zona.OCEANIA;
            case 31:
                return Zona.RESTO;
            default:
                return null; // Zona no válida
        }
    }
    // Método para obtener la zona según índice
    public static Zona getZonaPorIndice(int opt) {
        switch (opt) {
            case 0:
                return Zona.NORTE;
            case 1:
                return Zona.CENTRO;
            case 2:
                return Zona.SUR;
            case 3:
                return Zona.EUROPA;
            case 4:
                return Zona.ASIA;
            case 5:
                return Zona.AFRICA;
            case 6:
                return Zona.OCEANIA;
            case 7:
                return Zona.RESTO;
            default:
                return null; // Zona no válida
        }
    }

    // Función para mostrar las zonas disponibles
    public static void mostrarZonas() {
        System.out.println("Zonas disponibles:");
        for (int i = 0; i < 8; i++) { // Hay 8 zonas
            Zona zona = getZonaPorIndice(i);
            if (zona != null) {
                System.out.println("Clave: " + zona.clave + " - " + zona.nombre + " - Precio por minuto: " + zona.precioMinuto + " USD");
            }
        }
        System.out.println();
    }

    public static void ejecutar(){
        Scanner sc = new Scanner(System.in);

        // Mostrar las zonas disponibles antes de solicitar datos
        mostrarZonas();

        // Solicitar datos al usuario
        System.out.println("Ingrese la clave de la zona geográfica:");
        int clave = Utilidades.tranformStringInt(sc.nextLine());

        System.out.println("Ingrese el número de minutos hablados:");
        double minutos = Utilidades.tranformStringDouble(sc.nextLine());

        // Obtener la zona y precio por minuto
        Zona zonaSeleccionada = getZona(clave);
        if (zonaSeleccionada == null) {
            System.out.println("Clave de zona no válida.");
        } else {
            double costoTotal = zonaSeleccionada.precioMinuto * minutos;
            System.out.println("Zona seleccionada: " + zonaSeleccionada.nombre);
            System.out.println("El costo total de la llamada es: "+Utilidades.redondear((float)costoTotal)+" USD");
        }
    }
}
