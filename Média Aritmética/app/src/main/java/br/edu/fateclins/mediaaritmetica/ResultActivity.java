package br.edu.fateclins.mediaaritmetica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setTitle("Média Final");

        Bundle args = getIntent().getExtras();
        String nome = args.getString("nome");
        Double n1 = args.getDouble("n1");
        Double n2 = args.getDouble("n2");
        Double result = (n1 + n2) / 2;

        TextView text = (TextView) findViewById(R.id.textView1);
        text.setLines(2);

        if(result >= 7){
            text.setText(Html.fromHtml("Olá <b>" + nome + "</b>, você está <b>aprovado</b>!"));
        }else if(result >= 6 && result < 7){
            text.setText(Html.fromHtml("Olá <b>" + nome + "</b>, você está de <b>exame</b>!"));
        }else{
            text.setText(Html.fromHtml("Olá <b>" + nome + "</b>, você está <b>reprovado</b>!"));
        }

        TextView text2 = (TextView) findViewById(R.id.textView2);
        text2.setText(Html.fromHtml("1° Nota: <b>" + n1 + "</b>"));

        TextView text3 = (TextView) findViewById(R.id.textView3);
        text3.setText(Html.fromHtml("2° Nota: <b>" + n2 + "</b>"));

        TextView text4 = (TextView) findViewById(R.id.textView4);
        text4.setText(Html.fromHtml("Média Final: <b>" + result + "</b>"));
    }
}