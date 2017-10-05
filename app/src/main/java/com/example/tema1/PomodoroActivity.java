package com.example.tema1;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PomodoroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro);
    }
}
class CicloPomodoro
{
    int tiempoSesion;
    int descansoCorto;
    int descansoLargo;
    public CicloPomodoro(int tiempo, int descorto, int deslargo)
    {
        tiempoSesion=tiempo;
        descansoCorto=descorto;
        descansoLargo=deslargo;
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

            }else
            {

            }
        }

        @Override
        public void onFinish() {


        }
    }
}
