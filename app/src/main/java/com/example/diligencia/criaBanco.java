package com.example.diligencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class criaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    private static final String TABELA = "usuario";
    private static final String NOME = "nome";
    private static final String EMAIL = "email";
    private static final String SENHA = "senha";
    private static final String SENHACONF = "senhaconf";
    private static final int VERSAO = 1;

    public criaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE"+TABELA+"("
                + NOME + " integer primary key autoincrement,"
                + EMAIL + " text,"
                + SENHA + " text,"
                + SENHACONF + " text"
                +")";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE [IF EXISTS]." + TABELA);
        onCreate(db);
    }
}
