package com.example.tema1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SesionIniciadaActivity extends AppCompatActivity {

    int tiempoSesion;
    int descansoCorto;
    int descansoLargo;
    int numeroCiclos;
    int contador = 4;
    MediaPlayer alarma;
    TextView txvTiempo;
    TextView txvEstadoSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_iniciada);
        Bundle bnd;
       bnd= getIntent().getExtras();
       tiempoSesion=Integer.parseInt( bnd.getString("Sesion"));
        descansoCorto=Integer.parseInt( bnd.getString("Corto"));
        descansoLargo=Integer.parseInt( bnd.getString("Largo"));
        numeroCiclos=Integer.parseInt( bnd.getString("Ciclos"));
        txvTiempo=(TextView)findViewById(R.id.txtContador);
        txvEstadoSesion=(TextView)findViewById(R.id.txtEstado) ;
        MyCountSesionTimer inicioTimer = new MyCountSesionTimer(tiempoSesion*60*1000,1000);
        alarma = MediaPlayer.create(this,R.raw.audio);
        inicioTimer.start();

    }
    class MyCountSesionTimer extends CountDownTimer
    {
        long minutos;
        long segundos;

        public MyCountSesionTimer(long starTime, long interval) {
            super(starTime, interval);
        }

        @Override
        public void onTick(long l) {
            minutos= (l/1000)/60;
            segundos = (l/1000)%60;
            if(segundos<10) {
                txvTiempo.setText(minutos + ":0" + segundos);
            }else {txvTiempo.setText(minutos + ":" + segundos);}
        }

        @Override
        public void onFinish() {
            alarma.start();
            contador--;
            if(contador<=0)
            {
                contador=8;
                MyCountDescansoTimer descansoLargoTimer = new MyCountDescansoTimer(descansoLargo*60*1000,1000);
                descansoLargoTimer.start();
                txvEstadoSesion.setText("Descanso Largo");
                numeroCiclos--;
            }else
            {
                    MyCountDescansoTimer descansoCortoTimer = new MyCountDescansoTimer(descansoCorto*60*1000,1000);
                descansoCortoTimer.start();
                txvEstadoSesion.setText("Descanso Corto");

            }
        }
        }
        class MyCountDescansoTimer extends CountDownTimer
        {
            long minutos;
            long segundos;

            public MyCountDescansoTimer(long starTime, long interval) {
                super(starTime, interval);
            }

            @Override
            public void onTick(long l) {
                minutos= (l/1000)/60;
                segundos = (l/1000)%60;
                if(segundos<10) {
                    txvTiempo.setText(minutos + ":0" + segundos);
                }else {txvTiempo.setText(minutos + ":" + segundos);}
            }

            @Override
            public void onFinish() {
                alarma.start();
                if(numeroCiclos>0) {
                    contador--;
                    MyCountSesionTimer SesionTimer = new MyCountSesionTimer(tiempoSesion * 60 * 1000, 1000);
                    SesionTimer.start();
                    txvEstadoSesion.setText("Sesión");
                }else
                    {
                        txvEstadoSesion.setText("Fin");
                        txvTiempo.setText("");
                    }

            }
    }

}

