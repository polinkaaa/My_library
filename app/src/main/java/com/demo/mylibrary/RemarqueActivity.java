package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RemarqueActivity extends AppCompatActivity {
    private ListView listViewRemarque;
    private ArrayList<Author> remarque_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remarque);
        remarque_book = new ArrayList<>();
        remarque_book.add(new Author(getString(R.string.remarque_three_comrades_title), getString(R.string.remarque_three_comrades_info), R.drawable.three_comrades));
        remarque_book.add(new Author(getString(R.string.remarque_arch_of_triumph_title), getString(R.string.remarque_arch_of_triumph_info), R.drawable.arch_of_triumph));
        remarque_book.add(new Author(getString(R.string.remarque_the_night_in_lisbon_title), getString(R.string.remarque_the_night_in_lisbon_info), R.drawable.the_night_in_lisbon));
        listViewRemarque = findViewById(R.id.listViewRemarque);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, remarque_book);
        listViewRemarque.setAdapter(adapter);
        listViewRemarque.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author remarque = remarque_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", remarque.getTitle());
                intent.putExtra("info", remarque.getInfo());
                intent.putExtra("resId", remarque.getResId());
                startActivity(intent);
            }
        });
    }
}