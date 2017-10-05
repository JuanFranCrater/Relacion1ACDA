package com.example.tema1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * Esta clase hace la funcion de menu para entrar en las otras activities
 * @author JuanFran
 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
//guardamos los botones y creamos un objeto Intent
    Button btnEj1;
    Button btnEj2;
    Button btnEj3;
    Button btnEj4;
    Intent intnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ini);
        //damos valor a los botones y les asignamos el evento OnClick
    btnEj1 =  (Button) findViewById(R.id.btnEj1);
    btnEj2 =  (Button) findViewById(R.id.btnEj2);
    btnEj3 =  (Button) findViewById(R.id.btnEj3);
    btnEj4 =  (Button) findViewById(R.id.btnEj4);
    btnEj1.setOnClickListener(this);
    btnEj2.setOnClickListener(this);
    btnEj3.setOnClickListener(this);
    btnEj4.setOnClickListener(this);
    }
//Este metodo comprobara cual es boton sobre el que se hace click y abrira la activity necesaria
    @Override
    public void onClick(View view) {
      if(view == btnEj1)
      {
          intnt = new Intent(this,ConversorMonedaActivity.class);
          startActivity(intnt);
      }
      if(view == btnEj2)
      {
          intnt = new Intent(this,WebViewActivity.class);
          startActivity(intnt);
      }
      if(view == btnEj3)
      {
          intnt = new Intent(this,ContadorCafesActivity.class);
          startActivity(intnt);
      }
      if(view == btnEj4)
      {

      }


    }
}
