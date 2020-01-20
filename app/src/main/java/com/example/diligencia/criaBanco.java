package com.example.diligencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class criaBanco extends SQLiteOpenHelper {
       private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "novousuario";
    public static final String ID = "_id;";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";
    private static final int VERSAO = 7;

    public criaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //criar tabela
        String sql = "CREATE TABLE "+TABELA+"(_id integer primary key autoincrement,"
                +NOME+" text,"
                +EMAIL+" text,"
                +SENHA+" text"
                +")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
