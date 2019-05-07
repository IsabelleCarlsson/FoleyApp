package com.example.foleyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import java.util.Random;

public class ImageActivity extends AppCompatActivity {
    ImageView imageView;
    AudioManager audioManager;
    Sound[] sounds = new Sound[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        audioManager = new AudioManager(this);
        imageView = findViewById(R.id.image);
        setCategory(getIntent());
    }

    private void setCategory(Intent intent) {
        switch (intent.getStringExtra("category")) {
            case "Ambient":
                imageView.setImageResource(R.drawable.nature);
                sounds[0] = Sound.BEE;
                sounds[1] = Sound.FROG;
                sounds[2] = Sound.HAMMERING;
                sounds[3] = Sound.CAN;
                break;
            case "Animal":
                imageView.setImageResource(R.drawable.animal);
                sounds[0] = Sound.CAT;
                sounds[1] = Sound.COW;
                sounds[2] = Sound.PIG;
                sounds[3] = Sound.FROG;
                break;
            case "Annoying":
                imageView.setImageResource(R.drawable.annoying);
                sounds[0] = Sound.VELCRO;
                sounds[1] = Sound.BEE;
                sounds[2] = Sound.COUGH;
                sounds[3] = Sound.ENGINE;
                break;
            case "Human":
                imageView.setImageResource(R.drawable.human);
                sounds[0] = Sound.COUGH;
                sounds[1] = Sound.HELLO;
                sounds[2] = Sound.SIGH;
                sounds[3] = Sound.HAMMERING;
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Random random = new Random();
        int value = random.nextInt(4);
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            audioManager.play(sounds[value]);
            return true;
        }
}
