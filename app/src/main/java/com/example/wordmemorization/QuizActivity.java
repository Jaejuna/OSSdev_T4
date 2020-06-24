package com.example.wordmemorization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    int maxQ    = 10;   //총 문제
    int curQ    = 0;    //현재 문제 번호
    int score   = 0;    //정답 횟수

    String correctkey = null;  //정답 키값(단어)

    Note correct    = new Note();   //정답 단어장
    Note wrong      = new Note();     //오답 단어장



    TextView desc;
    TextView quiznum;
    TextView progress;
    ListView answer;
    ArrayList<String> answers = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        desc        = (TextView)findViewById(R.id.quizdesc);
        quiznum     = (TextView)findViewById(R.id.quiznum);
        progress    = (TextView)findViewById(R.id.progress);
        answer      = (ListView) findViewById(R.id.quizanswer);
        answers = new ArrayList<String>();

        newQ();
        quiznum.setText(curQ+"번 문제");
        progress.setText(curQ+"/"+maxQ);
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, answers);
        answer.setAdapter(Adapter);





    }

    //새로운 문제
    private void newQ(){
        Random rand = new Random();

        answers.clear();
        ++curQ;
        Note note = MainActivity.note;
        int Qnum = rand.nextInt(note.size());
        int i = 0;
        //노트의 단어들을 순회하며 리스트뷰에 추가
        for (Map.Entry<String, String> entry : note.getEntrySet()) {
            if(i++ == Qnum ) {
                correctkey = entry.getKey();
                desc.setText(entry.getValue());
            }
        }
        int answer[] = new int[4];

        for( int j = 0 ; j < 4 ; ++ j) {
            int a = rand.nextInt(note.size());
            for( int k = 0 ; k < j ; ++ k) {
                if( a == answer[k]){
                    --j;
                    break;
                }
            }
        }

        int corrnum = rand.nextInt(4);

        for( int j = 0 ; j < 4 ; ++ j) {
            if( j == corrnum){
                answers.add(j+1+". "+correctkey);
                continue;
            }

            i = 0;
            for (Map.Entry<String, String> entry : note.getEntrySet()) {
                if (i++ == answer[j]) {
                    answers.add(j+1+". "+entry.getKey());
                }
            }
        }


    }


}
