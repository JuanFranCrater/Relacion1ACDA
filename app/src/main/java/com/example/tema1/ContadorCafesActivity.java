package com.example.tema1;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ContadorCafesActivity extends AppCompatActivity implements View.OnClickListener{
    TextView texto;
    Button btnMenos;
    Button btnMas;
    Button btnDescanso;
    int numCafes;
    MediaPlayer alarma;
    TextView txvnumcafes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_cafes);

        txvnumcafes=(TextView)findViewById(R.id.txvCafes);
        texto=(TextView) findViewById(R.id.txvContador);
       btnDescanso=(Button)findViewById(R.id.btnDescanso);
        btnMas=(Button)findViewById(R.id.btnmas);
        btnMenos=(Button)findViewById(R.id.btnmenos);
        btnDescanso.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btnMas.setOnClickListener(this);

        numCafes = 0;
        alarma = MediaPlayer.create(this,R.raw.audio);

    }

    @Override
    public void onClick(View v)
    {
        int minutos= Integer.parseInt(texto.getText().toString().substring(0,2));
        if(v==btnDescanso)
        {
            btnDescanso.setEnabled(false);
            btnMenos.setEnabled(false);
            btnMas.setEnabled(false);
            MyCountDownTimer miContador = new MyCountDownTimer(minutos*60*1000,1000);
            miContador.start();

        }
        if(v==btnMas)
        {
            if(Integer.parseInt(texto.getText().toString().substring(0, 2)) < 60) {
                if((Integer.parseInt(texto.getText().toString().substring(0, 2))<9))
                {
                    texto.setText("0"+(Integer.parseInt(texto.getText().toString().substring(0, 2)) + 1) + ":00");
                }else {
                    texto.setText((Integer.parseInt(texto.getText().toString().substring(0, 2)) + 1) + ":00");
                }

            }
        }
        if(v==btnMenos)
        {
            if(Integer.parseInt(texto.getText().toString().substring(0, 2)) >1) {
                if((Integer.parseInt(texto.getText().toString().substring(0, 2))<=10))
                {
                    texto.setText("0"+(Integer.parseInt(texto.getText().toString().substring(0, 2)) - 1) + ":00");
                }else {
                    texto.setText((Integer.parseInt(texto.getText().toString().substring(0, 2)) - 1) + ":00");
                }

            }
        }
    }

    class MyCountDownTimer extends CountDownTimer
    {
        long minutos;
        long segundos;

        public MyCountDownTimer(long starTime, long interval) {
            super(starTime, interval);

        }

        @Override
        public void onTick(long l) {
            minutos= (l/1000)/60;
            segundos = (l/1000)%60;
            if(segundos<10) {
                texto.setText(minutos + ":0" + (segundos));
            }else
                {
                    texto.setText(minutos + ":" + segundos);
                }
        }

        @Override
        public void onFinish() {
        btnDescanso.setEnabled(true);
            btnMenos.setEnabled(true);
            btnMas.setEnabled(true);
            texto.setText("05:00");
            numCafes++;
            txvnumcafes.setText("Contador Cafe: "+numCafes);
            alarma.start();

        }
    }

    }
