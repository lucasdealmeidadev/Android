package br.edu.fateclins.loginapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class BemVindoActivity extends DebugActivicty {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");
        Float valor1 = args.getFloat("valor1");
        Double valor2 = args.getDouble("valor2");

        Log.d("Nome: ", nome);
        Log.d("Valor1: ", String.valueOf(valor1));
        Log.d("Valor2: ", String.valueOf(valor2));

        TextView text = (TextView) findViewById(R.id.textView1);
        text.setLines(2);
        text.setText("Olá " + nome + ", seja bem-vindo!!!");

        TextView text2 = (TextView) findViewById(R.id.textView2);
        text2.setText("Valor1: " + valor1);
        TextView text3 = (TextView) findViewById(R.id.textView3);
        text3.setText("Valor2: " + valor2);

        Double resultado = valor1 - valor2;
        TextView text4 = (TextView) findViewById(R.id.textView4);
        text4.setText("Resultado: " + resultado.toString());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private Context getContext() {
        return this;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}