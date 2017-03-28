package com.example.schenavictor.calculadora03.Conexao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 2015102617 on 06/03/2017.
 */
public class Conexao extends SQLiteOpenHelper {

    private final static String BASE = "calculo";
    private final static int VERSAO=1;

    public Conexao(Context context){
        super(context,BASE,null,VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String CRIA_TABELA_calculo = "create table calculo("+
            "id integer primary key autoincrement,"+
            "valorum Real,"+
            "valordois Real," +
            "operador text,"+
            "resposta Real)";
        sqLiteDatabase.execSQL(CRIA_TABELA_calculo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
