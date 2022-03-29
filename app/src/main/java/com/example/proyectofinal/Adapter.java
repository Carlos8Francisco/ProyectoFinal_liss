package com.example.proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter <Categorias>{


    Context context;
    List<Categorias> arraycategorias;

    public Adapter(@NonNull Context context, List<Categorias> arraycategorias) {
        super(context, R.layout.list_categorias,arraycategorias);
        this.context =context;
        this.arraycategorias = arraycategorias;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_categorias,null,true);
        TextView txt_id = view.findViewById(R.id.btid);
        TextView tvName = view.findViewById(R.id.txtnombre);

        txt_id.setText(arraycategorias.get(position).getId());
        tvName.setText(arraycategorias.get(position).getCategorias());

        return view;
    }
}
