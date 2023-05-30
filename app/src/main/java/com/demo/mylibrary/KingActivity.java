package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class KingActivity extends AppCompatActivity {
    private ListView listViewKing;
    private ArrayList<Author> king_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_king);
        king_book = new ArrayList<>();
        king_book.add(new Author(getString(R.string.king_112263), getString(R.string.king_112263_info), R.drawable.kennedy));
        king_book.add(new Author(getString(R.string.king_green_mile), getString(R.string.king_green_mile_info), R.drawable.green_mile));
        king_book.add(new Author(getString(R.string.king_misery), getString(R.string.king_misery_info), R.drawable.misery));
        king_book.add(new Author(getString(R.string.king_pet_sematary), getString(R.string.king_pet_sematary_info), R.drawable.pet_sematary));
        king_book.add(new Author(getString(R.string.king_joyland), getString(R.string.king_joyland_info), R.drawable.joyland));
        king_book.add(new Author(getString(R.string.king_shining), getString(R.string.king_shining_info), R.drawable.shining));
        king_book.add(new Author(getString(R.string.king_long_walk), getString(R.string.king_long_walk_info), R.drawable.long_walk));
        listViewKing = findViewById(R.id.listViewKing);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, king_book);
        listViewKing.setAdapter(adapter);
        listViewKing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author king = king_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", king.getTitle());
                intent.putExtra("info", king.getInfo());
                intent.putExtra("resId", king.getResId());
                startActivity(intent);
            }
        });
    }
}