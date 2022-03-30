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

public class productoAdapter extends ArrayAdapter<producto> {


    public productoAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View result = convertView;
        if(result == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            result = inflater.inflate(R.layout.itempedido,null);
        }

        TextView nombre = (TextView) result.findViewById(R.id.nombre);
        TextView direccion = (TextView) result.findViewById(R.id.direccion);
        TextView total = (TextView) result.findViewById(R.id.total);


        producto itemproducto = getItem(position);
        nombre.setText(itemproducto.getNombre());
        direccion.setText(itemproducto.getDireccion());
        total.setText(itemproducto.getTotal());


        return result;
    }
}
