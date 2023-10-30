package com.example.dssmv_1211066_1210939;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity);

        button = (Button) findViewById(R.id.buttonBooks);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openMenuActivity();
            }
        });
    }

    public void openMenuActivity() {
        Intent intent = new Intent(this, BooksActivity.class);
        startActivity(intent);
    }
}