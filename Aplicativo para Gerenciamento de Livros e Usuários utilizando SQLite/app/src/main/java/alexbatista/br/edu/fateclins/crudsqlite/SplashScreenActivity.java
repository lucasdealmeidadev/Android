package alexbatista.br.edu.fateclins.crudsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Esconder ActionBar
        getSupportActionBar().hide();

        // Exibir a tela em Modo FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Método para Execução da SplashScreen e acionamento para a próxima tela.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Redirecionar para LoginActivity.class.
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // 3000 milisegundos = 3 segundos;

    }
}
