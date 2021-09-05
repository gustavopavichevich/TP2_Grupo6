package com.example.tpn1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;


public class listar extends AppCompatActivity {
    private ArrayList<String> datos;
    private ArrayAdapter<String> adaptador1;
    private ListView L_datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar);
        this.setTitle("Listado de Contactos");
        datos =new ArrayList<String>();
        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
        L_datos = (ListView) findViewById(R.id.lbcontactos);
        L_datos.setAdapter(adaptador1);
        CargarContactosAlmacenados();

    }

    private void CargarContactosAlmacenados()
    {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        Map<String,?> contactos = preferencias.getAll();
        for(Map.Entry<String,?> ele : contactos.entrySet()){
            datos.add(ele.getKey()+" - " +ele.getValue().toString());
        }

    }
    public void ObtenerDatosExtrasContacto(View view)
    {
        String key= L_datos.getSelectedItem().toString();
        SharedPreferences preferencias = getSharedPreferences("datosextra", Context.MODE_PRIVATE);
        String extras = preferencias.getString(key,"");
        Toast.makeText(this,extras,Toast.LENGTH_LONG).show();

    }
}