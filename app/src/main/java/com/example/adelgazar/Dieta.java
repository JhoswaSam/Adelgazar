package com.example.adelgazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Dieta extends AppCompatActivity {

    String[] dieta = new String[3] ;

    TextView tituloDieta ;
    TextView descripcionDieta ;

    Button navigatorButton;

    LinearLayout alimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );


        dieta = getIntent().getExtras().getStringArray("contenido");

        tituloDieta = findViewById(R.id.tituloDieta);
        descripcionDieta = findViewById(R.id.descripcionDieta);
        alimentos = findViewById(R.id.alimentosDieta);
        navigatorButton = findViewById(R.id.navigatorButton);


        descripcionDieta.setText(dieta[1]);
        tituloDieta.setText(dieta[0]);


        try {
            JSONArray jsonArray = new JSONArray(dieta[2]);

            for (int i = 0; i<jsonArray.length();i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                TextView alimento = new TextView(this);
                alimento.setLayoutParams(lp);
                alimento.setText("- "+jsonObj.getString("nombreAlimento"));
                alimento.setTextSize(20);
                alimentos.addView(alimento);
            }

        } catch (JSONException  e) {
            e.printStackTrace();
        }

        navigatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://www.lavanguardia.com/comer/tendencias/20190106/453919591368/mejores-dietas-2019-adelgazar.html");
            }
        });

    }

    private void gotoURL(String s) {
        Uri uri = Uri.parse(s);
        startActivity (new Intent(Intent.ACTION_VIEW, uri));
    }
}