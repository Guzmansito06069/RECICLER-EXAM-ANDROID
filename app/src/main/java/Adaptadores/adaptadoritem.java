package Adaptadores;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenrecycler.MainActivity2;
import com.example.examenrecycler.R;

import java.security.AccessController;
import java.util.List;

import Modelo.item;

public class adaptadoritem extends RecyclerView.Adapter<adaptadoritem.ViewHolder> {

    private List<item> Lista;
    public adaptadoritem(List<item> lista) {
        Lista = lista;
    }
    @NonNull
    @Override
    public adaptadoritem.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new adaptadoritem.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull adaptadoritem.ViewHolder holder, int position) {
item item = Lista.get(position);
holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return Lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Nombre;
        item item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre=itemView.findViewById(R.id.txt1);
            itemView.setOnClickListener(this);
        }

        public void bind(item i) {
         Nombre.setText(i.getNombre());
         item=i;
        }

        @Override
        public void onClick(View v) {
        switch (item.getId()){
            case 1:
                Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:8715252171"));

                v.getContext().startActivity(i);
            break;
            case 2:
                v.getContext().startActivity(new Intent(v.getContext(), MainActivity2.class));
            break;
            case 3:
                Uri uri = Uri.parse("https://www.google.com.mx");
                Intent inavegador = new Intent(Intent.ACTION_VIEW, uri);
                v.getContext().startActivity(inavegador);
                break;
            case 4:
                Intent o= new Intent(Intent.ACTION_DIAL);
                v.getContext().startActivity(o);
                break;
            case 5:
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");

// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

// Attempt to start an activity that can handle the Intent
                v.getContext().startActivity(mapIntent);
                break;
        }
    }
}
}
