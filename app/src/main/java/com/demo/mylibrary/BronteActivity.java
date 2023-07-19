package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BronteActivity extends AppCompatActivity {
    private ListView listViewBronte;
    private ArrayList<Author> bronte_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bronte);
        bronte_book = new ArrayList<>();
        bronte_book.add(new Author(getString(R.string.bronte_jane_eyre_title), getString(R.string.bronte_jane_eyre_info), R.drawable.jane_eyre));
        listViewBronte = findViewById(R.id.listViewBronte);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, bronte_book);
        listViewBronte.setAdapter(adapter);
        listViewBronte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author bronte = bronte_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", bronte.getTitle());
                intent.putExtra("info", bronte.getInfo());
                intent.putExtra("resId", bronte.getResId());
                startActivity(intent);
            }
        });
    }
}