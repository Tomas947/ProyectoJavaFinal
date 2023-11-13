package com.mycompany.domain;

public class Libro {

    private String nombreLibro;
    private String autor;
    private String añoPublicacion;
    private String categoria;
    private String numPaginas;

    public Libro(String nombreLibro, String autor, String añoPublicacion, String categoria, String numPaginas) {
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.categoria = categoria;
        this.numPaginas = numPaginas;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(String añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }



    @Override
    public String toString() {
        return "\t\t|Libro: " + "\n\t\t|Nombre del Libro: " + nombreLibro + "\n\t\t|Autor: " + autor + "\n\t\t|Año Publicacion: " + añoPublicacion + "\n\t\t|Categoria: " + categoria + "\n\t\t|Numero de Paginas: " + numPaginas+"\n";
    }
    
    
    

}
