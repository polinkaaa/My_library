package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CarrisiActivity extends AppCompatActivity {
    private ListView listViewCarrisi;
    private ArrayList<Author> carrisi_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrisi);
        carrisi_book = new ArrayList<>();
        carrisi_book.add(new Author(getString(R.string.carrisi_whisperer_title), getString(R.string.carrisi_whisperer_info),R.drawable.whisperer));
        carrisi_book.add(new Author(getString(R.string.carrisi_vanished_ones_title), getString(R.string.carrisi_vanished_ones_info),R.drawable.vanished_ones));
        carrisi_book.add(new Author(getString(R.string.carrisi_house_of_lights_title), getString(R.string.carrisi_house_of_lights_info),R.drawable.house_of_lights));
        carrisi_book.add(new Author(getString(R.string.carrisi_house_without_memories_title), getString(R.string.carrisi_house_without_memories_info), R.drawable.house_without_memories));
        listViewCarrisi = findViewById(R.id.listViewCarrisi);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, carrisi_book);
        listViewCarrisi.setAdapter(adapter);
        listViewCarrisi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author carrisi = carrisi_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", carrisi.getTitle());
                intent.putExtra("info", carrisi.getInfo());
                intent.putExtra("resId", carrisi.getResId());
                startActivity(intent);
            }
        });
    }
}