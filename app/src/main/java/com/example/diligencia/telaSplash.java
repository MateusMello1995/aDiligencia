package com.example.diligencia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class telaSplash extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_splash);

        Handler handler = new Handler();
        handler.postDelayed(this, 4000);

    }

    @Override
    public void run(){

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


}