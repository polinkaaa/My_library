package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LondonActivity extends AppCompatActivity {
    private ListView listViewLondon;
    private ArrayList<Author> london_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_london);
        london_book = new ArrayList<>();
        london_book.add(new Author(getString(R.string.london_white_fang_title), getString(R.string.london_white_fang_info), R.drawable.white_fang));
        london_book.add(new Author(getString(R.string.london_the_call_of_the_wild_title), getString(R.string.london_the_call_of_the_wild_info), R.drawable.the_call_of_the_wild));
        listViewLondon = findViewById(R.id.listViewLondon);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, london_book);
        listViewLondon.setAdapter(adapter);
        listViewLondon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author london = london_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", london.getTitle());
                intent.putExtra("info", london.getInfo());
                intent.putExtra("resId", london.getResId());
                startActivity(intent);
            }
        });
    }
}