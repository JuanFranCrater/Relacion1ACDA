package com.example.tema1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PomodoroActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnResSesion;
    Button btnMasSesion;
    Button btnResCorto;
    Button btnMasCorto;
    Button btnResLargo;
    Button btnMasLargo;
    Button btnResCiclos;
    Button btnMasCiclos;
    Button btninicio;
    TextView textoSesion;
    TextView textoCorto;
    TextView textoLargo;
    TextView textoCiclos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro);
        btninicio=(Button)findViewById(R.id.btnInicio);
        btnResSesion=(Button)findViewById(R.id.btnResSesion);
        btnMasSesion=(Button)findViewById(R.id.btnMasSesion);
        btnResCorto=(Button)findViewById(R.id.btnResCorto);
        btnMasCorto=(Button)findViewById(R.id.btnMasCorto);
        btnResLargo=(Button)findViewById(R.id.btnResLargo);
        btnMasLargo=(Button)findViewById(R.id.btnMasLargo);
        btnResCiclos=(Button)findViewById(R.id.btnResCiclos);
        btnMasCiclos=(Button)findViewById(R.id.btnMasCiclos);
         btnResSesion.setOnClickListener(this);
         btnMasSesion.setOnClickListener(this);
         btnResCorto.setOnClickListener(this);
         btnMasCorto.setOnClickListener(this);
         btnResLargo.setOnClickListener(this);
         btnMasLargo.setOnClickListener(this);
         btnResCiclos.setOnClickListener(this);
         btnMasCiclos.setOnClickListener(this);
         btninicio.setOnClickListener(this);
        textoSesion=(TextView)findViewById(R.id.txvSesion);
        textoCorto=(TextView)findViewById(R.id.txvCorto);
        textoLargo=(TextView)findViewById(R.id.txvLargo);
        textoCiclos=(TextView)findViewById(R.id.txvCiclo);
    }

    @Override
    public void onClick(View v) {
        if(v==btninicio)
        {
            Intent intnt = new Intent(this,SesionIniciadaActivity.class);
            Bundle bld = new Bundle();
            bld.putString("Sesion",textoSesion.getText().toString());
            bld.putString("Corto",textoCorto.getText().toString());
            bld.putString("Largo",textoLargo.getText().toString());
            bld.putString("Ciclos",textoCiclos.getText().toString());
            intnt.putExtras(bld);
            startActivity(intnt);
        }
        if(v==btnResSesion)
        {
            if(Integer.parseInt(textoSesion.getText().toString()) >1) {
                    if(Integer.parseInt(textoSesion.getText().toString())>=11)
                    {
                        textoSesion.setText(String.valueOf((Integer.parseInt(textoSesion.getText().toString()) - 1)));
                    }else
                        {
                            textoSesion.setText("0"+(Integer.parseInt(textoSesion.getText().toString()) - 1));
                        }

            }
        }
        if(v==btnMasSesion)
        {
            if(Integer.parseInt(textoSesion.getText().toString()) <99) {

                if(Integer.parseInt(textoSesion.getText().toString())>=9)
                {
                    textoSesion.setText(String.valueOf((Integer.parseInt(textoSesion.getText().toString()) + 1)));
                }else
                {
                    textoSesion.setText("0"+(Integer.parseInt(textoSesion.getText().toString()) + 1));
                }
            }
        }
        if(v==btnResCorto)
        {
            if(Integer.parseInt(textoCorto.getText().toString()) >1) {
                if(Integer.parseInt(textoCorto.getText().toString())>=11)
                {
                    textoCorto.setText(String.valueOf((Integer.parseInt(textoCorto.getText().toString()) - 1)));
                }else
                {
                    textoCorto.setText("0"+(Integer.parseInt(textoCorto.getText().toString()) - 1));
                }

            }
        }
        if(v==btnMasCorto)
        {
            if(Integer.parseInt(textoCorto.getText().toString()) <99) {

                if(Integer.parseInt(textoCorto.getText().toString())>=9)
                {
                    textoCorto.setText(String.valueOf((Integer.parseInt(textoCorto.getText().toString()) + 1)));
                }else
                {
                    textoCorto.setText("0"+(Integer.parseInt(textoCorto.getText().toString()) + 1));
                }
            }
        }
        if(v==btnResLargo)
        {
            if(Integer.parseInt(textoLargo.getText().toString()) >1) {
                if(Integer.parseInt(textoLargo.getText().toString())>=11)
                {
                    textoLargo.setText(String.valueOf((Integer.parseInt(textoLargo.getText().toString()) - 1)));
                }else
                {
                    textoLargo.setText("0"+(Integer.parseInt(textoLargo.getText().toString()) - 1));
                }

            }
        }
        if(v==btnMasLargo)
        {
            if(Integer.parseInt(textoLargo.getText().toString()) <99) {

                if(Integer.parseInt(textoLargo.getText().toString())>=9)
                {
                    textoLargo.setText(String.valueOf((Integer.parseInt(textoLargo.getText().toString()) + 1)));
                }else
                {
                    textoLargo.setText("0"+(Integer.parseInt(textoLargo.getText().toString()) + 1));
                }
            }
        }
        if(v==btnResCiclos)
        {
            if(Integer.parseInt(textoCiclos.getText().toString()) >1) {
                if(Integer.parseInt(textoCiclos.getText().toString())>=11)
                {
                    textoCiclos.setText(String.valueOf((Integer.parseInt(textoCiclos.getText().toString()) - 1)));
                }else
                {
                    textoCiclos.setText("0"+(Integer.parseInt(textoCiclos.getText().toString()) - 1));
                }

            }
        }
        if(v==btnMasCiclos)
        {
            if(Integer.parseInt(textoCiclos.getText().toString()) <99) {

                if(Integer.parseInt(textoCiclos.getText().toString())>=9)
                {
                    textoCiclos.setText(String.valueOf(Integer.parseInt(textoCiclos.getText().toString()) + 1));
                }else
                {
                    textoCiclos.setText("0"+(Integer.parseInt(textoCiclos.getText().toString()) + 1));
                }
            }
        }

    }
}

