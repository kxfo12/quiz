/*package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public TextView questionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionText = findViewById(R.id.questionText);
        setContentView(R.layout.activity_main);
        addQuestions();
        addpod();
        buttonY = findViewById(R.id.button1);
        buttonY.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rightOrWrong = true;
                    }
                }
        );
        buttonN = findViewById(R.id.button2);
        buttonN.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rightOrWrong = false;
                    }
                }
        );
        buttonNext = findViewById(R.id.button4);
        buttonNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(rightOrWrong){
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
        );
        buttonPodpowiedz= findViewById(R.id.button3);
    }

    ArrayList<String> questions = new ArrayList<String>();
    ArrayList<String> podpowiedzi = new ArrayList<String>();
    public int question = 0;

    public int counterOfRightAnswers = 0;
    public boolean rightOrWrong = false;
    private Button buttonY;
    private Button buttonN;
    private Button buttonNext;
    private Button buttonPodpowiedz;

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

    /*public void yes(View view) {
        rightOrWrong = true;
    }

    public void no(View view) {
        rightOrWrong = false;
    }

    public void next(View view) {
        if(rightOrWrong){
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
}*/
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Question> questions = new ArrayList<>();
    private TextView textView;
    private Button buttonNext;
    private Button buttonY;
    private Button buttonNo;
    private int questionCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createQuestions();
        textView = findViewById(R.id.questionText);
        createQuestionView(0);
        buttonNext = findViewById(R.id.button4);
        buttonNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        questionCounter++;
                        if(questionCounter == questions.size()){
                           int points = countPoints();
                           textView.setText("Everything done, your score: "+Integer.toString(points)+" points");
                            buttonNext.setVisibility(View.INVISIBLE);
                            buttonY.setVisibility(View.INVISIBLE);
                            buttonN.setVisibility(View.INVISIBLE);
                        }
                        else {
                            createQuestionView(questionCounter);
                        }

                    }
                }
        );

        buttonY = findViewById(R.id.buttonY);
        buttonY.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(true);
                    }
                }
        );
        buttonN = findViewById(R.id.buttonN);
        buttonN.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseOption(false);
                    }
                }
        );
    }
    private int countPoints(){
        int pointss = 0;
        for (Question Question :questions) {
            if(Question.isIsAnswerCorrect()){
                pointss++;
            }
        }
        return pointss;
    }

    private void chooseOption(boolean Answer){
        Question Question = questions.get(questionCounter);
        if(Question.isCorrectAnswer() == Answer){
            questions.get(questionCounter).setIsAnswerCorrect();
        }
    }

    private void createQuestionView(int i){
        Question Question = questions.get(i);
        textView.setText(Question.getContent());
    }

    private void createQuestion(){
        questions.add(new Question
        ("Is Calcharo the leader of Ghost Hounds?",
                "Who else?" ,
                true));
        questions.add(new Question
("Is Scar in Black Shores",
                "What about Fractsidus?",
                false
                ));
        questions.add(new Question
 ("Is The first instance one of Rover's names",
                "There was 3 names.",
                true
        ));
    }

}
