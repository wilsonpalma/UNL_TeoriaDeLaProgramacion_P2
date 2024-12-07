#include <stdio.h>

int main() {
    enum semana_laboral {LUNES = 1, MARTES, MIERCOLES, JUEVES, VIERNES};
    int dia = 1;  // Corrección: Agregar el punto y coma

    printf("Ingrese el número del día (1) para Lunes, (5) para Viernes): ");
    scanf("%d", &dia);

    // Corrección del bucle: Incluir límite inclusivo con <= VIERNES
    for (int i = LUNES; i <= VIERNES; i++) {
        printf("El día de la semana es: ");
        switch (i){    //Mostrar el nombre del día y no el número
            case 1:printf("Lunes\n");break;
            case 2:printf("Martes\n");break;
            case 3:printf("Miércoles\n");break;
            case 4:printf("Jueves\n");break;
            case 5:printf("Viernes\n");break;
        }

        if ((i % 2) == 0) {  // Verifica si es un día par
            printf("Hoy es un gran día para Teoría de la Programación\n");
        }

        if (dia == i) {  // Si se alcanza el día especificado, termina el bucle
            break;
        }
    }

    return 0;
}
