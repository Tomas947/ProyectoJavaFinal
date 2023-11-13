package com.mycompany.presentacion;

import com.mycompany.servicios.*;
import java.util.Scanner;

public class Presentacion {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String titulo;
        int opcion = 0;
        boolean bandera = false;

        interfaces biblioteca = new Inter_Implementacion();
        do {
            System.out.println("\t\t______________________________________");
            System.out.print("\t\t|Opciones:                           |\n"
                    + "\t\t|1. Buscar un libro.                 |\n"
                    + "\t\t|2. Listar libros en biblioteca      |\n"
                    + "\t\t|3. Buscar un libro en mi biblioteca.|\n"
                    + "\t\t|0. Salir.                           |\n");
            System.out.print("\t\t|____________________________________|\n");

            System.out.print("\t\t____________________________________");
            System.out.print("\n\t\t|Seleccione alguna: ");
            opcion = Integer.parseInt(in.nextLine());
            int seleccion = (int) opcion;
            System.out.print("\t\t\n");
            

            switch (seleccion) {
                case 1:
                    biblioteca.printData();
                    break;
                case 2:
                    biblioteca.listarLibros();
                    break;
                case 3:
                    System.out.print("\t\t|Ingrese el nombre del libro que quiere buscar es su biblioteca personal: ");
                    titulo = in.nextLine();
                    biblioteca.buscarLibro(titulo);

                    break;
                case 0:
                    bandera = true;
                    break;

                default:
                    System.out.println("\t\t|Opcion ingresada no existe, intentalo de nuevo.");
            }

        } while (bandera == false);

    }

}
