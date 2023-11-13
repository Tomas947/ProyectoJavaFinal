package com.mycompany.servicios;

import com.mycompany.datos.AccesoDatos;
import com.mycompany.domain.Libro;
import java.util.*;

public class Inter_Implementacion implements interfaces {

    Scanner in = new Scanner(System.in);
    AccesoDatos mediador = new AccesoDatos();

    @Override
    public void addToLibrary(List<String> datos) {

        String nombreLibro = "", autor = "", añoPublicacion = "", categoria = "", numPaginas = "";//inicializamos estos datos mediante la lista
        boolean bandera = false;
        int contador = 0, primerLibro = 0;

        //usamos la lista que resivimos
        for (String dat : datos) {

            switch (contador) {
                case 0:
                    nombreLibro = dat;
                    break;
                case 1:
                    autor = dat;
                    break;
                case 2:
                    categoria = dat;
                    break;
                case 3:
                    añoPublicacion = dat;
                    break;
                case 4:
                    numPaginas = dat;
                    break;
            }
            contador++;
        }
        
       // cleanTitle(nombreLibro);
        
        // Esto solo se ejecutara el el primer libro que  se añada
        if (primerLibro == 0) {
            
            Libro libro = new Libro(nombreLibro, autor, añoPublicacion, categoria, numPaginas);//inicializo los valores del libro  
            ListaLibros.add(libro);
            primerLibro = 1;
            
        } else {
            
            //Primero verifico que el libro no se encuentre
            for (Libro Libro : ListaLibros) {
                if (!Libro.getNombreLibro().equalsIgnoreCase(nombreLibro)) {//verifico mediante el nombre si ya se encuentra
                    //lo que quiero decir es:  !(true y true) = !(true) = false osea la unica manera de que la salida sea true incluyendo el !
                    //es que no se encuentre el libro, se inserta cuando sea falso que el libro se encuentra en la lista
                    bandera = true;
                    Libro libro = new Libro(nombreLibro, autor, añoPublicacion, categoria, numPaginas);//inicializo los valores del libro  
                    ListaLibros.add(libro);
                } else {
                    //System.out.println("El libro ya se encuentra en la biblioteca, se le niega añadirlo.");
                }
            }
            if (bandera == true) {
                System.out.println("\n\t\t|El libro se añadio a la biblioteca correctamente.");
            } else {
                System.out.println("\n\t\t|El libro ya se encuentra en biblioteca.");
            }
            System.out.println("");
        }
    }

    @Override
    public void listarLibros() {
        
        System.out.println("\t\t______________________________________");
        for (Libro Lib : ListaLibros) {
            System.out.println(Lib);
        }
        //System.out.print("\t\t_____________________________\n");
     
    }

    @Override
    public void buscarLibro(String titulo) {

        boolean isThereBooks = false;

        System.out.println("\t\t______________________________________");
        for (Libro Lib : ListaLibros) {
            if (Lib.getNombreLibro().equalsIgnoreCase(titulo)) {
                System.out.print("\t\t|El libro se encontro, sus datos son: \n");
                System.out.print(Lib);
                isThereBooks = true;
                break;
            }
        }
        System.out.print("\t\t______________________________________\n");
        if (isThereBooks == false) {
            System.out.println("\n\t\t|No se encuentran libros en su biblioteca");
        }
    }

    @Override
    public void printData() {

        int desicion = 0;
        List<String> datos;

        datos = (List<String>) (Object) mediador.recoleccionDatos();

        System.out.print("\nDesea guardar este libro en su biblioteca personal? 1 (SI), 2 (NO) o cualquier otro numero: ");
        desicion = in.nextInt();

        if (desicion == 1) {
            addToLibrary(datos);
        }
    }

    @Override
    public void cleanTitle(String titulo) {
        char title [] = null;
        
        for (int i = 0; i < titulo.length(); i++) {
            title[i] = titulo.charAt(i);                     
        }
        
        int i = 0;
        while(i <= titulo.length()){
       
            
        }
    }
}
