package com.example.finalprojectmaybe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import _GameMechanics.Game;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Game(this));
    }
}