package com.example.myapplication.webservice;


import org.json.JSONException;

public interface Asynchtask {
    /**
     * ESta funcion retorna los datos devueltos por el ws
     * @param result
     */
    void processFinish(String result) throws JSONException;

}
