package alexbatista.br.edu.fateclins.crudsqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UsuarioAddActivicty extends AppCompatActivity {

    EditText nome, login, senha;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Cadastrar usuário");
        setContentView(R.layout.activity_usuario_add);


        nome = findViewById(R.id.id_cad_nome);
        login = findViewById(R.id.id_cad_senha);
        senha = findViewById(R.id.id_cad_usuario);
        add_button = findViewById(R.id.id_cad_send);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nome.getText().toString().trim().isEmpty()) {
                    nome.setError("Campo obrigatório");
                    return;
                }
                if (login.getText().toString().trim().isEmpty()) {
                    login.setError("Campo obrigatório");
                    return;
                }
                if (senha.getText().toString().trim().isEmpty()) {
                    senha.setError("Campo obrigatório");
                    return;
                }

                UsuarioMyDatabasehelper myDB = new UsuarioMyDatabasehelper(UsuarioAddActivicty.this);
                myDB.addUser(nome.getText().toString().trim(),
                        login.getText().toString().trim(),
                        senha.getText().toString().trim());

                nome.setText(null);
                login.setText(null);
                senha.setText(null);
            }
        });
    }
}
