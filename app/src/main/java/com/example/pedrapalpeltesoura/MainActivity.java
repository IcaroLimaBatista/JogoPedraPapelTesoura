package com.example.pedrapalpeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageApp;
    TextView resultadoTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageApp = findViewById(R.id.imageAPP);
        resultadoTexto = findViewById(R.id.textResultado);

    }

    String[] opcoesGame = {
            "pedra", "papel", "tesoura" //0, 1, 2
    };
    String escolhaPlayer;
    String escolhaMaquina;

    public void selecionarPedra(View view){
        escolhaPlayer= opcoesGame[0];
        int numeroAleatorio = new Random().nextInt(3);
        escolhaMaquina = opcoesGame[numeroAleatorio];
        verificarGanhador();
        escolhaMaquinaFoto();
    }

    public void selecionarPapel(View view){
        escolhaPlayer= opcoesGame[1];
        int numeroAleatorio = new Random().nextInt(3);
        escolhaMaquina = opcoesGame[numeroAleatorio];
        verificarGanhador();
        escolhaMaquinaFoto();

    }

    public void selecionarTesoura(View view){
        escolhaPlayer= opcoesGame[2];
        int numeroAleatorio = new Random().nextInt(3);
        escolhaMaquina = opcoesGame[numeroAleatorio];
        verificarGanhador();
        escolhaMaquinaFoto();

    }

    private void escolhaMaquinaFoto(){
        if (escolhaMaquina == "pedra"){
            imageApp.setImageResource(R.drawable.pedra);
        }else if(escolhaMaquina == "papel"){
            imageApp.setImageResource(R.drawable.papel);
        }else{
            imageApp.setImageResource(R.drawable.tesoura);
        }
    }

    private void verificarGanhador(){
        //Se Maquina ganhar
        if ((escolhaMaquina == "pedra" && escolhaPlayer == "tesoura") ||
           (escolhaMaquina == "papel" && escolhaPlayer == "pedra") ||
           (escolhaMaquina == "tesoura" && escolhaPlayer == "papel"))
        {
            resultadoTexto.setText("Você perdeu ):");
        }
        else if ((escolhaPlayer == "pedra" && escolhaMaquina == "tesoura") ||
                (escolhaPlayer == "papel" && escolhaMaquina == "pedra") ||
                (escolhaPlayer == "tesoura" && escolhaMaquina == "papel"))
        {
            resultadoTexto.setText("Você ganhou (:");
        }
        else
        {
            resultadoTexto.setText("Empate");
        }

    }

}