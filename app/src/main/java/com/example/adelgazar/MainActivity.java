package com.example.adelgazar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private final int DURACION_SPLASH = 3000; // 3 seg
    Animation topAnim;
    LottieAnimationView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (LottieAnimationView) findViewById(R.id.logo);

        logo.setAnimation(R.raw.watermelon);
        logo.playAnimation();

        topAnim = AnimationUtils.loadAnimation (this,R.anim.top_animation);
        logo.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,ScrollView.class);
                startActivity(intent);
                finish();
            };
        },DURACION_SPLASH);
    }
}