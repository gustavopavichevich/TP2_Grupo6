package com.example.tpn1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Continuar (View view)
    {
        Intent continuar = new Intent( this, agregar.class);
        startActivity(continuar );
    }


    public void Ejer_1 (View view)
    {
        Intent ejer_1 = new Intent( this, agregar.class);
        startActivity(ejer_1 );
    }
    //Metodo del boton ejercicio 2, Calculadora.

    public void Ejer_2 (View view)
    {
        Intent ejer_2 = new Intent( this, listar.class);
        startActivity(ejer_2 );
    }



   @Override public boolean onCreateOptionsMenu(Menu mimenu){

        getMenuInflater().inflate(R.menu.menu_nuevo,mimenu);
        return true;
    }

   @Override public boolean onOptionsItemSelected(MenuItem opcionMenu) {
        int id = opcionMenu.getItemId();
        if (id == R.id.ListarContactos) {
            Ejer_2(null);
            return true;
        }

        if (id == R.id.AgregarContactos) {
            Ejer_1(null);
            return true;
        }

        return super.onOptionsItemSelected(opcionMenu);
    }
}