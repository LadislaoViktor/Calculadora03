package com.example.schenavictor.calculadora03;

import android.content.Context;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.schenavictor.calculadora03.DAO.Calculo;
import com.example.schenavictor.calculadora03.DAO.CalculoDAO;

public class Contas extends AppCompatActivity implements View.OnClickListener {
    EditText resultadoeditText ;
    Button btn1,btn2,btn3,btn4,btn5,btn6 ,btn7, btn8, btn9, btn0, btnsoma,btnsub,btnmult,btndiv,btnponto,btnlimpa,btnresult,btnabre;
    Double valor1 = null;
    Double valor2 = null;
    String operador = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contas);
        resultadoeditText = (EditText) findViewById(R.id.resultadoeditText) ;
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btn0=(Button)findViewById(R.id.btnzero);
        btnsoma=(Button)findViewById(R.id.btnsoma);
        btnsub=(Button)findViewById(R.id.btnsub);
        btndiv=(Button)findViewById(R.id.btndiv);
        btnmult=(Button)findViewById(R.id.btnmult);
        btnponto=(Button)findViewById(R.id.btnponto);
        btnlimpa=(Button)findViewById(R.id.btnlimpa);
        btnresult=(Button)findViewById(R.id.btnresultado);
        btnabre=(Button)findViewById(R.id.btnabre);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnsoma.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btnmult.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnponto.setOnClickListener(this);
        btnlimpa.setOnClickListener(this);
        btnresult.setOnClickListener(this);
        btnabre.setOnClickListener(this);
        hideKeyboard(this,resultadoeditText);
    }
    @Override
    public void onClick(View view) {
        int codigo = view.getId();
        String valorclic = "";
        switch (codigo){
            case R.id.btnzero:valorclic= "0";
                break;
            case R.id.btn1:valorclic= "1";
                break;
            case R.id.btn2:valorclic= "2";
                break;
            case R.id.btn3:valorclic= "3";
                break;
            case R.id.btn4:valorclic= "4";
                break;
            case R.id.btn5:valorclic= "5";
                break;
            case R.id.btn6:valorclic= "6";
                break;
            case R.id.btn7:valorclic= "7";
                break;
            case R.id.btn8:valorclic= "8";
                break;
            case R.id.btn9:valorclic= "9";
                break;
            case R.id.btnsoma:
                trataoperacao("+");
                break;
            case R.id.btnsub:
                trataoperacao("-");
                break;
            case R.id.btnmult:
                trataoperacao("*");
                break;
            case R.id.btndiv:
                trataoperacao("/");
                break;
            case R.id.btnresultado:
                trataoperacaoigual();
                break;
            case R.id.btnponto:valorclic= ".";
                if(resultadoeditText.getText().toString().contains("."))
                    valorclic=".";
                break;
            case R.id.btnlimpa:resultadoeditText.setText(" ");
                valor1=null;
                valor2=null;
                operador = null;
                resultadoeditText.setText(" ");
                break;
            case R.id.btnabre:
                Intent outraactivity = new Intent(this,SegundaActivity.class);
                outraactivity.putExtra("Resposta",resultadoeditText.getText().toString());
                startActivity(outraactivity);
                break;
        }
        resultadoeditText.setText(resultadoeditText.getText().toString()+valorclic);
    }
    private void trataoperacaoigual()
    {
        Double resultado=0.0;
        if(valor1 != null){
            try{
                valor2 = Double.parseDouble(resultadoeditText.getText().toString());
            }catch (NumberFormatException e){
                Toast.makeText(this,"Valor incorreto!",Toast.LENGTH_SHORT).show ();
            }
            switch (operador){
                case "+" :
                    resultado=valor1+valor2;
                    break;
                case "-":
                    resultado=valor1-valor2;
                    break;
                case "*":
                    resultado=valor1*valor2;
                    break;
                case "/":
                    if(valor1!=0)
                        resultado=valor1/valor2;
                    else
                        resultado = 0.0 ;
                    break;
            }
            resultadoeditText.setText(resultado.toString());
            new CalculoDAO().inserir(this,new Calculo(valor1,valor2,operador,resultado)  );

            for(Calculo calculo : new CalculoDAO().listar(this)){
                Log.d("MEUAPP", calculo.toString());
            }
        }
    }


    private void trataoperacao(String operacao)
    {
        this.operador = operacao;
        try{
            valor1 = Double.parseDouble(resultadoeditText.getText().toString());
        }catch (NumberFormatException e){
            Toast.makeText(this,"Valor incorreto!",Toast.LENGTH_SHORT).show ();
        }
        resultadoeditText.setHint(resultadoeditText.getText().toString());
        resultadoeditText.setText("");
    }
    public static void hideKeyboard(Context context, View editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}

