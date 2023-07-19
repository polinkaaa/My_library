package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MarrsActivity extends AppCompatActivity {
    private ListView listViewMarrs;
    private ArrayList<Author> marrs_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marrs);
        marrs_book = new ArrayList<>();
        marrs_book.add(new Author(getString(R.string.marrs_the_one_title), getString(R.string.marrs_the_one_info), R.drawable.the_one));
        marrs_book.add(new Author(getString(R.string.marrs_the_passengers_title), getString(R.string.marrs_the_passengers_info), R.drawable.the_passengers));
        listViewMarrs = findViewById(R.id.listViewMarrs);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, marrs_book);
        listViewMarrs.setAdapter(adapter);
        listViewMarrs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author marrs = marrs_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", marrs.getTitle());
                intent.putExtra("info", marrs.getInfo());
                intent.putExtra("resId", marrs.getResId());
                startActivity(intent);
            }
        });
    }
}