package com.example.wordmemorization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//단어 상세 페이지
public class WordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        TextView wordview = (TextView)findViewById(R.id.worddetail);
        TextView descview = (TextView)findViewById(R.id.descdetail);
        Button adddeletebtn = (Button)findViewById(R.id.adddeletebtn);

        wordview.setText(getIntent().getStringExtra("word"));
        descview.setText(getIntent().getStringExtra("desc"));

        //이미 있는 단어이면
        if( MainActivity.note.containWord(getIntent().getStringExtra("word")))
            adddeletebtn.setText("단어장에서 삭제");



        adddeletebtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

            }
        });

    }
}
