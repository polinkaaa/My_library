package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BrownActivity extends AppCompatActivity {
    private ListView listViewBrown;
    private ArrayList<Author> brown_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brown);
        brown_book = new ArrayList<>();
        brown_book.add(new Author(getString(R.string.brown_the_da_vinci_code_title), getString(R.string.brown_the_da_vinci_code_info), R.drawable.the_da_vinci_code));
        brown_book.add(new Author(getString(R.string.brown_digital_fortress_title), getString(R.string.brown_digital_fortress_info), R.drawable.digital_fortress));
        listViewBrown = findViewById(R.id.listViewBrown);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, brown_book);
        listViewBrown.setAdapter(adapter);
        listViewBrown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author brown = brown_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", brown.getTitle());
                intent.putExtra("info", brown.getInfo());
                intent.putExtra("resId", brown.getResId());
                startActivity(intent);
            }
        });
    }
}