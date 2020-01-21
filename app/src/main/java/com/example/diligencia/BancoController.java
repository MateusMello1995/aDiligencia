package com.example.diligencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import static com.example.diligencia.criaBanco.EMAIL;
import static com.example.diligencia.criaBanco.SENHA;
import static com.example.diligencia.criaBanco.TABELA;

public class BancoController {

    private SQLiteDatabase db;
    private criaBanco banco;

    public BancoController(Context context){

        banco = new criaBanco(context);
    }

    public String insereDado(String nome, String email, String senha){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(criaBanco.NOME, nome);
        valores.put(EMAIL, email);
        valores.put(SENHA, senha);

        resultado = db.insert(TABELA, null, valores);
        db.close();

        if (resultado ==-1) {

            return "Erro ao inserir registro";

        }else {

            return "Registro inserido com sucesso";
        }

    }

    public Cursor fazerLogin(String email, String senha){

        db = banco.getWritableDatabase();
        String sql = "SELECT * FROM "+TABELA+" WHERE "+EMAIL+" = ? AND "+SENHA+" = ?";
        String[] selectionArgs = new String[]{ email, senha };
        Cursor cursor = db.rawQuery(sql,selectionArgs);

        if(cursor != null) {

            cursor.moveToFirst();
            return cursor;

        }else{

            return null;
        }
    }

}
