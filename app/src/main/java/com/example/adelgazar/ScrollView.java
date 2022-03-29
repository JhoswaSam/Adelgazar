package com.example.adelgazar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ScrollView extends AppCompatActivity {

    LinearLayout Dieta1;
    LinearLayout Dieta2;
    LinearLayout Dieta3;
    LinearLayout Dieta4;
    LinearLayout Dieta5;
    LinearLayout Dieta6;
    LinearLayout Dieta7;
    LinearLayout Dieta8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        Dieta1 = findViewById(R.id.dieta1);
        Dieta2 = findViewById(R.id.dieta2);
        Dieta3 = findViewById(R.id.dieta3);
        Dieta4 = findViewById(R.id.dieta4);
        Dieta5 = findViewById(R.id.dieta5);
        Dieta6 = findViewById(R.id.dieta6);
        Dieta7 = findViewById(R.id.dieta7);
        Dieta8 = findViewById(R.id.dieta8);

        Dieta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dieta.class);
                intent.putExtra("contenido",FindData(1));
                startActivity(intent);
            }
        });

        Dieta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dieta.class);
                intent.putExtra("contenido",FindData(2));
                startActivity(intent);
            }
        });

        Dieta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dieta.class);
                intent.putExtra("contenido",FindData(3));
                startActivity(intent);
            }
        });

        Dieta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dieta.class);
                intent.putExtra("contenido",FindData(4));
                startActivity(intent);
            }
        });

        Dieta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dieta.class);
                intent.putExtra("contenido",FindData(5));
                startActivity(intent);
            }
        });

        Dieta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dieta.class);
                intent.putExtra("contenido",FindData(6));
                startActivity(intent);
            }
        });

        Dieta7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dieta.class);
                intent.putExtra("contenido",FindData(7));
                startActivity(intent);
            }
        });

        Dieta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dieta.class);
                intent.putExtra("contenido",FindData(8));
                startActivity(intent);
            }
        });

    }

    @NonNull
    private String[] FindData(int id){
        String jsonFileContent = null;
        String[] Dieta = new String[3] ;
        try {
            jsonFileContent = utilidades.leerJSON(getApplicationContext(), "dietas.json");
            JSONArray jsonArray = new JSONArray(jsonFileContent);

            for (int i = 0; i<jsonArray.length(); i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                if ( jsonObj.getInt("id") == id){
                    Dieta[0] = jsonObj.getString("nombreDieta");
                    Dieta[1] = jsonObj.getString("descripcion");
                    Dieta[2] = String.valueOf(jsonObj.getJSONArray("alimentos"));
                    break;
                }
            }
        } catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return Dieta;
    }
}