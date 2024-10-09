package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void wrong(View view) {
        Toast.makeText(this, "Przemyśl swoją odpowiedź", Toast.LENGTH_SHORT).show();
    }

    public void wrongbut(View view) {
        Toast.makeText(this, "Przemyśl swoją odpowiedź ale nie jest najgożej", Toast.LENGTH_SHORT).show();
    }

    public void correct(View view) {
        Toast.makeText(this, "Witaj w klubie", Toast.LENGTH_SHORT).show();
    }
}
