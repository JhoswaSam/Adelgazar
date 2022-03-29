package com.example.adelgazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

        tituloDieta.setText(dieta[0]);
        descripcionDieta.setText(dieta[1]);
        Log.d("Type",((Object)dieta[2]).getClass().getSimpleName());
        Log.d("Data",dieta[2]);



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
    }
}