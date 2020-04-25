package com.example.ordenador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.ordenador.R.string.anunciovacio;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText cuadronumero;
    Button botonordenar;
    ImageButton botonmas;
    String anunciovacio , elnum , agrego, vacio, error;

    int[] arreglonumeros = new int[0];
    int[] arreglotemp = new int[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        anunciovacio = getResources().getString(R.string.anunciovacio);
        vacio = getResources().getString(R.string.vacio);
        elnum = getResources().getString(R.string.elnum);
        agrego = getResources().getString(R.string.agrego);
        error = getResources().getString(R.string.error);



        cuadronumero = findViewById(R.id.cuadronumero);
        botonordenar = findViewById(R.id.botonordenar);
        botonmas = findViewById(R.id.botonmas);

        botonmas.setOnClickListener(this);
        botonordenar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String numero;

        switch (v.getId()) {

            case R.id.botonmas:

                try {

                    numero = cuadronumero.getText().toString();

                    if (validarInformacion(numero)) {
                        Toast.makeText(MainActivity.this, anunciovacio, Toast.LENGTH_SHORT).show();
                        cuadronumero.setError(vacio);

                    } else {
                        if(arreglonumeros.length == 0){
                            arreglonumeros = new int[1];
                            arreglonumeros[0] = Integer.parseInt(numero);
                            cuadronumero.setText("");
                            Toast.makeText(MainActivity.this, elnum + numero + agrego, Toast.LENGTH_SHORT).show();
                        }else{
                            if(arreglonumeros.length > 0) {
                                arreglotemp = new int[arreglonumeros.length + 1];

                                for (int i = 0; i <= (arreglonumeros.length - 1); i++) {
                                    arreglotemp[i] = arreglonumeros[i];
                                }

                                arreglotemp[arreglotemp.length - 1] = Integer.parseInt(numero);
                                arreglonumeros = new int[arreglotemp.length];

                                for (int i = 0; i <= (arreglotemp.length - 1); i++) {
                                    arreglonumeros[i] = arreglotemp[i];
                                }
                            }
                            cuadronumero.setText("");
                            Toast.makeText(MainActivity.this, elnum + numero + agrego, Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (Exception e) {

                    break;
                }

                break;

            case R.id.botonordenar:
                try {

                    if (listo(arreglonumeros)) {
                        Toast.makeText(MainActivity.this,error, Toast.LENGTH_SHORT).show();

                    } else {
                       Bundle bundle = new Bundle();
                       bundle.putIntArray("arreglo",arreglonumeros);
                       bundle.putInt("tam", arreglonumeros.length);
                        Intent intent = new Intent(MainActivity.this,Ordenados.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }
                    break;

                } catch (Exception e){
                    break;
                }

            default:
                break;

            }
        }

    private boolean listo (int[] tamano){
        if (2 > tamano.length) return true;
        return false;
    }

    private boolean validarInformacion (String numero){
       if (numero.equals("")) return true;
       return false;

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