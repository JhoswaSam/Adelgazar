package com.example.adelgazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Dieta extends AppCompatActivity {

    String[] dieta = new String[3] ;

    TextView tituloDieta ;
    TextView descripcionDieta ;
    TextView alimentosDieta ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);

        dieta = getIntent().getExtras().getStringArray("contenido");

        tituloDieta = findViewById(R.id.tituloDieta);
        descripcionDieta = findViewById(R.id.descripcionDieta);
        alimentosDieta = findViewById(R.id.alimentosDieta);

        tituloDieta.setText(dieta[0]);
        descripcionDieta.setText(dieta[1]);
        alimentosDieta.setText(dieta[2]);
    }
}