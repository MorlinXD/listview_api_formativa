package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.Lista;
import com.example.myapplication.R;
import com.example.myapplication.segunda_vista;

import java.util.ArrayList;

public class AdaptadorLista extends ArrayAdapter<Lista> {

    public AdaptadorLista(Context context, ArrayList<Lista> datos) {
        super(context, R.layout.seleccion, datos);
        for (Lista usuario : datos) {
            Log.d("AdaptadorUsuario", "Nombre: " + usuario.getNombre());
            Log.d("AdaptadorUsuario", "Email: " + usuario.getDescripcion());
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.seleccion, null);

        ImageView imageView = (ImageView)item.findViewById(R.id.imagen);
        Glide.with(getContext())
                .load(this.getItem(position).getImagenpro())
                .into(imageView);

        TextView lblCategoria = (TextView)item.findViewById(R.id.txtcategoria);
        lblCategoria.setText(getItem(position).getCategory().toString());

        TextView lblPrecio = (TextView)item.findViewById(R.id.txtprecio);
        lblPrecio.setText(getItem(position).getPrecio().toString());

        TextView lblNombreProducto = (TextView)item.findViewById(R.id.txtnombre);
        lblNombreProducto.setText(getItem(position).getNombre());

        TextView lblPrecioTexto = (TextView)item.findViewById(R.id.txtprec);
        lblPrecioTexto.setText("Price:");

        TextView lblDescripcion = (TextView)item.findViewById(R.id.txtdescripcion);
        lblDescripcion.setText(getItem(position).getDescripcion());

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), segunda_vista.class);

                intent.putExtra("titulo", getItem(position).getNombre());
                intent.putExtra("precio", getItem(position).getPrecio());
                intent.putExtra("categoria", getItem(position).getCategory());
                intent.putExtra("imagen", getItem(position).getImagenpro());
                getContext().startActivity(intent);
            }
        });
        return item;
    }
}
