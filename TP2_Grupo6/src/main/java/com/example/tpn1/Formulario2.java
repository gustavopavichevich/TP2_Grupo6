package com.example.tpn1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class Formulario2 extends AppCompatActivity {

    private CheckBox cb_deporte;
    private CheckBox cb_arte;
    private CheckBox cb_musica;
    private CheckBox cb_tecnologia;

    private RadioButton rb_Primario_I;
    private RadioButton rb_Primario_C;
    private RadioButton rb_Secundario_I;
    private RadioButton rb_Secundario_C;
    private RadioButton rb_Otros;

    private Switch sw_Info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario2);
        //Datos del formulario2
        cb_deporte= (CheckBox) findViewById(R.id.check_deporte);
        cb_arte= (CheckBox) findViewById(R.id.check_arte);
        cb_musica= (CheckBox) findViewById(R.id.check_Musica);
        cb_tecnologia= (CheckBox) findViewById(R.id.check_Tecnologia);

        rb_Primario_I= (RadioButton) findViewById(R.id.radio_Primario_Incom);
        rb_Primario_C= (RadioButton) findViewById(R.id.radio_Primario_Com);
        rb_Secundario_I= (RadioButton) findViewById(R.id.radio_Secundario_incom);
        rb_Secundario_C= (RadioButton) findViewById(R.id.radio_Secundario_com);
        rb_Otros= (RadioButton) findViewById(R.id.radio_Otros);

        sw_Info= (Switch) findViewById(R.id.Swict_info);
    }
    // Metodo para el boton guardar, Almacene los datos internamente con SharedPreferences
    public void Guardar (View view)
    {
        //Datos que se reciben del formulario agregar.java
        String nombre=getIntent().getStringExtra("nombre");
        String apellido=getIntent().getStringExtra("apellido");
        String telefono=getIntent().getStringExtra("telefono");
        String email=getIntent().getStringExtra("email");
        String direccion=getIntent().getStringExtra("direccion");
        String fecha=getIntent().getStringExtra("fecha");
        String s1=getIntent().getStringExtra("spinner1");
        String s2=getIntent().getStringExtra("spinner2");

        //Datos del Formulario2(this)
        Boolean deporte = cb_deporte.isChecked();
        Boolean arte = cb_arte.isChecked();
        Boolean musica = cb_musica.isChecked();
        Boolean tecnologia = cb_tecnologia.isChecked();

        Boolean primario_c= rb_Primario_C.isChecked();
        Boolean primario_i= rb_Primario_I.isChecked();
        Boolean secuendario_c= rb_Secundario_C.isChecked();
        Boolean secuendario_i= rb_Secundario_I.isChecked();
        Boolean otros_estudios= rb_Otros.isChecked();

        String Desea_info= sw_Info.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor=preferencias.edit();

        obj_editor.putString(nombre+ " "+ apellido,email);
        /*obj_editor.putString(nombre,apellido);
        obj_editor.putString(nombre,telefono);
        obj_editor.putString(nombre,email);
        obj_editor.putString(nombre,direccion);
        obj_editor.putString(nombre,fecha);
        obj_editor.putString(nombre,s1);
        obj_editor.putString(nombre,s2);

        obj_editor.putBoolean(nombre,deporte);
        obj_editor.putBoolean(nombre,arte);
        obj_editor.putBoolean(nombre,musica);
        obj_editor.putBoolean(nombre,tecnologia);

        obj_editor.putBoolean(nombre,primario_c);
        obj_editor.putBoolean(nombre,primario_i);
        obj_editor.putBoolean(nombre,secuendario_c);
        obj_editor.putBoolean(nombre,secuendario_i);
        obj_editor.putBoolean(nombre,otros_estudios);

        obj_editor.putString(nombre,Desea_info);*/

        obj_editor.commit();
        Toast.makeText(this,"Los datos se almacenaron correctamente",Toast.LENGTH_SHORT).show();


    }
}