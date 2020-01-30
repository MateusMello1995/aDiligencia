package com.example.diligencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class consulta_cep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pegar os dados da tela
        final EditText cep = findViewById(R.id.txtCep);
        final TextView resposta = findViewById(R.id.txtResposta);

        final Button btnBuscarCep = findViewById(R.id.btnBuscarCep);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //pegar dados na tela
                EditText cep = findViewById(R.id.txtCep);
                //transforma=los em texto
                String cepString = cep.getText().toString();

                //verificar se campo CEP está vazio
                if (cepString.isEmpty()){

                    String resultado = "Campo CEP não pode estar vazio!";
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                }else {
                    try {
                        CEP retorno = new HttpService(cep.getText().toString()).execute().get();
                        resposta.setText(retorno.toString());
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    } catch (ExecutionException e) {

                        e.printStackTrace();
                    }
                }

            }
        });


    }
}
