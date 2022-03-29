package com.example.proyectofinal;

public class Categorias {
    String id, categorias, nombre, cantidad, nombre2, cantidad2, nombre3, cantidad3;

    public Categorias(String id, String categorias, String nombre, String cantidad, String nombre2, String cantidad2, String nombre3, String cantidad3) {
        this.id = id;
        this.categorias = categorias;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.nombre2 = nombre2;
        this.cantidad2 = cantidad2;
        this.nombre3 = nombre3;
        this.cantidad3 = cantidad3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getCantidad2() {
        return cantidad2;
    }

    public void setCantidad2(String cantidad2) {
        this.cantidad2 = cantidad2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getCantidad3() {
        return cantidad3;
    }

    public void setCantidad3(String cantidad3) {
        this.cantidad3 = cantidad3;
    }
}
