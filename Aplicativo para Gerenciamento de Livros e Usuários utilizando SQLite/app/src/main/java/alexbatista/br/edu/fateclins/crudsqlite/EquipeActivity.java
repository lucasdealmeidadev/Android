package alexbatista.br.edu.fateclins.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EquipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Equipe");
        setContentView(R.layout.activity_equipe);

        final Button btnLivro = (Button) findViewById(R.id.btnLivro);
        btnLivro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final Button btnUsuario = (Button)  findViewById(R.id.btnUsuario);
        btnUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UsuarioMainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private Context getContext() {
        return this;
    }
}
