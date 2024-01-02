package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class segunda_vista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_vista);

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String precio = intent.getStringExtra("precio");
        String category = intent.getStringExtra("categoria");
        String imagend = intent.getStringExtra("imagen");
        TextView txtTitulo = findViewById(R.id.txtnombre);
        TextView txtPrecio = findViewById(R.id.txtprecio);
        TextView txtcategoria = findViewById(R.id.txtcategoria);


        txtTitulo.setText(titulo);
        txtPrecio.setText(precio);
        txtcategoria.setText(category);

        ImageView imageView = (ImageView)findViewById(R.id.imagen);
        Glide.with(this).load(imagend).into(imageView);

    }
    public void pagar(View view){
        Intent intent = new Intent(segunda_vista.this, segunda_vista.class);
        startActivity(intent);
    }
}