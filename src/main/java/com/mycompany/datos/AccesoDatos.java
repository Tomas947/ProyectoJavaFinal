package com.mycompany.datos;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mycompany.domain.Libro;
import com.mycompany.servicios.Inter_Implementacion;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccesoDatos {

    public List<String> recoleccionDatos() {

        Scanner in = new Scanner(System.in);

        String nombreLibro = "";
        String titulo;
        String autor = "";
        String añoPublicacion = "";
        String categoria = "";
        String URL;
        int numPaginas = 0;
        

        try {

            nombreLibro = "El+Señor+de+los+anillos"; // hay q poner el + sino se rompe todo

            System.out.print("\t\t|Ingrese un libro: ");
            nombreLibro = in.nextLine();
            System.out.println("");

            nombreLibro = URLEncoder.encode(nombreLibro, "UTF-8");

            URL = "https://www.googleapis.com/books/v1/volumes?q=" + nombreLibro;
            

            //creamos una conexión a la URL de la API utilizando HttpURLConnection y se configura para enviar una solicitud HTTP GET.
            URL url = new URL(URL);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();//abrimos la conexion
            conexion.setRequestMethod("GET");//con esto estableemos el metodo de conexion como get

            //creamos un lector de entrada (BufferedReader) para leer la respuesta de la aapi.
            int respues = conexion.getResponseCode();

            if (respues != 200) {//si el codifo de respuesta es 200 significa que es valida, si es 500 es un bug del servidor, 400 una ruta masl construida

                throw new RuntimeException("Ocurrio un error" + respues);
            } else {

                BufferedReader lectura = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                StringBuilder respuesta = new StringBuilder();
                String inputLine;

                while ((inputLine = lectura.readLine()) != null) {

                    respuesta.append(inputLine);
                }

                lectura.close();

                // Analizo la respuesta JSON
                JsonObject json = JsonParser.parseString(respuesta.toString()).getAsJsonObject(); //se convierte en un objeto JSON.
                JsonArray items = json.getAsJsonArray("items");//el  campo items del objeto JSON contiene la información sobre los libros encontrados.

                if (items.size() > 0) {

                    JsonObject libroInfo = items.get(0).getAsJsonObject(); // Obtiene el primer libro en la lista de resultados

                    JsonObject volumeInfo = libroInfo.getAsJsonObject("volumeInfo");//este campo contiene los detalles del libro

                    titulo = volumeInfo.get("title").getAsString();

                    JsonArray autores = volumeInfo.getAsJsonArray("authors");

                    if (autores != null && autores.size() > 0) {
                        autor = autores.get(0).getAsString();
                    }
                    añoPublicacion = volumeInfo.get("publishedDate").getAsString();//nos da el año de publicación del libro.

                    // Obténiendo la categoría o categorías
                    JsonArray categorias = volumeInfo.getAsJsonArray("categories");

                    if (categorias != null && categorias.size() > 0) {
                        categoria = categorias.get(0).getAsString();
                    }

                    // Obtén el número total de hojas (páginas)
                    numPaginas = volumeInfo.get("pageCount").getAsInt();

                    System.out.println("\t\t|Titulo: " + nombreLibro);
                    System.out.println("\t\t|Autor: " + autor);
                    System.out.println("\t\t|Categoria: " + categoria);
                    System.out.println("\t\t|Año de publicacion: " + añoPublicacion);
                    System.out.println("\t\t|Numero de paginas: " + numPaginas);
                    
                } else {

                    System.out.println("Libro no encontrado");
                }
            }

            conexion.disconnect();

        } catch (Exception e) {

            e.printStackTrace();
        }
        
        String numPaginasStr = String.valueOf(numPaginas);
        
        //En este orden retornaremos la lista para despues poder extraer estos datos en el mismos orden
        List<String> datos = new ArrayList<>();
        datos.add(nombreLibro);
        datos.add(autor);
        datos.add(categoria);
        datos.add(añoPublicacion);
        datos.add(numPaginasStr);
        
       /* interfaces mensajero = new Inter_Implementacion();
        mensajero.addToLibrary(datos);*/
  
        return datos;// esto nno es lo mas conveniente pero bueno
        //tambien podriamos hacer q la funcion recoleccion de datos sea de tipo List<Object>
        //Pero es mas comodo laborar con String
    }
    
}
