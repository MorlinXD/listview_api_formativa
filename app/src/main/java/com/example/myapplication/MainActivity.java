package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Adapter.AdaptadorLista;
import com.example.myapplication.Model.Lista;
import com.example.myapplication.webservice.Asynchtask;
import com.example.myapplication.webservice.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  implements Asynchtask
{

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstOpciones = (ListView)findViewById(R.id.lista_productos);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://fakestoreapi.com/products",
                datos, (Context) MainActivity.this, (Asynchtask) MainActivity.this);
        ws.execute("GET");
    }


    @Override
    public void processFinish(String result) throws JSONException {

        try {

            JSONArray JSONlistaUsuarios = new JSONArray(result);
            JSONlistaUsuarios=getFirstN(JSONlistaUsuarios,5);

            ArrayList<Lista> lstUsuarios = Lista.JsonObjectsBuild(JSONlistaUsuarios);


            AdaptadorLista adapatorLista = new AdaptadorLista(this, lstUsuarios);


            lstOpciones.setAdapter(adapatorLista);
        } catch (JSONException e) {
            e.printStackTrace();

        }
    }
    private JSONArray getFirstN(JSONArray jsonArray, int n) throws JSONException {
        JSONArray resultArray = new JSONArray();
        for (int i = 0; i < Math.min(n, jsonArray.length()); i++) {
            resultArray.put(jsonArray.getJSONObject(i));
        }
        return resultArray;
    }
}