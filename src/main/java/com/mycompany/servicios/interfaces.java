
package com.mycompany.servicios;

import com.mycompany.domain.Libro;
import java.util.*;


public interface interfaces {
    
    List<Libro> ListaLibros = new ArrayList<>();
    
    void addToLibrary(List<String> datos);
    
    void listarLibros();
    
    void buscarLibro(String titulo);//esta parte en realidad se encarga la clase AccesoDatos
    
    void printData();
    
    void cleanTitle(String titulo);

    //public void addToLibrary(List<Object> datos);
    
}
