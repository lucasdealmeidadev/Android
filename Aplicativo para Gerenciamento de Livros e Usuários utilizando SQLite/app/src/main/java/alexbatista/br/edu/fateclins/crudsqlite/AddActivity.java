package alexbatista.br.edu.fateclins.crudsqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Adicionar livro");
        setContentView(R.layout.activity_add);


        title_input = findViewById(R.id.titulo);
        author_input = findViewById(R.id.autor);
        pages_input = findViewById(R.id.paginas);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (title_input.getText().toString().trim().isEmpty()) {
                    title_input.setError("Campo obrigatório");
                    return;
                }
                if (author_input.getText().toString().trim().isEmpty()) {
                    author_input.setError("Campo obrigatório");
                    return;
                }
                if (pages_input.getText().toString().trim().isEmpty()) {
                    pages_input.setError("Campo obrigatório");
                    return;
                }

                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        Integer.valueOf(pages_input.getText().toString().trim()));

                title_input.setText(null);
                author_input.setText(null);
                pages_input.setText(null);
            }
        });
    }
}
