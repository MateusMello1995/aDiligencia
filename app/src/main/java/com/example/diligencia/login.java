package com.example.diligencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void proximaTela(View view){

        Intent intent = new Intent(this, page3.class);
        startActivity(intent);
    }

    public void proximaTela1 (View view){

        Intent intent = new Intent(this, cadastro.class);
        startActivity(intent);
    }
}
