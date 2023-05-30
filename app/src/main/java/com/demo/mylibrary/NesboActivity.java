package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NesboActivity extends AppCompatActivity {
    private ListView listViewNesbo;
    private ArrayList<Author> nesbo_book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nesbo);
        nesbo_book = new ArrayList<>();
        nesbo_book.add(new Author(getString(R.string.nesbo_redbreast_title),getString(R.string.nesbo_redbreast_info),R.drawable.redbreast));
        nesbo_book.add(new Author(getString(R.string.nesbo_nemesis_title),getString(R.string.nesbo_nemesis_info),R.drawable.nemesis));
        nesbo_book.add(new Author(getString(R.string.nesbo_devils_star_title),getString(R.string.nesbo_devils_star_info),R.drawable.dewils_star));
        nesbo_book.add(new Author(getString(R.string.nesbo_redeemer_title),getString(R.string.nesbo_redeemer_info),R.drawable.redeemer));
        nesbo_book.add(new Author(getString(R.string.nesbo_snowman_title),getString(R.string.nesbo_snowman_info),R.drawable.snowman));
        nesbo_book.add(new Author(getString(R.string.nesbo_leopard_title),getString(R.string.nesbo_leopard_info),R.drawable.leopard));
        nesbo_book.add(new Author(getString(R.string.nesbo_phantom_title),getString(R.string.nesbo_phantom_info),R.drawable.phantom));
        nesbo_book.add(new Author(getString(R.string.nesbo_police_title),getString(R.string.nesbo_police_info),R.drawable.police));
        nesbo_book.add(new Author(getString(R.string.nesbo_thirst_title),getString(R.string.nesbo_thirst_info),R.drawable.thirst));
        nesbo_book.add(new Author(getString(R.string.nesbo_knife_title),getString(R.string.nesbo_knife_info),R.drawable.knife));
        listViewNesbo = findViewById(R.id.listViewNesbo);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, nesbo_book);
        listViewNesbo.setAdapter(adapter);
        listViewNesbo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author nesbo = nesbo_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", nesbo.getTitle());
                intent.putExtra("info", nesbo.getInfo());
                intent.putExtra("resId", nesbo.getResId());
                startActivity(intent);
            }
        });
    }
}