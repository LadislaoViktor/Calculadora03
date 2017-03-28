package com.example.schenavictor.calculadora03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.schenavictor.calculadora03.Adaptador.Adapter_List_View;

public class SegundaActivity extends AppCompatActivity {
private Adapter_List_View AdapterListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        AdapterListView = new Adapter_List_View(this);
        ListView listView =(ListView)findViewById(R.id.listView);
        listView.setAdapter(AdapterListView);
    }
}
