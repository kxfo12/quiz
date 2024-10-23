package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Question> questions = new ArrayList<>();
    private TextView textView;
    private Button buttonNext;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private int questionCounter = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createQuestion();
        textView = findViewById(R.id.questionText);
        createQuestionView(0);
        buttonNext = findViewById(R.id.button6);
        buttonNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        questionCounter++;
                        if(questionCounter == questions.size()){
                            int points = countPoints();
                            textView.setText("Everything done, your score: "+Integer.toString(points)+" points");
                            buttonNext.setVisibility(View.INVISIBLE);
                            button1.setVisibility(View.INVISIBLE);
                            button2.setVisibility(View.INVISIBLE);
                            button3.setVisibility(View.INVISIBLE);
                            button4.setVisibility(View.INVISIBLE);
                            button5.setVisibility(View.INVISIBLE);
                        }
                        else {
                            createQuestionView(questionCounter);
                        }

                    }
                }
        );

        button1 = findViewById(R.id.Answer1);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(1);
                    }
                }
        );
        button2 = findViewById(R.id.Answer2);
        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(2);
                    }
                }
        );
        button3 = findViewById(R.id.Answer3);
        button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(3);
                    }
                }
        );
        button4 = findViewById(R.id.Answer4);
        button4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(4);
                    }
                }
        );
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        createQuestionAndHintView(questionCounter);
                    }
                }
        );
    }
    private int countPoints(){
        int pointss = 0;
        for (Question Question : questions) {
            if(Question.isIsAnswerCorrect() == Question.isCorrectAnswer()){
                pointss++;
            }
        }
        return pointss;
    }

    private void chooseOption(int Answer){
        Question Question = questions.get(questionCounter);
        if(Question.isCorrectAnswer() == Answer){
            questions.get(questionCounter).setIsAnswerCorrect();
        }
    }

    private void createQuestionView(int i){
        Question Question = questions.get(i);
        textView.setText(Question.getContent());
        //button1.setText(Question.a1);
        //button2.setText(Question.a2);
        //button3.setText(Question.a3);
        //button4.setText(Question.a4);
    }
    private void createQuestionAndHintView(int i){
        Question Question = questions.get(i);
        //button1.setText(Question.a1);
        //button2.setText(Question.a2);
        //button3.setText(Question.a3);
        //button4.setText(Question.a4);
        textView.setText(Question.getContentAndHint());
    }

    private void createQuestion(){
        questions.add(new Question("Calcharo is the leader of?", "---", "Black Shores", "Ghost Hounds", "Fractsidus", "", 2 ));
        questions.add(new Question("Which are Rover's names?", "---", "Lord arbiter, Overseer, Astral modulator", "The first instance, Astral modulator, General of the midnight rangers", "Lord arbiter, The first instance, Astral modulator", "Overseer, The lord of darkness, Kitty cat", 2 ));
        questions.add(new Question("Who is the Changli's master?", "It was in her companion quest", "Baizhi", "Sentinel Jue", "Rover", "Xuanmio", 4 ));
        questions.add(new Question("How Encore call Aalto?", "---", "father", "Super duper black shores master!", "Uncle", "Xuanmio", 4 ));
    }

}
