package alexbatista.br.edu.fateclins.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        setContentView(R.layout.activity_login);

        final Button btLogin = (Button) findViewById(R.id.btnLogin);
        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextView textUser = (TextView) findViewById(R.id.user);
                TextView textPassword = (TextView) findViewById(R.id.password);

                if (textUser.getText().toString().trim().isEmpty()) {
                    textUser.setError("Campo obrigatório");
                    return;
                }
                if (textPassword.getText().toString().trim().isEmpty()) {
                    textPassword.setError("Campo obrigatório");
                    return;
                }

                UsuarioMyDatabasehelper myDB = new UsuarioMyDatabasehelper(LoginActivity.this);
                String user = textUser.getText().toString().trim();
                String password = textPassword.getText().toString().trim();

                if(myDB.findByLogin(user, password)){
                    Intent intent = new Intent(getContext(), EquipeActivity.class);
                    startActivity(intent);
                    alert("Bem-vindo, Login Aprovado com Sucesso");
                    finish();
                }else{
                    alert( "Login ou senha Incorretos");
                }
            }
        });
    }

    private Context getContext() {
        return this;
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
