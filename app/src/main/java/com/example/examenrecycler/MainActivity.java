package com.example.examenrecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.ArrayList;

import Adaptadores.adaptadoritem;
import Modelo.item;

public class MainActivity extends AppCompatActivity {
RecyclerView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=findViewById(R.id.Lista);
        String[] permisosNecesarios=new String[1];
        permisosNecesarios[0]= Manifest.permission.CALL_PHONE;
        verificarPermiso( permisosNecesarios);

    }

    private void verificarPermiso(String[] permisosNecesarios) {
        String[] permisosdenegados=new String[1];
        for(int x=0;x<permisosNecesarios.length;x++){
            if(ContextCompat.checkSelfPermission(this,permisosNecesarios[x])== PackageManager.PERMISSION_DENIED){
                permisosdenegados [x]=permisosNecesarios[x];
            } else {
                setLista();
            }
        }
        requestPermissions(permisosdenegados,300);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 300:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    setLista();
                }
                break;
        }

    }

    private void setLista() {
        ArrayList<item> items = new ArrayList<>();
        items.add(new item(1,"Llamar"));
        items.add(new item(2,"Ir a segunda actividad"));
        items.add(new item(3,"Abrir navegador"));
        items.add(new item(4,"Abrir telefono"));
        items.add(new item(5, "Abrir mapa"));

        lista.setHasFixedSize(true);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(new adaptadoritem(items));
    }
}