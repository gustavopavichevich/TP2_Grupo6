package com.example.tpn1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class Formulario2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario2);

        //datos que se reciben del formulario agregar.java
        String nombre=getIntent().getStringExtra("nombre");
        String apellido=getIntent().getStringExtra("apellido");;
        String telefono=getIntent().getStringExtra("telefono");;
        String email=getIntent().getStringExtra("email");;
        String direccion=getIntent().getStringExtra("direccion");;
        String fecha=getIntent().getStringExtra("fecha");;
        String s1=getIntent().getStringExtra("spinner1");;
        String s2=getIntent().getStringExtra("spinner2");;

    }

}