package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BowenActivity extends AppCompatActivity {
    private ListView listViewBowen;
    private ArrayList<Author> bowen_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowen);
        bowen_book = new ArrayList<>();
        bowen_book.add(new Author(getString(R.string.bowen_a_street_cat_named_bob_title), getString(R.string.bowen_a_street_cat_named_bob_info), R.drawable.a_street_cat_named_bob));
        bowen_book.add(new Author(getString(R.string.bowen_the_world_according_to_bob_title), getString(R.string.bowen_the_world_according_to_bob_info), R.drawable.the_world_according_to_bob));
        listViewBowen = findViewById(R.id.listViewBowen);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, bowen_book);
        listViewBowen.setAdapter(adapter);
        listViewBowen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author bowen = bowen_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", bowen.getTitle());
                intent.putExtra("info", bowen.getInfo());
                intent.putExtra("resId", bowen.getResId());
                startActivity(intent);
            }
        });
    }
}