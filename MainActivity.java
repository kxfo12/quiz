package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addQuestions();
        addpod();
    }

    ArrayList<String> questions = new ArrayList<String>();
    ArrayList<String> podpowiedzi = new ArrayList<String>();
    public int question = 0;
    public TextView questionText = findViewById(R.id.questionText);

    public int counterOfRightAnswers = 0;
    public boolean rightOrWrong = false;
    public Button podpo;
    //podpo = findViewById(R.id.button4);

    public void addQuestions(){
        questions.add("Is Calcharo the leader of Ghost Hounds");
        questions.add("Is Scar in Black Shores");
        questions.add("Is The first instance one of Rover names");
    }
    public void addpod(){
        questions.add("Who else?");
        questions.add("What about Fractsidus");
        questions.add("There was 3 names");
    }

    public void yes(View view) {
        rightOrWrong = true;
    }

    public void no(View view) {
        rightOrWrong = false;
    }

    public void next(View view) {
        if(rightOrWrong == true){
            counterOfRightAnswers += 1;
        }
        question += 1;
        if(question > 3){
            questionText.setText("Koniec quizu, dobre odpowiedzi: "+counterOfRightAnswers);
        }
        else{
            questionText.setText(questions.get(question));
        }
    }
}
