package com.example.schenavictor.calculadora03.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schenavictor.calculadora03.Contas;
import com.example.schenavictor.calculadora03.DAO.Calculo;
import com.example.schenavictor.calculadora03.DAO.CalculoDAO;
import com.example.schenavictor.calculadora03.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by 2015102617 on 20/03/2017.
 */
public class Adapter_List_View extends BaseAdapter{
    private List<Calculo> listacontas;
    private LayoutInflater inflater;
    private Context context;

    public Adapter_List_View(Context context){
        listacontas = new CalculoDAO().listar(context);
        this.context=context;
    }

    @Override
    public int getCount() {
        return listacontas.size();
    }

    @Override
    public Object getItem(int i) {

        return listacontas.get(i);
    }

    @Override
    public long getItemId(int i) {

        return listacontas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater==null)
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null)
            view=inflater.inflate(R.layout.item_list_view,null);


        TextView textViewvalorum = (TextView) view.findViewById(R.id.textViewvalorum);
        TextView textViewoperacao=(TextView) view.findViewById(R.id.textViewoperacao);
        TextView textViewvalordois=(TextView) view.findViewById(R.id.textViewvalordois);
        TextView textViewresultado=(TextView) view.findViewById(R.id.textViewresultado);

        Calculo umCalculo = listacontas.get(i);
        textViewvalorum.setText(umCalculo.getValolorum()+"");
        textViewoperacao.setText(umCalculo.getOperador()+"");
        textViewvalordois.setText(umCalculo.getValordois()+"");
        textViewresultado.setText(umCalculo.getResposta()+"");
        return view;
    }
}
