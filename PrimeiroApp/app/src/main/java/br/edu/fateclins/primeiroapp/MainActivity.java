package br.edu.fateclins.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "br.edu.fateclins.primeiroapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = (Button) findViewById(R.id.button1);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent     = new Intent(getContext(), DisplayMessageActivity.class);
                EditText editText = (EditText) findViewById(R.id.textView1);
                String message    = editText.getText().toString();

                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }

    private Context getContext() {
        return this;
    }

    public void sendMessage(View view){
        Intent intent     = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.textView1);

        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}