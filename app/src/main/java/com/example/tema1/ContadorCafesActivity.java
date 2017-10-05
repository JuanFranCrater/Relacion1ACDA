package com.example.tema1;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class ContadorCafesActivity extends AppCompatActivity implements View.OnClickListener{
    TextView texto;

    Button btnDescanso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_cafes);

        texto=(TextView) findViewById(R.id.txvContador);
       btnDescanso=(Button)findViewById(R.id.btnDescanso);

    }

    @Override
    public void onClick(View v)
    {
        btnDescanso.setEnabled(false);
        int minutos= Integer.parseInt(texto.getText().toString().substring(0,2));
        if(v==btnDescanso)
        {
            MyCountDownTimer miContador = new MyCountDownTimer(minutos*60,1000);
            miContador.start();
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
            texto.setText(minutos+":"+segundos);

        }

        @Override
        public void onFinish() {
        btnDescanso.setEnabled(true);
        }
    }

    }
