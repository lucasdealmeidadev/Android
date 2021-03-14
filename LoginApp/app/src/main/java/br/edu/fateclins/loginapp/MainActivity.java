package br.edu.fateclins.loginapp;

import androidx.appcompat.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends DebugActivicty {

    protected static final String TAG = "Marca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLogin = (Button) findViewById(R.id.btnLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, getClassName() + " => Acionamento do botão Login.");
                TextView tLogin = (TextView) findViewById(R.id.edtUsuario);
                TextView tSenha = (TextView) findViewById(R.id.edtSenha);

                final String LOGIN = "lucas";
                final String SENHA = "12345";

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                Log.i(TAG, getClassName() + " => Testa usuário e senha!!!");

                if (LOGIN.equals(login) && SENHA.equals(senha)) {

                    Intent intent = new Intent (getContext(), BemVindoActivity.class);
                    Bundle params = new Bundle();
                    params.putString("nome", "Lucas Almeida");
                    params.putFloat("valor1", 9.00f);
                    params.putDouble("valor2", 5.50);
                    intent.putExtras(params);
                    startActivity(intent);
                    alert("Bem-vindo, login realizado com sucesso!!!");
                    Log.i(TAG, getClassName() + " => Login do usuário efetuado com sucesso!!!");
                } else {
                    alert("Login ou senha incorretos!!!");
                    Log.i(TAG, getClassName() + " => Não possível entrar no aplicativo.");
                }
            }
        });
    }

    public void onBackPressed(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        Log.i(TAG, getClassName() + " => Objeto Criado: alertDialogBuilder.");

        alertDialogBuilder.setTitle("Confirmar Saída");
        alertDialogBuilder.setIcon(R.drawable.ic_exit);
        alertDialogBuilder.setMessage("Você tem certeza que deseja sair ?");
        alertDialogBuilder.setCancelable(false);
        Log.i(TAG, getClassName() + " => Objeto Configurado: alertDialogBuilder.");

        alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Log.i(TAG, getClassName() + ".onBackPressed() chamado. Botão Sim pressionado.");
            }
        });

        alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Você clicou em cancelar",
                        Toast.LENGTH_SHORT).show();
                Log.i(TAG, getClassName() + ".onBackPressed() chamado. Botão Não pressionado.");
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        Log.i(TAG, getClassName() + " => Objeto Criado e Visualizado: alertDialog.");
    }

    protected void onResume(){
        super.onResume();
        TextView tLogin = (TextView) findViewById(R.id.edtUsuario);
        tLogin.requestFocus();
        Log.i(TAG, getClassName() + " => Foco direcionado para o campo nome do usuário.");
    }

    private Context getContext() {
        Log.i(TAG, getClassName() + " => Passou pelo Contexto atual: " + this);
        return this; //faz referência ao out class
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        Log.i(TAG, getClassName() + " => Mensagem mostrada ao usuário.");
    }

    private String getClassName() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}