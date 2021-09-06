package com.example.tpn1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //Controles de ingresos
    private boolean bNombre = true;
    private boolean bApellido = true;
    private boolean bTelefono = true;
    private boolean bEmail = true;
    private boolean bFechaNacimiento = true;

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
        if(controlNombre(nombre) || controlCorreo(email)) {
            obj_editor.commit();
        }else{
            if(controlNombre(nombre))
                Toast.makeText(this, "Corrobore el formato del nombre", Toast.LENGTH_SHORT).show();
            if(controlCorreo(email))
            Toast.makeText(this,"Corrobore el formato del nombre",Toast.LENGTH_SHORT).show();

        }



        //este almacenamiento seria para cuando seleccionan in item del listview del listar.xml traiga los datos extras del contacto almacenado.
        SharedPreferences preferencias_extra = getSharedPreferences("datosextra", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor_extra=preferencias_extra.edit();
        String clave=nombre+apellido+" - "+email;
        String datos="Datos Perosnales telefono: " +telefono+ ", direccion: "+ direccion+ ", fecha nacimiento: " + fecha + " ; ";
        String datos2="Interes musica: " + musica + ", deporte: " + deporte + ", arte: " + arte + ", tecnologia: " + tecnologia + " ; " ;
        String datos3="Estudio Primario Completo: " + primario_c + ", primario imcmpleto: " + primario_i +
                ", Secundario completo" + secuendario_c + ", secuendario incompleto: " + secuendario_i + ", otros: " + otros_estudios +
                ", desea info: " + Desea_info;

        obj_editor_extra.putString(clave, datos+datos2+datos3);

        obj_editor_extra.commit();
        Toast.makeText(this,"Los datos se almacenaron correctamente",Toast.LENGTH_SHORT).show();
    }

    public boolean controlCorreo(String email){
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
        } else {
            System.out.println("El email ingresado es inválido.");
            return false;
        }
        return true;
    }

    public boolean controlNombre(String nombre) {
        for (int i = 0; i < nombre.length(); i++) {
            if (Character.isDigit(i))
                return false;
        }
        return true;
    }

}