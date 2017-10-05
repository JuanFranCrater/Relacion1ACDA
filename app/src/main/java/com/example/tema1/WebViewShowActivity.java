package com.example.tema1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.*;
import android.widget.Toast;

public class WebViewShowActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_show);
        webview =(WebView)findViewById(R.id.webView);
        webview.loadUrl("https://www.google.es");
        /*
        try {
            Bundle bld = getIntent().getExtras();
            String stg = bld.getString("url");
            webview.loadUrl("https://www.google.es");

        }catch (Exception e)
        {
            Toast.makeText(this, "URL no valida o error de conexion",Toast.LENGTH_SHORT);
        }
*/
    }
}

