package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TurgenevActivity extends AppCompatActivity {
    private ListView listViewTurgenev;
    private ArrayList<Author> turgenev_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turgenev);
        turgenev_book = new ArrayList<>();
        turgenev_book.add(new Author(getString(R.string.turgenev_fathers_and_children_title), getString(R.string.turgenev_fathers_and_children_info), R.drawable.fathers_and_children));
        listViewTurgenev = findViewById(R.id.listViewTurgenev);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, turgenev_book);
        listViewTurgenev.setAdapter(adapter);
        listViewTurgenev.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author turgenev = turgenev_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", turgenev.getTitle());
                intent.putExtra("info", turgenev.getInfo());
                intent.putExtra("resId", turgenev.getResId());
                startActivity(intent);
            }
        });
    }
}