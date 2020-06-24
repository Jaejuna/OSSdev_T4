package com.example.wordmemorization;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//단어장 클래스
public class Note {

    //단어쌍(단어, 설명)의 리스트
    HashMap<String, String> words = new HashMap<String,String>();
    private int id;     //단어장 식별 번호, 단어장을 여러개 만들거나 서버에서 제공하는 단어장을 가져오고 저장할때 사용할 수도

    public Note(int id) {

    }
    public Note() {
        this(0);
    }

    public void put(String w, String d){
        words.put(w,d);
    }
    public String getDesc(String w){
        return words.get(w);
    }
    public boolean containWord(String w){
        return words.containsKey(w);
    }
    public Set<Map.Entry<String,String>> getEntrySet(){
        return words.entrySet();
    }
    public int size(){return words.size();}


    //서버(혹은 로컬 파일)에서 불러올 단어장
    public static Note load(int id){

        return null;
    }
    //서버(혹은 로컬 파일)에 저장
    public void save(int id){

    }

}
