package com.example.diligencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button botao = (Button) findViewById(R.id.btn_cadastrar);

        //voltar para a tela login
       final Intent intent = new Intent(this, login.class);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BancoController crud = new BancoController(getBaseContext());

                //pegar os dados da tela
                EditText nome = (EditText)findViewById(R.id.nome);
                EditText email = (EditText)findViewById(R.id.email);
                EditText senha = (EditText)findViewById(R.id.senha);
                EditText senhaConf = (EditText)findViewById(R.id.repete_senha);

                //transforma-los em texto
                String nomeString = nome.getText().toString();
                String emailString = email.getText().toString();
                String senhaString = senha.getText().toString();
                String senhaConfString = senhaConf.getText().toString();

                //verificar se ha campos em branco
                if (nomeString.isEmpty() || emailString.isEmpty() || senhaString.isEmpty() || senhaConfString.isEmpty()){

                    String resultado = "Preencha todos os campos!";
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                }else {

                    //verificar senhas iguais
                    if (senhaString.equals(senhaConfString)){

                        //String resultado = "Cadastro realizado com sucesso!";
                        String resultado = crud.insereDado(nomeString,emailString,senhaString);
                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                        startActivity(intent);

                    }else {

                        String resultado = "As senhas não conferem!";
                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    }


                }




            }


        });


    }


}
