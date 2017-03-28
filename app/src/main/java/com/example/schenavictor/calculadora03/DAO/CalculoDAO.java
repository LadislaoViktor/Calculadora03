package com.example.schenavictor.calculadora03.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.schenavictor.calculadora03.Conexao.Conexao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 08/03/2017.
 */
public class CalculoDAO {


    public void inserir(Context context, Calculo calculo){
        ContentValues values = new ContentValues();
        values.put("valorum",calculo.getValolorum());
        values.put("valordois",calculo.getValordois());
        values.put("operador",calculo.getOperador());
        values.put("resposta",calculo.getResposta());
        Conexao  cnx = new Conexao(context);

        SQLiteDatabase db =cnx.getWritableDatabase();
        long id = db.insert("calculo", null, values);
        db.close();

    }
    public List<Calculo> listar(Context context){
        Conexao conexao = new Conexao(context);
        SQLiteDatabase db = conexao.getReadableDatabase();
        String selectQuery = "SELECT * FROM calculo";
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Calculo> calculoLista = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Calculo calculo= new Calculo();
                calculo.setId(cursor.getLong(0));
                calculo.setValolorum(cursor.getDouble(1));
                calculo.setValordois(cursor.getDouble(2));
                calculo.setOperador(cursor.getString(3));
                calculo.setResposta(cursor.getDouble(4));
                calculoLista.add(calculo);
            } while (cursor.moveToNext());
            db.close();
        }
        return calculoLista;
    }


}
