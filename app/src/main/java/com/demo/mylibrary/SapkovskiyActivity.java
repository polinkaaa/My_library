package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SapkovskiyActivity extends AppCompatActivity {
    private ListView listViewSapkovskiy;
    private ArrayList<Author> sapkovskiy_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sapkovskiy);
        sapkovskiy_book = new ArrayList<>();
        sapkovskiy_book.add(new Author(getString(R.string.sapkovskiy_last_wish_title), getString(R.string.sapkovskiy_last_wish_info), R.drawable.last_wish));
        sapkovskiy_book.add(new Author(getString(R.string.sapkovskiy_sword_of_destiny_title), getString(R.string.sapkovskiy_sword_of_destiny_info), R.drawable.sword_of_destiny));
        sapkovskiy_book.add(new Author(getString(R.string.sapkovskiy_blood_of_elves_title), getString(R.string.sapkovskiy_blood_of_elves_info), R.drawable.blood_of_elves));
        sapkovskiy_book.add(new Author(getString(R.string.sapkovskiy_time_of_contempt_title), getString(R.string.sapkovskiy_time_of_contempt_info), R.drawable.time_of_contempt));
        sapkovskiy_book.add(new Author(getString(R.string.sapkovskiy_baptism_of_fire_title), getString(R.string.sapkovskiy_baptism_of_fire_info), R.drawable.baptism_of_fire));
        sapkovskiy_book.add(new Author(getString(R.string.sapkovskiy_tower_of_swallow_title), getString(R.string.sapkovskiy_tower_of_swallow_info), R.drawable.sword_of_destiny));
        sapkovskiy_book.add(new Author(getString(R.string.sapkovskiy_lady_of_the_lake_title), getString(R.string.sapkovskiy_lady_of_the_lake_info), R.drawable.lady_of_the_lake));
        listViewSapkovskiy = findViewById(R.id.listViewSapkovskiy);
        ArrayAdapter<Author> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, sapkovskiy_book);
        listViewSapkovskiy.setAdapter(adapter);
        listViewSapkovskiy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Author sapkovskiy = sapkovskiy_book.get(position);
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                intent.putExtra("title", sapkovskiy.getTitle());
                intent.putExtra("info", sapkovskiy.getInfo());
                intent.putExtra("resId", sapkovskiy.getResId());
                startActivity(intent);
            }
        });

    }
}