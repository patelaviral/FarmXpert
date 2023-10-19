package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class languageActivity extends AppCompatActivity {
ImageView eng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        eng = findViewById(R.id.eng1);
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(languageActivity.this,login_Activity2.class));
            }
        });
    }
}