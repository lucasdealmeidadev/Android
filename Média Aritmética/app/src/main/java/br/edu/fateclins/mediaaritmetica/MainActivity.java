package br.edu.fateclins.mediaaritmetica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                TextView nome = (TextView) findViewById(R.id.tvNome);
                TextView n1   = (TextView) findViewById(R.id.tvNota1);
                TextView n2   = (TextView) findViewById(R.id.tvNota2);

                if (nome.getText().toString().trim().isEmpty()) {
                    nome.setError("Campo obrigatório");
                    return;
                }

                if (n1.getText().toString().trim().isEmpty()) {
                    n1.setError("Campo obrigatório");
                    return;
                }

                if (n2.getText().toString().trim().isEmpty()) {
                    n2.setError("Campo obrigatório");
                    return;
                }

                Intent intent = new Intent (getContext(), ResultActivity.class);
                Bundle params = new Bundle();
                params.putString("nome", nome.getText().toString());
                params.putDouble("n1", Double.parseDouble(n1.getText().toString()));
                params.putDouble("n2", Double.parseDouble(n2.getText().toString()));

                intent.putExtras(params);
                startActivity(intent);
            }
        });
    }

    private Context getContext() {
        return this;
    }
}