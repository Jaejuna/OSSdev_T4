package com.example.wordmemorization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//단어 리스트
public class NoteFragment extends ListFragment {

    HashMap<String,String> items = new HashMap<String,String>();
    ArrayList<HashMap<String,String>> mem = new ArrayList<HashMap<String,String>>();

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //note = Note.load(0);
        //원래는 로드를 해야 하지만 테스트 코드 이기 때문에 임의의 데이터 추가

        for (int i = 0; i < 20; i++)
            MainActivity.note.put("단어"+i,"단어에 대한 설명"+i);

        //노트의 단어들을 순회하며 리스트뷰에 추가
        for (Map.Entry<String, String> entry : MainActivity.note.getEntrySet()) {
            items = new HashMap<String,String>();
            String temp = new String();

            items.put("word",entry.getKey());
            items.put("desc",entry.getValue());
            mem.add(items);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), mem, android.R.layout.simple_list_item_2,
                new String[]{"word","desc"}, new int[]{android.R.id.text1, android.R.id.text2});

        this.setListAdapter(simpleAdapter) ;
    }

    public void onListItemClick(ListView l, View v, int position, long id){
        Intent intent = new Intent(getActivity(), WordActivity.class);

        Map<String, String> map = (Map<String, String>) this.getListAdapter().getItem(position);

        intent.putExtra("word", map.get("word"));
        intent.putExtra("desc", map.get("desc"));
        startActivity(intent);
    }
}
