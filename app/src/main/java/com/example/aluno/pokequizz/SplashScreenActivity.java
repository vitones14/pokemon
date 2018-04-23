package com.example.aluno.pokequizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    private float rotation;
    private ImageView imagem;
    private ProgressBar barra;
    private int progresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Timer timer=new Timer();
        imagem = (ImageView) findViewById(R.id.imagempokemon);
        barra = (ProgressBar) findViewById(R.id.progressBar);
       progresso = 0;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
        progresso+=1;

                processaRotacao();
                barra.setProgress(progresso);

                if (progresso ==10000);
                {
                    Intent i = new Intent(SplashScreenActivity.this,LoginActivity.class);
                    startActivity(i);
                    this.cancel();
                    SplashScreenActivity.this.finish();

                }




            }
        },10
        ,100);

    }

    private void processaRotacao() {
        rotation += 50;

        imagem.setRotation(rotation);

        if (rotation == 360){
            rotation = 0;
        }
    }
}
