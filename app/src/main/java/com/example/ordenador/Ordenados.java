package com.example.ordenador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Ordenados extends AppCompatActivity {

    TextView txtnumarreglo;
   String inicio,fin;

//--------se implemento el metodo de bubbleSort bajo la funcion "elOrdenamiento"---------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenados);

        txtnumarreglo = findViewById(R.id.txtnumarreglo);
        inicio = getResources().getString(R.string.inicio);
        fin = getResources().getString(R.string.fin);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        int tam = bundle.getInt("tam");
        int[] arreglonumeros;

        String todo = "";

        arreglonumeros = bundle.getIntArray("arreglo");

        arreglonumeros = elOrdenamiento(arreglonumeros);
        //Toast.makeText(Ordenados.this, Arrays.toString(arreglonumeros), Toast.LENGTH_SHORT).show();

        for (int i =0; i< tam;i++){
            if (i == tam-1){
                todo = todo + arreglonumeros[i];}
            else{
                todo = todo + arreglonumeros[i]+" , ";
            }

        }
       txtnumarreglo.setText(inicio+ " " +todo+ " "+ fin);



    }




    private int[] elOrdenamiento(int[] arreglonumeros){
        int n = arreglonumeros.length;
        int aux;
        boolean flag;

        while(true)
        {
            flag = false;
            for (int i = 1;i < n;i++){
                if (arreglonumeros[i] < arreglonumeros[i-1]) {
                    aux = arreglonumeros[i];
                    arreglonumeros[i] = arreglonumeros[i-1];
                    arreglonumeros[i-1] = aux;
                    flag = true;
                }
            }

            if(flag == false)
                break;
        }

        return arreglonumeros;
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



}
