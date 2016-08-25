package com.erolkaftanoglu.loginandlistviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    Button kullaniciEkle;
    ListView kullanicilar;
    List<String> kullaniciIsimleri;
    MyListViewAdapter myListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        kullaniciEkle = (Button) findViewById(R.id.buttonUserAdd);
        kullaniciEkle.setOnClickListener(this);
        kullanicilar = (ListView) findViewById(R.id.listViewUsers);
        kullaniciIsimleri = new ArrayList<>();
        myListViewAdapter = new MyListViewAdapter(kullaniciIsimleri,this);
        kullanicilar.setAdapter(myListViewAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonUserAdd:
                addUser();
                break;
        }
    }

    int x = 0;
    void addUser(){
        String username = "name: " + x;
        kullaniciIsimleri.add(username);
        Log.v("hello", "user ekle tiklandi ve userlist ekle fonksiyonu çalıştı");
        myListViewAdapter.notifyDataSetChanged();
        x++;


    }

    class MyListViewAdapter extends BaseAdapter{
        List<String> userNames;
        Context context;



        public MyListViewAdapter(List<String> userNames,Context c) {
            this.userNames = userNames;
            this.context = c;

        }

        @Override
        public int getCount() {
            return userNames.size();
        }

        @Override
        public String getItem(int position) {
            return userNames.get(position);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.listview_row,viewGroup,false);
            TextView userName = (TextView) rowView.findViewById(R.id.userName);
            userName.setText(userNames.get(i));
            return rowView;


        }
    }
}
