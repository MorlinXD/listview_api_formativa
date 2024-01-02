package com.example.myapplication.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class Lista {

    private String imagenpro;
    private String category;
    private String precio;
    private String nombre;
    private String descripcion;

    public String getImagenpro() {
        return imagenpro;
    }
    public void setImagenpro(String imagenpro) {
        this.imagenpro = imagenpro;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Lista(JSONObject a) throws JSONException {
        nombre = a.getString("title").toString();
        category = a.getString("category").toString() ;
        precio = a.getString("price").toString();
        descripcion = a.getString("description").toString() ;
        imagenpro=a.getString("image").toString() ;
    }


    public static ArrayList<Lista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Lista> productos = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            productos.add(new Lista(datos.getJSONObject(i)));
        }
        return productos;
    }
}


