package alexbatista.br.edu.fateclins.crudsqlite;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UsuarioUpdateActivty extends AppCompatActivity {

    EditText txt_name, txt_login, txt_password;
    Button update_button, delete_button;

    String id, name, login, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario_activity_update);

        txt_name = findViewById(R.id.txt_nome);
        txt_login = findViewById(R.id.txt_login);
        txt_password = findViewById(R.id.txt_password);

        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txt_name.getText().toString().trim().isEmpty()) {
                    txt_name.setError("Campo obrigatório");
                    return;
                }
                if (txt_login.getText().toString().trim().isEmpty()) {
                    txt_login.setError("Campo obrigatório");
                    return;
                }
                if (txt_password.getText().toString().trim().isEmpty()) {
                    txt_password.setError("Campo obrigatório");
                    return;
                }

                //And only then we call this
                UsuarioMyDatabasehelper myDB = new UsuarioMyDatabasehelper(UsuarioUpdateActivty.this);
                name = txt_name.getText().toString().trim();
                login = txt_login.getText().toString().trim();
                senha = txt_password.getText().toString().trim();
                myDB.updateData(id, name, senha, login);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("user_id") && getIntent().hasExtra("user_name") &&
                getIntent().hasExtra("user_login") && getIntent().hasExtra("user_password")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("user_id");
            name = getIntent().getStringExtra("user_name");
            login = getIntent().getStringExtra("user_login");
            senha = getIntent().getStringExtra("user_password");

            //Setting Intent Data
            txt_name.setText(name);
            txt_login.setText(login);
            txt_password.setText(senha);
            Log.d("stev", name+" "+login+" "+senha);
        }else{
            Toast.makeText(this, "Nenhum registro foi encontrado!", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Excluir " + name + " ?");
        builder.setMessage("Tem certeza de que deseja excluir " + name + " ?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                UsuarioMyDatabasehelper myDB = new UsuarioMyDatabasehelper(UsuarioUpdateActivty.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
