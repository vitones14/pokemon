package com.example.aluno.pokequizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private TextView txtNome;
    private TextView txtPontos;
    private TextView txtQPokemon;
    private Button btnDica;
    private EditText edtPokebox;
    private ImageView imgPoke;
    AppPokequizz app;
    Pokemon pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = (TextView) findViewById(R.id.txtNome);
        txtPontos = (TextView) findViewById(R.id.txtPontos);
        txtQPokemon = (TextView) findViewById(R.id.txtQPokemon);
        btnDica = (Button) findViewById(R.id.btnDica);
        edtPokebox = (EditText) findViewById(R.id.edtPokebox);
        imgPoke = (ImageView) findViewById(R.id.imgPoke);

        app = new AppPokequizz();

        iniciojogo();

        edtPokebox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                testaJogada();

            }
        });


    }


    public void testaJogada(){

        if(pokemon.nome.toUpperCase().equals(edtPokebox.getText().toString().toUpperCase())){
            imgPoke.setImageDrawable(getResources().getDrawable(pokemon.imagem));

            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        synchronized (this) {
                            wait(2000);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    iniciojogo();
                                }
                            });

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                    //startActivity(mainActivity);
                };
            };
            thread.start();


        }

    }

    public void iniciojogo(){



        pokemon = app.pokemonAelatorio();

        TextView txtNome = (TextView) findViewById(R.id.txtNome);
        TextView txtPontos = (TextView) findViewById(R.id.txtPontos);

        txtNome.setText("");
        txtPontos.setText("0000");
        imgPoke.setImageDrawable(getResources().getDrawable(pokemon.sombra));
        edtPokebox.setText("");

    }
}
