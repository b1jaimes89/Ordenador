package com.example.ordenador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Portada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (Exception e){

                }finally {
                    Intent intent = new Intent(Portada.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        timer.start();

    }
}
