package com.example.tpn1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class listar extends AppCompatActivity {
    TextView resultado;
    float valorReal1 = 0;
    float valorReal2 = 0;
    float valor1=0;
    float valor2=0;
    float res = 0;
    float n1=0;
    float n2=0;
    float n3=0;
    float n4=0;
    float n5=0;
    float n6=0;
    float n7=0;
    float n8=0;
    float n9=0;
    float n0=0;
    String operacion="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar);
        this.setTitle("Calculadora");
        resultado=findViewById(R.id.resultadoText);

    }



//    @Override public boolean onCreateOptionsMenu(Menu mimenu){
//
//        getMenuInflater().inflate(R.menu.menu_nuevo,mimenu);
//        return true;
//    }
//
//    @Override public boolean onCreateOptionsMenu(Menu mimenu){
//
//        getMenuInflater().inflate(R.menu.menu_nuevo,mimenu);
//        return true;
//    }



    public void Escribir0(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("0");
        }else{
            resultado.setText(resultado.getText()+"0");
        }
    }

    public void Escribir1(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("1");
        }else{
            resultado.setText(resultado.getText()+"1");
        }
    }
    public void Escribir2(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("2");
        }else{
            resultado.setText(resultado.getText()+"2");
        }
    }

    public void Escribir3(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("3");
        }else{
            resultado.setText(resultado.getText()+"3");
        }
    }
    public void Escribir4(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("4");
        }else{
            resultado.setText(resultado.getText()+"4");
        }
    }

    public void Escribir5(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("5");
        }else{
            resultado.setText(resultado.getText()+"5");
        }
    }

    public void Escribir6(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("6");
        }else{
            resultado.setText(resultado.getText()+"6");
        }
    }
    public void Escribir7(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("7");
        }else{
            resultado.setText(resultado.getText()+"7");
        }
    }

    public void Escribir8(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("8");
        }else{
            resultado.setText(resultado.getText()+"8");
        }
    }
    public void Escribir9(View view) {
        valor1=Float.parseFloat(resultado.getText().toString());
        if(valor1==0){
            resultado.setText("9");
        }else{
            resultado.setText(resultado.getText()+"9");
        }
    }

    public void EscribirMas(View view) {
        operacion  = "+";
        valorReal1=Float.parseFloat(resultado.getText().toString());
        resultado.setText("0");
    }
    public void EscribirDividir(View view) {
        operacion  = "/";
        valorReal1=Float.parseFloat(resultado.getText().toString());
        resultado.setText("0");
    }
    public void EscribirPor(View view) {
        operacion  = "*";
        valorReal1=Float.parseFloat(resultado.getText().toString());
        resultado.setText("0");
    }
    public void EscribirMenos(View view) {
        operacion  = "-";
        valorReal1=Float.parseFloat(resultado.getText().toString());
        resultado.setText("0");
    }

    public void Resultado(View view) {
        valorReal2=Float.parseFloat(resultado.getText().toString());

        if(operacion.equals("+")){
            resultado.setText("");
            res = valorReal1 + valorReal2;
        }
        if(operacion.equals("-")){
            resultado.setText("");
            res = valorReal1 - valorReal2;
        }
        if(operacion.equals("*")){
            resultado.setText("");
            res = valorReal1 * valorReal2;
        }
        if(operacion.equals("/")){
            resultado.setText("");
            try {
                res = valorReal1 / valorReal2;
            }catch(ArithmeticException ex){
                System.out.println("Division invalida");
            }
        }
        resultado.setText(String.valueOf(res));
        valor1=0;
        valor2=0;
        valorReal2=0;
        valorReal1=0;
    }

    public void BorrarResultado(View view) {
        resultado.setText("0");
        valor1=0;
        valor2=0;
        operacion="";
    }

}