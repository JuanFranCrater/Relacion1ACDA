package com.example.tema1;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edturl;
    Button btnIr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        edturl = (EditText) findViewById(R.id.edtBuscar);
        btnIr = (Button) findViewById(R.id.btnIr);
        btnIr.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btnIr)
        {
            try {
                openWebActivity(edturl.getText().toString());
            }catch (Exception e)
            {
                Toast.makeText(this, "Error",Toast.LENGTH_SHORT);
            }
        }
    }
    public void openWebActivity(String url)
    {
        Bundle bld = new Bundle();
        bld.putString("url",url);
        Intent intent = new Intent(this,WebViewShowActivity.class);
        intent.putExtras(bld);
        startActivity(intent);
    }

}