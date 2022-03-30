package com.example.proyectofinal;

public class producto {
    private String nombre;
    private String direccion;
    private String total;

    public producto(String nombre, String direccion, String total) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
