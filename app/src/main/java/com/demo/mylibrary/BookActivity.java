package com.demo.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {
    private TextView textViewBookName;
    private TextView textViewBookDesc;
    private ImageView imageViewBook;
    private String title;
    private String info;
    private int resId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        textViewBookName = findViewById(R.id.textViewBookName);
        textViewBookDesc = findViewById(R.id.textViewBooksDesc);
        imageViewBook = findViewById(R.id.imageViewBook);
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        info = intent.getStringExtra("info");
        resId = intent.getIntExtra("resId", -1);
        textViewBookName.setText(title);
        textViewBookDesc.setText(info);
        imageViewBook.setImageResource(resId);

    }
}