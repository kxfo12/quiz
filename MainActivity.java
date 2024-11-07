package com.example.pytania;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Question> questions = new ArrayList<>();
    private TextView textView;
    private Button buttonNext;
    private RadioButton button1;
    private TextView button1Text;
    private RadioButton button2;
    private TextView button2Text;
    private RadioButton button3;
    private TextView button3Text;
    private RadioButton button4;
    private TextView button4Text;
    private Button buttonHint;
    private int questionCounter = 0;
    private int points = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createQuestion();
        textView = findViewById(R.id.questionText);
        button1Text = findViewById(R.id.answer1);
        button2Text = findViewById(R.id.answer2);
        button3Text = findViewById(R.id.answer3);
        button4Text = findViewById(R.id.answer4);
        createQuestionView(0);
        buttonNext = findViewById(R.id.button6);
        buttonNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Question Question = questions.get(questionCounter);
                        switch(Question.isCorrectAnswer()){
                            case 1:
                                if(button1.isChecked()){
                                    points += 1;
                                }
                                break;
                            case 2:
                                if(button2.isChecked()){
                                    points += 1;
                                }
                                break;
                            case 3:
                                if(button3.isChecked()){
                                    points += 1;
                                }
                                break;
                            case 4:
                                if(button4.isChecked()){
                                    points += 1;
                                }
                                break;
                        }
                        questionCounter++;
                        if(questionCounter == questions.size()){
                            textView.setText("Everything done, your score: "+Integer.toString(points)+" points");
                            buttonNext.setVisibility(View.INVISIBLE);
                            button1.setVisibility(View.INVISIBLE);
                            button2.setVisibility(View.INVISIBLE);
                            button3.setVisibility(View.INVISIBLE);
                            button4.setVisibility(View.INVISIBLE);
                            buttonHint.setVisibility(View.INVISIBLE);
                        }
                        else {
                            createQuestionView(questionCounter);
                        }

                    }
                }
        );

        button1 = findViewById(R.id.answer1);
        /*button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(1);
                    }
                }
        );*/
        button2 = findViewById(R.id.answer2);
        /*button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(2);
                    }
                }
        );*/
        button3 = findViewById(R.id.answer3);
        /*button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(3);
                    }
                }
        );*/
        button4 = findViewById(R.id.answer4);
        /*button4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(4);
                    }
                }
        );*/
        buttonHint = findViewById(R.id.buttonHint);
        buttonHint.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        createQuestionAndHintView(questionCounter);
                    }
                }
        );
    }
    /*private int countPoints(){
        int pointss = 0;
        for (Question Question : questions) {
            if(Question.isIsAnswerCorrect() == Question.isCorrectAnswer()){
                pointss++;
            }
        }
        return pointss;
    }*/

    /*private void checkAnswer(int Answer){

        if(Question.isCorrectAnswer() == Answer){
            questions.get(questionCounter).setIsAnswerCorrect();
        }
    }*/

    private void createQuestionView(int i){
        Question Question = questions.get(i);
        textView.setText(Question.getContent());
        button1Text.setText(Question.a1);
        button2Text.setText(Question.a2);
        button3Text.setText(Question.a3);
        button4Text.setText(Question.a4);
    }
    private void createQuestionAndHintView(int i){
        Question Question = questions.get(i);
        button1Text.setText(Question.a1);
        button2Text.setText(Question.a2);
        button3Text.setText(Question.a3);
        button4Text.setText(Question.a4);
        textView.setText(Question.getContentAndHint());
    }

    private void createQuestion(){
        questions.add(new Question("Calcharo is the leader of?", "---", "Black Shores", "Ghost Hounds", "Fractsidus", "Anima Squad", 2 ));
        questions.add(new Question("Which are Rover's names?", "Shorekeeper said all three", "Lord arbiter, Overseer, Astral modulator", "The first instance, Astral modulator, General of the midnight rangers", "Lord arbiter, The first instance, Astral modulator", "Overseer, The lord of darkness, Kitty cat", 3 ));
        questions.add(new Question("Who is the Changli's master?", "It was in her companion quest", "Baizhi", "Sentinel Jue", "Rover", "Xuanmio", 4 ));
        questions.add(new Question("How Encore call Aalto?", "---", "My best friend", "Super duper black shores master!", "Uncle", "Father", 3 ));
    }

}
